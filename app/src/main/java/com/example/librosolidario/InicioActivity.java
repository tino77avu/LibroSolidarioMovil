package com.example.librosolidario;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class InicioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.inicioRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialButton btnCompartirLibro = findViewById(R.id.btnCompartirLibro);
        MaterialButton btnBuscarLibro = findViewById(R.id.btnBuscarLibro);
        btnCompartirLibro.setOnClickListener(v ->
            startActivity(new Intent(InicioActivity.this, CompartirLibroActivity.class))
        );
        btnBuscarLibro.setOnClickListener(v ->
            startActivity(new Intent(InicioActivity.this, ExplorarActivity.class))
        );
    }
}
