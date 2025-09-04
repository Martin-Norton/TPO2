package com.tec.tpo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tec.tpo2.databinding.ActivityMainBinding;
import com.tec.tpo2.modelo.Libro;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getMuteableLibro().observe(this, new Observer<Libro>() {
            @Override
            public void onChanged(Libro libro) {
                if (libro != null) {
                    Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                    intent.putExtra("libro", libro);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Libro no encontrado", Toast.LENGTH_LONG).show();
                }
            }
        });
        binding.btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo= binding.etBuscar.getText().toString();
                mv.Buscar(titulo);
            }
        });
    }
}