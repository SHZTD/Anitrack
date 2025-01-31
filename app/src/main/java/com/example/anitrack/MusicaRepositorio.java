package com.example.anitrack;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MusicaRepositorio {

    AnitrackDB.AniDao aniDao;
    Executor executor = Executors.newSingleThreadExecutor();

    MusicaRepositorio(Application application){
        aniDao = AnitrackDB.getInstance(application).getAnimeDao();
    }

    MusicaRepositorio(){
    }

    LiveData<List<Musica>> obtener(){
        return aniDao.obtener();
    }

    void insertar(Musica musica){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                aniDao.insertar(musica);
            }
        });
    }

    void eliminar(Musica musica) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                aniDao.eliminar(musica);
            }
        });
    }

    public void actualizar(Musica musica, float valoracion) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                musica.valoracion = valoracion;
                aniDao.actualizar(musica);
            }
        });
    }
}