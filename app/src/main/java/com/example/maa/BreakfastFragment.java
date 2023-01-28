package com.example.maa;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
  * create an instance of this fragment.
 */
public class BreakfastFragment extends Fragment {
RecyclerView recyclerView;
FirebaseDatabase firebaseDatabase;
DatabaseReference database;
List<BreakfastMenu> breakfastList;
long cookId;
    public BreakfastFragment(long id) {
        // Required empty public constructor
        this.cookId=id;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_breakfast, container, false);
        recyclerView= (RecyclerView)view.findViewById(R.id.recycle_view_layout);
        firebaseDatabase=FirebaseDatabase.getInstance();
        database=firebaseDatabase.getReference().child("BreakfastMenu/user1");
        breakfastList=new ArrayList<>();
        ChildEventListener childEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                BreakfastMenu breakfast=snapshot.getValue(BreakfastMenu.class);
                breakfastList.add(breakfast);
                recyclerView.setAdapter(new BreakfastRecycleAdapter(breakfastList,cookId));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        database.addChildEventListener(childEventListener);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

}