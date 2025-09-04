package com.tec.tpo2;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tec.tpo2.modelo.Libro;

public class DetalleActivityViewModel extends AndroidViewModel {
    private MutableLiveData<Libro> mutableLibro;
    public DetalleActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Libro> getLibroMutable(){
        if(mutableLibro==null){
           mutableLibro=new MutableLiveData<>();
        }
        return mutableLibro;
    }
    public void leerLibro(Intent libroIntent){
        Libro libroRecuperado = (Libro)libroIntent.getSerializableExtra("libro");
        mutableLibro.setValue(libroRecuperado);
    }
}
