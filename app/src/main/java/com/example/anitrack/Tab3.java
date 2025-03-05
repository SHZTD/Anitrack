/*
    Clase donde se muestran todas las pistas de audio
    que han sido categorizadas como Me Gusta
 */

package com.example.anitrack;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.example.anitrack.databinding.FragmentTab3Binding;

import java.util.List;

public class Tab3 extends Fragment {
    private FragmentTab3Binding binding;
    private MusicaViewModel musicaViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_tab2, container, false);
        return (binding = FragmentTab3Binding.inflate(inflater, container, false)).getRoot();
    }
}

