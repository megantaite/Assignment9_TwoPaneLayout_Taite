package com.example.megan.assignment9_twopanelayout_taite;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LaunchFragment extends Fragment {

    View view;

    public LaunchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_launch, container, false);

        ImageButton enterButton = (ImageButton)view.findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity().getApplicationContext(), ArchListActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
