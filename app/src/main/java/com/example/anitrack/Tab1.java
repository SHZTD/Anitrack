/*
    Clase donde se muestran todas las pistas de audio
    disponibles
 */

package com.example.anitrack;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.anitrack.databinding.FragmentTab1Binding;

public class Tab1 extends Fragment {
    private FragmentTab1Binding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_tab1, container, false);
        return (binding = FragmentTab1Binding.inflate(inflater, container, false)).getRoot();
    }
}