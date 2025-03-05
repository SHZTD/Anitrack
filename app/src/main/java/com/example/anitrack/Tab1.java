package com.example.anitrack;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitrack.databinding.FragmentTab1Binding;

public class Tab1 extends Fragment {
    private FragmentTab1Binding binding;
    private MusicaViewModel musicaViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTab1Binding.inflate(inflater, container, false);
        musicaViewModel = new ViewModelProvider(this).get(MusicaViewModel.class);

        // Crear un objeto de prueba
        Musica musicaEjemplo = new Musica(
                "Nier Automata SqEx",
                "OST de Nier Automata",
                "Square Enix",
                180,
                R.drawable.yorha,
                "test"
        );

        // **Actualizar la UI con los datos de musicaEjemplo**
        binding.tituloExplorador.setText(musicaEjemplo.getTitulo());
        binding.icono.setImageResource(musicaEjemplo.getImagenResource());

        binding.btnMeGusta.setOnClickListener(v -> {
            musicaViewModel.marcarComo("me_gusta", musicaEjemplo);
        });

        binding.btnGuardar.setOnClickListener(v -> {
            musicaViewModel.marcarComo("guardado", musicaEjemplo);
        });

        return binding.getRoot();
    }
}