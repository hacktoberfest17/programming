def Melspectrogram(n_dft, input_shape, trainable, n_hop=None, 
                   border_mode='same', logamplitude=True, sr=22050, 
                   n_mels=128, fmin=0.0, fmax=None, name='melgram'):

    if input_shape is None:
        raise RuntimeError('specify input shape')

    Melgram = Sequential()
    # Prepare STFT.
    x, STFT_magnitude = get_spectrogram_tensors(n_dft, 
                                                n_hop=n_hop, 
                                                border_mode=border_mode, 
                                                input_shape=input_shape,
                                                logamplitude=False) 
    # output: (None, freq, time)
    stft_model = Model(input=x, output=STFT_magnitude, name='stft') 
    stft_model = trainable
    Melgram.add(stft_model)

    # Convert to a proper 2D representation (ndim=4)
    if K.image_dim_ordering() == 'th':
        Melgram.add(Reshape((1,) + stft_model.output_shape[1:],
                            name='reshape_to_2d')) # (None, 1, freq, time)
    else:
        Melgram.add(Reshape(stft_model.output_shape[1:] + (1,),
                            name='reshape_to_2d')) # (None, freq, time, 1)

    # build a Mel filter
    mel_basis = _mel(sr, n_dft, n_mels, fmin, fmax) # (128, 1025) (mel_bin, n_freq)
    mel_basis = np.fliplr(mel_basis) # to make it from low-f to high-freq
    n_freq = mel_basis.shape[1]

    if K.image_dim_ordering() == 'th':
        mel_basis = mel_basis[:, np.newaxis, :, np.newaxis] 
        # print('th', mel_basis.shape)
    else:
        mel_basis = np.transpose(mel_basis, (1, 0))
        mel_basis = mel_basis[:, np.newaxis, np.newaxis, :] 
        # print('tf', mel_basis.shape)
    
    stft2mel = Convolution2D(n_mels, n_freq, 1, border_mode='valid', bias=False,
                            name='stft2mel', weights=[mel_basis])
    stft2mel.trainable = trainable

    Melgram.add(stft2mel) #output: (None, 128, 1, 375) if theano.
    if logamplitude:
        Melgram.add(Logam_layer())
    # i.e. 128ch == 128 mel-bin, for 375 time-step, therefore,
    if K.image_dim_ordering() == 'th':
        Melgram.add(Permute((2, 1, 3), name='ch_freq_time'))
    else:
        Melgram.add(Permute((1, 3, 2), name='ch_freq_time'))
    # output dot product of them
    return Melgram
