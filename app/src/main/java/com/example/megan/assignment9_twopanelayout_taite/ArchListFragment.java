package com.example.megan.assignment9_twopanelayout_taite;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArchListFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private DaterAdapter adapter;
    public static final String EXTRA_ARCH_ID = "arch_id";
    private Callbacks callbacks;

    public interface Callbacks{
        void onArchSelected(int archId);
    }

    //called when frag gets attached to activity, activity is the context
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //set the callbacks
        //keep track of act. and cast it as callback
        callbacks = (Callbacks)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //detaching frag from act.
        callbacks = null;

    }

    public ArchListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_arch_list, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }


    //to keep changes to edit text when we go back to list view
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    //if adapter empty, set it up for 1st time!
    //else, we called this because data was changed in our edit text
    public void updateUI(){
        ArchSet archSet = ArchSet.getArchSet();
        List<Arch> arch = archSet.getPeople();

        if(adapter == null){
            adapter = new DaterAdapter(arch);
            recyclerView.setAdapter(adapter);
        }
        else{
            adapter.notifyDataSetChanged();
        }

    }

    private class ArchHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView styleName;
        private ImageView ivPicture;
        private TextView comments;
        private int archId;

        public ArchHolder(View itemView) {
            super(itemView);
            styleName = (TextView)itemView.findViewById(R.id.listStyle);
            ivPicture = (ImageView)itemView.findViewById(R.id.listPic);
            comments = (TextView)itemView.findViewById(R.id.listSubtext);
            itemView.setOnClickListener(this);
        }

        public void setArchId(int archId) {
            this.archId = archId;
        }

        @Override
        public void onClick(View view) {
            //tells parent to do something with the person that was picked
            //from there activity decides what to do
            callbacks.onArchSelected(archId);
        }
    }

    private class DaterAdapter extends RecyclerView.Adapter<ArchHolder>{
        private List<Arch> arch;

        public DaterAdapter(List<Arch> arch) {
            this.arch = arch;
        }

        @Override
        public ArchHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View v = inflater.inflate(R.layout.list_item_arch, parent, false);
            return new ArchHolder(v);
        }

        @Override
        public void onBindViewHolder(ArchHolder holder, int position) {
            Arch arch = this.arch.get(position);
            holder.styleName.setText(arch.getStyle());
            holder.ivPicture.setImageResource(arch.getTypePicId());
            holder.comments.setText(arch.getComments());
            holder.setArchId(position);
        }

        @Override
        public int getItemCount() {
            return arch.size();
        }
    }

}
