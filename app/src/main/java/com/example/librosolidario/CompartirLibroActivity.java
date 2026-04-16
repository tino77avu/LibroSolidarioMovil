package com.example.librosolidario;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class CompartirLibroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compartir_libro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.compartirRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialButton btnRegresar = findViewById(R.id.btnRegresarCompartir);
        MaterialButton btnMenu = findViewById(R.id.btnMenuCompartir);
        btnRegresar.setOnClickListener(v -> finish());
        btnMenu.setOnClickListener(v ->
            Toast.makeText(this, getString(R.string.share_menu_message), Toast.LENGTH_SHORT).show()
        );
    }
}
