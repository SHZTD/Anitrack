package com.example.anitrack;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MusicaViewModel extends AndroidViewModel {

    MusicaRepositorio musicaRepositorio;
    MutableLiveData<List<Musica>> listMusicaMutableLiveData = new MutableLiveData<>();
    MutableLiveData<Musica> musicaSeleccionada = new MutableLiveData<>();

    void seleccionar(Musica musica){
        musicaSeleccionada.setValue(musica);
    }

    MutableLiveData<Musica> seleccionado(){
        return musicaSeleccionada;
    }

    public MusicaViewModel(@NonNull Application application) {
        super(application);
        musicaRepositorio = new MusicaRepositorio(application);
    }

    LiveData<List<Musica>> obtener(){
        return musicaSeleccionada.obtener();
    }

    void insertar(Musica musica){
        musicaSeleccionada.insertar(musica);
    }

    void eliminar(Musica musica){
        musicaSeleccionada.eliminar(musica);
    }

    void actualizar(Musica musica, float valoracion){
        musicaSeleccionada.actualizar(musica, valoracion);
    }
}
