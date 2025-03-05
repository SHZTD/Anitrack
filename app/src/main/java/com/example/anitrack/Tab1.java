package com.example.anitrack;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitrack.databinding.FragmentTab1Binding;

import java.util.ArrayList;
import java.util.List;

public class Tab1 extends Fragment {
    private FragmentTab1Binding binding;
    private MusicaViewModel musicaViewModel;
    private MusicaRepositorio musicaRepositorio;
    private MusicaAdapter musicaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTab1Binding.inflate(inflater, container, false);
        musicaViewModel = new ViewModelProvider(this).get(MusicaViewModel.class);
        musicaRepositorio = new MusicaRepositorio(requireActivity().getApplication());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        musicaAdapter = new MusicaAdapter(musicaViewModel, musicaRepositorio);
        binding.recyclerView.setAdapter(musicaAdapter);

        List<Musica> listaMusica = new ArrayList<>();
        listaMusica.add(new Musica("Nier Automata SqEx", "OST de Nier Automata", "Square Enix", 180, R.drawable.yorha, "null"));
        listaMusica.add(new Musica("Dragon Ball Z", "Dragon Ball OST", "Akira Toriyama", 60, R.drawable.dragonball, "null"));
        listaMusica.add(new Musica("Solo Leveling", "Solo Leveling OST", "Chugong", 180, R.drawable.sl, "null"));
        listaMusica.add(new Musica("Super Mario Bros", "Super Mario Bros OST original", "Nintendo", 60, R.drawable.smb, "null"));
        listaMusica.add(new Musica("Jujutsu Kaisen", "asdfasdfasf", "japan", 60, R.drawable.jjk, "null"));
        musicaAdapter.establecerLista(listaMusica);

        return binding.getRoot();
    }
}