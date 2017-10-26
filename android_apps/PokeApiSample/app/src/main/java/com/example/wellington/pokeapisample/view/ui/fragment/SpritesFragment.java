package com.example.wellington.pokeapisample.view.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wellington.pokeapisample.R;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpritesFragment extends Fragment {

    public static final String SPRITE = "pokeSprite";
    @Bind(R.id.ivSprite)
    ImageView imageView;

    public SpritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sprites, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null){
            String sprite = bundle.getString(SPRITE);

            setSprite(sprite);
        }



        return view;
    }

    private void setSprite(String sprite){
        Picasso.with(getActivity())
                .load(sprite)
                .placeholder(R.drawable.egg)
                .error(R.drawable.error_image)
                .into(imageView);
    }

}
