package com.example.librosolidario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_perfil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.perfilRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialButton btnBack = findViewById(R.id.btnBackPerfil);
        MaterialButton btnMenu = findViewById(R.id.btnMenuPerfil);
        MaterialCardView cardImpact = findViewById(R.id.cardPerfilImpacto);
        MaterialCardView cardPublicar = findViewById(R.id.cardPerfilPublicar);
        MaterialCardView cardExplorar = findViewById(R.id.cardPerfilExplorar);
        MaterialCardView cardFavoritos = findViewById(R.id.cardPerfilFavoritos);
        MaterialCardView cardVerImpacto = findViewById(R.id.cardPerfilVerImpacto);

        btnBack.setOnClickListener(v -> finish());
        btnMenu.setOnClickListener(v -> NavigationMenuHelper.show(this, v));

        cardImpact.setOnClickListener(v ->
            startActivity(new Intent(this, ImpactoActivity.class))
        );
        cardPublicar.setOnClickListener(v ->
            startActivity(new Intent(this, CompartirLibroActivity.class))
        );
        cardExplorar.setOnClickListener(v ->
            startActivity(new Intent(this, ExplorarActivity.class))
        );
        cardFavoritos.setOnClickListener(v ->
            Toast.makeText(this, getString(R.string.perfil_favorites_message), Toast.LENGTH_SHORT).show()
        );
        cardVerImpacto.setOnClickListener(v ->
            startActivity(new Intent(this, ImpactoActivity.class))
        );
    }
}
