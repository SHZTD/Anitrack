package com.example.anitrack;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.anitrack.Musica;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MusicaRepositorio {
    AnitrackDB.AniDao aniDao;
    Executor executor = Executors.newSingleThreadExecutor();

    MusicaRepositorio(Application application) {
        aniDao = AnitrackDB.getInstance(application).getAnimeDao();
    }

    LiveData<List<Musica>> obtener() {
        return aniDao.obtener();
    }

    LiveData<List<Musica>> obtenerMeGusta() {
        return aniDao.obtenerMeGusta();
    }

    LiveData<List<Musica>> obtenerGuardados() {
        return aniDao.obtenerGuardados();
    }

    void insertar(Musica musica) {
        executor.execute(() -> aniDao.insertar(musica));
    }

    public void eliminar(Musica musica) {
        executor.execute(() -> aniDao.eliminar(musica));
    }

    void marcarComo(String categoria, Musica musica) {
        executor.execute(() -> aniDao.actualizarCategoria(musica.id, categoria));
    }
}