package com.choirunnisa.physicaltest.MenuUtama;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.choirunnisa.physicaltest.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class IdeFragment extends Fragment {


    public IdeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ide, container, false);
    }

}
