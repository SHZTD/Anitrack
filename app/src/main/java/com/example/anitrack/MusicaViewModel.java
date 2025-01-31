package com.example.anitrack;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

// fix
public class MusicaViewModel extends AndroidViewModel {

    MusicaViewModel musicasRepositorio;

    MutableLiveData<List<Musica>> listElementosMutableLiveData = new MutableLiveData<>();

    public MusicaViewModel(@NonNull Application application) {
        super(application);

        musicasRepositorio = new MusicaRepositorio();

        listElementosMutableLiveData.setValue(musicasRepositorio.obtener());
    }

    MutableLiveData<List<Musica>> obtener(){
        return listElementosMutableLiveData;
    }

    void insertar(Musica elemento){
        musicasRepositorio.insertar(elemento, new MusicaRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Elemento> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }

    void eliminar(Musica elemento){
        elementosRepositorio.eliminar(elemento, new ElementosRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Elemento> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }

    void actualizar(Musica musica, float valoracion, MusicaRepositorio.Callback callback){
        elementosRepositorio.actualizar(musica, valoracion, new MusicaRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Musica> elementos) {
                listElementosMutableLiveData.setValue(elementos);
            }
        });
    }
}