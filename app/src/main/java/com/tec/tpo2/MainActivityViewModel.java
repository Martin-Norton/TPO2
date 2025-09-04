package com.tec.tpo2;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tec.tpo2.modelo.Libro;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> mutableLibro;
    private List<Libro> listaLibros;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        listaLibros = new ArrayList<>();
        listaLibros.add(new Libro("Despierta","1234","Anthony De Melo", "Mundo", "Es un super libro", "Autoayuda", 2010, 100, R.drawable.despierta));
        listaLibros.add(new Libro("El día que Nietzsche lloró","5678","Louis Vilton", "Campana", "Alta historia", "Drama", 2005, 302, R.drawable.lloro));
        listaLibros.add(new Libro("Un Mundo Feliz","9123","Aldous Huxley", "Banana", "Una crítica al mundo moderno", "Ciencia ficción", 2013, 235, R.drawable.mundo));
    }
    public LiveData<Libro> getMuteableLibro(){
        if(mutableLibro == null){
            mutableLibro = new MutableLiveData<>();
        }
        return mutableLibro;
    }
    public void Buscar(String titulo){
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                mutableLibro.setValue(libro);
                return;
            }
        }
        mutableLibro.setValue(listaLibros.get(1));
    }
}
