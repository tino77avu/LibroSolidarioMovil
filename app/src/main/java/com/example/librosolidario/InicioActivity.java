package com.example.librosolidario;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class InicioActivity extends AppCompatActivity {
    private static final String TAG = "LibroSolidario";

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
        MaterialButton btnNotificacionesInicio = findViewById(R.id.btnNotificacionesInicio);
        MaterialButton btnFavoritosInicio = findViewById(R.id.btnFavoritosInicio);
        MaterialButton btnMenuInicio = findViewById(R.id.btnMenuInicio);
        btnCompartirLibro.setOnClickListener(v ->
            startActivity(new Intent(InicioActivity.this, CompartirLibroActivity.class))
        );
        btnBuscarLibro.setOnClickListener(this::openExplorar);
        btnNotificacionesInicio.setOnClickListener(v ->
            new AlertDialog.Builder(this)
                .setTitle(getString(R.string.inicio_notifications_title))
                .setMessage(getString(R.string.inicio_notifications_empty))
                .setPositiveButton(getString(R.string.inicio_notifications_close), null)
                .show()
        );
        btnFavoritosInicio.setOnClickListener(v ->
            Toast.makeText(this, getString(R.string.perfil_favorites_message), Toast.LENGTH_SHORT).show()
        );
        btnMenuInicio.setOnClickListener(v -> NavigationMenuHelper.show(this, v));
    }

    public void openExplorar(View view) {
        try {
            Toast.makeText(this, "Abriendo Explorar", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(InicioActivity.this, ExplorarActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "Error al abrir Explorar", e);
            Toast.makeText(this, "No se pudo abrir Explorar", Toast.LENGTH_SHORT).show();
        }
    }

    public void openMiPanel(View view) {
        startActivity(new Intent(InicioActivity.this, MiPanelActivity.class));
    }

    public void openImpacto(View view) {
        startActivity(new Intent(InicioActivity.this, ImpactoActivity.class));
    }

    public void openPerfil(View view) {
        startActivity(new Intent(InicioActivity.this, PerfilActivity.class));
    }
}
