package com.example.anitrack;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "musica")
public class Musica {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String titulo;
    private String descripcion;
    private String autor;
    private int duracion;
    private int imagenResource;
    private String categoria;

    public Musica(String titulo, String descripcion, String autor, int duracion, int imagenResource, String categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.duracion = duracion;
        this.imagenResource = imagenResource;
        this.categoria = categoria;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getAutor() { return autor; }
    public int getDuracion() { return duracion; }
    public int getImagenResource() { return imagenResource; }
    public String getCategoria() { return categoria; }

    public void setId(int id) { this.id = id; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}
