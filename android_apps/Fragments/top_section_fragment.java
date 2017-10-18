package com.example.rishabh.everythingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class top_section_fragment extends Fragment {

    private static EditText toptextInput;
    private static EditText bottomtextInput;

    TopSectionListener activityCommander;

    //when the main activity has to interact with fragment then we have to create interface
    public interface TopSectionListener{
        public void createMeme(String top,String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander=(TopSectionListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //giving reference to layout file
        View view=inflater.inflate(R.layout.top_section_fragment,container,false);

        toptextInput=(EditText)view.findViewById(R.id.topTextInput);
        bottomtextInput=(EditText)view.findViewById(R.id.bottomTextInput);
        final Button button=(Button)view.findViewById(R.id.button3);

        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttonClicked(v);
                    }
                }
        );

        return view;
    }

    //calls this when button is clicked
    public void buttonClicked(View view){
      activityCommander.createMeme(toptextInput.getText().toString(),bottomtextInput.getText().toString());
    }
}
