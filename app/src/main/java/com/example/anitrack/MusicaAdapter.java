package com.example.anitrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class MusicaAdapter extends RecyclerView.Adapter<MusicaAdapter.MusicaViewHolder> {
    private List<Musica> musicas = new ArrayList<>();
    private MusicaViewModel musicaViewModel;
    private MusicaRepositorio musicaRepositorio;

    public MusicaAdapter(MusicaViewModel musicaViewModel, MusicaRepositorio musicaRepositorio) {
        this.musicaViewModel = musicaViewModel;
        this.musicaRepositorio = musicaRepositorio;
    }

    @NonNull
    @Override
    public MusicaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_musica, parent, false);
        return new MusicaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicaViewHolder holder, int position) {
        Musica musica = musicas.get(position);
        holder.bind(musica);
    }

    @Override
    public int getItemCount() {
        return musicas.size();
    }

    public void establecerLista(List<Musica> nuevaLista) {
        musicas = nuevaLista;
        notifyDataSetChanged();
    }

    public Musica obtenerElemento(int posicion){
        return musicas.get(posicion);
    }

    class MusicaViewHolder extends RecyclerView.ViewHolder {
        private TextView titulo;
        private ImageView icono;
        private Button btnMeGusta;
        private Button btnGuardar;

        public MusicaViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.tituloMusica);
            icono = itemView.findViewById(R.id.iconoMusica);
            btnMeGusta = itemView.findViewById(R.id.btn_me_gusta_global);
        }

        public void bind(Musica musica) {
            titulo.setText(musica.getTitulo());
            icono.setImageResource(musica.getImagenResource());

            btnMeGusta.setOnClickListener(v -> {
                musicaViewModel.marcarComo("Me gusta", musica);
                musicaRepositorio.insertar(musica);
            });
        }
    }
}

