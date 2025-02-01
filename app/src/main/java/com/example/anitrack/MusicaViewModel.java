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

    public MusicaViewModel(@NonNull Application application) {
        super(application);
        musicaRepositorio = new MusicaRepositorio(application);
    }

    public void seleccionar(Musica musica) {
        musicaSeleccionada.setValue(musica);
    }

    public LiveData<Musica> seleccionado() {
        return musicaSeleccionada;
    }

    public LiveData<List<Musica>> obtener() {
        return musicaRepositorio.obtener();
    }

    public void insertar(Musica musica) {
        musicaRepositorio.insertar(musica);
    }

    public void eliminar(Musica musica) {
        musicaRepositorio.eliminar(musica);
    }

    public void actualizar(Musica musica, float valoracion) {
        musicaRepositorio.actualizar(musica, valoracion);
    }
}