package com.example.librosolidario;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class ImpactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_impacto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.impactoRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialButton btnBack = findViewById(R.id.btnBackImpacto);
        MaterialButton btnMenu = findViewById(R.id.btnMenuImpacto);
        MaterialButton btnCtaCompartir = findViewById(R.id.btnImpactoCtaCompartir);

        btnBack.setOnClickListener(v -> finish());
        btnMenu.setOnClickListener(v -> NavigationMenuHelper.show(this, v));
        btnCtaCompartir.setOnClickListener(v ->
            startActivity(new Intent(this, CompartirLibroActivity.class))
        );
    }
}
