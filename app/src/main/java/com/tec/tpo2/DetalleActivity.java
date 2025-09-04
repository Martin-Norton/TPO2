package com.tec.tpo2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tec.tpo2.databinding.ActivityDetalleBinding;
import com.tec.tpo2.modelo.Libro;

public class DetalleActivity extends AppCompatActivity {
    private DetalleActivityViewModel dv;
    private ActivityDetalleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleActivityViewModel.class);
        dv.getLibroMutable().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                binding.tvTitulo.setText(libro.getTitulo());
                binding.tvAutor.setText(libro.getAutor());
                binding.tvPaginas.setText(String.valueOf(libro.getPaginas()));
                binding.tvAnio.setText(String.valueOf(libro.getAnio()));
                binding.tvEtiqueta.setText(libro.getEtiquetas());
                binding.tvDescripcion.setText(libro.getDescripcion());
                binding.ivImagen.setImageResource(libro.getFoto());
            }
        });
        dv.leerLibro(getIntent());
        binding.btVolver.setOnClickListener(v -> {
            finish();
        });
    }
}