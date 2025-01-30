package com.example.anitrack;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Musica {
    @PrimaryKey(autoGenerate = true)
    // datos base
    int id;
    String nombre, descripcion, autor;
    float valoracion;
    int duracion;
    int imagen;

    public Musica(String nombre, String descripcion, String autor, int duracion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.autor = autor;
        this.duracion = duracion;
        this.imagen = imagen;
    }
}
