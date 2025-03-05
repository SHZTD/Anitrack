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

import com.example.anitrack.databinding.FragmentTab2Binding;

import java.util.List;

public class Tab2 extends Fragment {
    private FragmentTab2Binding binding;
    private MusicaViewModel musicaViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_tab2, container, false);
        return (binding = FragmentTab2Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        musicaViewModel = new ViewModelProvider(requireActivity()).get(MusicaViewModel.class);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        // crear el adaptador y asignarlo al RecyclerView
        MusicaAdapter musicaAdapter = new MusicaAdapter();
        binding.recyclerView1.setAdapter(musicaAdapter);

        // observar SOLO las canciones marcadas como "Me gusta"
        musicaViewModel.obtenerMeGusta().observe(getViewLifecycleOwner(), musicas -> {
            musicaAdapter.establecerLista(musicas);
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT  | ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int posicion = viewHolder.getAdapterPosition();
                Musica musica = musicaAdapter.obtenerElemento(posicion);
                musicaViewModel.eliminar(musica);
            }
        }).attachToRecyclerView(binding.recyclerView1);
    }


    class MusicaAdapter extends RecyclerView.Adapter<MusicaViewHolder> {

        // referencia al Array que obtenemos del ViewModel
        List<Musica> musicas;

        // crear un nuevo ViewHolder
        @NonNull
        @Override
        public MusicaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MusicaViewHolder(FragmentTab2Binding.inflate(getLayoutInflater(), parent, false));
        }

        // rellenar un ViewHolder en una posición del Recycler con los datos del elemento que
        // esté en esa misma posición en el Array
        @Override
        public void onBindViewHolder(@NonNull MusicaViewHolder holder, int position) {
            Musica musica = this.musicas.get(position);
            holder.binding.textoTab2.setText(musica.getTitulo());
            holder.binding.tab2Imagen.setImageResource(musica.getImagenResource());
        }

        // informar al Recycler de cuántos elementos habrá en la lista
        @Override
        public int getItemCount() {
            return musicas != null ? musicas.size() : 0;
        }

        // establecer la referencia a la lista, y notificar al Recycler para que se regenere
        public void establecerLista(List<Musica> musicas){
            this.musicas = musicas;
            notifyDataSetChanged();
        }

        public Musica obtenerElemento(int posicion){
            return musicas.get(posicion);
        }
    }

    // Clase para inicializar el ViewBinding en los ViewHolder
    class MusicaViewHolder extends RecyclerView.ViewHolder {
        public final FragmentTab2Binding binding;

        public MusicaViewHolder(FragmentTab2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

