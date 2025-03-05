package com.example.anitrack;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Database(entities = {Musica.class}, version = 1, exportSchema = false)

public abstract class AnitrackDB extends RoomDatabase {
    private static volatile AnitrackDB INSTANCIA;

    public abstract AniDao getAnimeDao();

    static AnitrackDB getInstance(final Context context) {
        if (INSTANCIA == null) {
            synchronized (AnitrackDB.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                                    AnitrackDB.class, "allElements.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

    @Dao
    interface AniDao {
        @Query("SELECT * FROM Musica")
        LiveData<List<Musica>> obtener();

        @Query("SELECT * FROM Musica /*WHERE categoria = 'Me gusta'*/")
        LiveData<List<Musica>> obtenerMeGusta();

        @Query("SELECT * FROM Musica WHERE categoria = 'Guardado'")
        LiveData<List<Musica>> obtenerGuardados();

        @Insert
        void insertar(Musica musica);

        @Update
        void actualizar(Musica musica);

        @Delete
        void eliminar(Musica musica);

        @Query("UPDATE Musica SET categoria = :categoria WHERE id = :id")
        void actualizarCategoria(int id, String categoria);
    }
}
