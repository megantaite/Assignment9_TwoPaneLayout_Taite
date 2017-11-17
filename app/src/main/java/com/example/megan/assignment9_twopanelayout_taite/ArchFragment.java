package com.example.megan.assignment9_twopanelayout_taite;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.editable;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArchFragment extends Fragment {

    private static final String ARGS_ARCH_ID = "arch_id";
    private View view;
    private Arch arch;
    int archId;
    boolean descrOn;
    private Callbacks callbacks;

    public interface Callbacks{
        void onArchUpdated(int archId);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public ArchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        descrOn = false;
        archId = (int)getArguments().getInt(ARGS_ARCH_ID);
        arch = ArchSet.getArchSet().getArch(archId);
    }

    public static ArchFragment newInstance(int archId) {
        Bundle args = new Bundle();
        args.putInt(ARGS_ARCH_ID, archId);
        ArchFragment fragment = new ArchFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_arch, container, false);
        displayDetails();

        final ImageButton descrButton = (ImageButton)view.findViewById(R.id.itemPicture);
        descrButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                descrOn = !descrOn;
                if(descrOn){
                   setDescr();
                }
                else{
                    emptyDescr();
                }
            }
        });

        return view;
    }

    void displayDetails(){
        //set all views
        setArchType();
        setTimePeriod();
        setEleName();
        emptyDescr();
        setImage();
        setComments();
    }

    TextView setArchType(){
        TextView textView = (TextView)view.findViewById(R.id.archType);
        textView.setText(arch.getStyle());
        return textView;
    }

    TextView setTimePeriod(){
        TextView textView = (TextView)view.findViewById(R.id.timePeriod);
        textView.setText(arch.getTimePeriod());
        return textView;
    }

    TextView setEleName(){
        TextView textView = (TextView)view.findViewById(R.id.eleName);
        textView.setText(arch.getElementName());
        return textView;
    }

    TextView setDescr(){
        TextView textView = (TextView)view.findViewById(R.id.description);
        textView.setText(arch.getDescr());
        return textView;
    }

    TextView emptyDescr(){
        TextView textView = (TextView)view.findViewById(R.id.description);
        textView.setText("");
        return textView;
    }

    ImageButton setImage(){
        ImageButton imageButton = (ImageButton)view.findViewById(R.id.itemPicture);
        imageButton.setImageResource(arch.getElePicId());
        return imageButton;
    }

    void setComments(){
        EditText editText = (EditText)view.findViewById(R.id.comments);
        editText.setText(arch.getComments());
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().equals("")){
                    arch.setComments("Your comments here: ");
                }
                else{
                    arch.setComments(editable.toString());
                }
                callbacks.onArchUpdated(archId);
            }
        });
    }



}
