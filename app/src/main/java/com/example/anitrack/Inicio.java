package com.example.anitrack;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Inicio extends Fragment {
    Button btn1;
    NavController navController;

    TextView texto1;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        btn1 = view.findViewById(R.id.btn1);
        texto1 = view.findViewById(R.id.textView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.tab1);
            }
        });

        texto1.setText(
                "Escucha, guarda o crea playlists\n" +
                        "de OSTs, openings e incluso\n" +
                        "bandas sonoras de animes\n" +
                        "o videojuegos.\n" +
                        "\n" +
                        "Empieza a explorar en Anitrack."
        );

        // centra el texto
        texto1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }
}
