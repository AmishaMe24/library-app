package com.example.libraryapp;

import android.os.Bundle;
import android.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



//protected void onCreate(Bundle savedInstanceState) {
  //      super.onCreate(savedInstanceState);
    //    getActivity().getActionBar().setTitle("Home");
        //  public void onResume(){
        //   super.onResume();
        // ((MainActivity) getActivity()).;
       // }

public class HomeFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }


}

    //}


