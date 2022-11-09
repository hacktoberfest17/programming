function [im2]=mode_filter(path_to_image)
  im1=imread(path_to_image); %read image
  im2=im1;
  for i=1:3
      % Mode filter used
      im2(:,:,i) = colfilt(im1(:,:,i),[10 10],'sliding',@mode);

  end
  end
