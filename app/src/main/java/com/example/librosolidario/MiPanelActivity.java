package com.example.librosolidario;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MiPanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mi_panel);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.panelRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialButton btnBack = findViewById(R.id.btnBackPanel);
        MaterialButton btnMenu = findViewById(R.id.btnMenuPanel);
        btnBack.setOnClickListener(v -> finish());
        btnMenu.setOnClickListener(v -> NavigationMenuHelper.show(this, v));
    }
}
