package com.example.wellington.pokeapisample.view.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wellington.pokeapisample.R;
import com.example.wellington.pokeapisample.model.Pokemon;
import com.example.wellington.pokeapisample.model.Type;
import com.example.wellington.pokeapisample.presenter.DetailsPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TypeFrangment extends Fragment {

    public static final String TIPO = "pokeList";

    public TypeFrangment() {
        // Required empty public constructor
    }

    @Bind(R.id.type) TextView type;

    private DetailsPresenter mDetailsPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_type, container, false);
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null){
            Pokemon pokemon = (Pokemon) bundle.getSerializable(TIPO);
            setPokemonDetail(pokemon);

        }


        return view;

    }

    private void setPokemonDetail(Pokemon pokemon){
        String types = "";

        for (Type tipo : pokemon.types) {
            types = types + tipo.type.name + "\n";
        }

        type.setText(types);
    }



}
