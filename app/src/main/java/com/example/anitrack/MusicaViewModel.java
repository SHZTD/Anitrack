package com.example.anitrack;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class MusicaViewModel extends AndroidViewModel {
    private final MusicaRepositorio musicaRepositorio;

    public MusicaViewModel(@NonNull Application application) {
        super(application);
        musicaRepositorio = new MusicaRepositorio(application);
    }

    public LiveData<List<Musica>> obtenerMeGusta() {
        return musicaRepositorio.obtenerMeGusta();
    }

    public void marcarComo(String categoria, Musica musica) {
        musicaRepositorio.marcarComo(categoria, musica);
    }

    public void eliminar(Musica musica) {
        musicaRepositorio.eliminar(musica);
    }
}
