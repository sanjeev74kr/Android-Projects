package com.example.maa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class DinnerFragment extends Fragment {
RecyclerView recyclerView;

    public DinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_dinner, container, false);
        recyclerView= (RecyclerView)view.findViewById(R.id.recycle_view_layout);
        recyclerView.setAdapter(new DinnerRecyclerAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }
}