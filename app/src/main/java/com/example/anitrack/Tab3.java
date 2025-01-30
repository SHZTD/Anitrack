/*
    Clase donde se muestran todas las pistas de audio
    que han sido categorizadas como Guardadas
 */

package com.example.anitrack;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitrack.databinding.FragmentTab3Binding;

public class Tab3 extends Fragment {
    private FragmentTab3Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_tab3, container, false);
        return (binding = FragmentTab3Binding.inflate(inflater, container, false)).getRoot();
    }
}