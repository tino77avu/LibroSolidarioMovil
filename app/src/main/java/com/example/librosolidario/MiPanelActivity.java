package com.example.librosolidario;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MiPanelActivity extends AppCompatActivity {
    private static final int TAB_MIS_LIBROS = 0;
    private static final int TAB_RECIBIDAS = 1;
    private static final int TAB_ENVIADAS = 2;

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
        TextView tabMisLibros = findViewById(R.id.tabMisLibros);
        TextView tabRecibidas = findViewById(R.id.tabRecibidas);
        TextView tabEnviadas = findViewById(R.id.tabEnviadas);
        LinearLayout contentMisLibros = findViewById(R.id.panelContentMisLibros);
        LinearLayout contentRecibidas = findViewById(R.id.panelContentRecibidas);
        LinearLayout contentEnviadas = findViewById(R.id.panelContentEnviadas);

        btnBack.setOnClickListener(v -> finish());
        btnMenu.setOnClickListener(v -> NavigationMenuHelper.show(this, v));

        tabMisLibros.setOnClickListener(v ->
            selectTab(TAB_MIS_LIBROS, tabMisLibros, tabRecibidas, tabEnviadas, contentMisLibros, contentRecibidas, contentEnviadas)
        );
        tabRecibidas.setOnClickListener(v ->
            selectTab(TAB_RECIBIDAS, tabMisLibros, tabRecibidas, tabEnviadas, contentMisLibros, contentRecibidas, contentEnviadas)
        );
        tabEnviadas.setOnClickListener(v ->
            selectTab(TAB_ENVIADAS, tabMisLibros, tabRecibidas, tabEnviadas, contentMisLibros, contentRecibidas, contentEnviadas)
        );

        selectTab(TAB_MIS_LIBROS, tabMisLibros, tabRecibidas, tabEnviadas, contentMisLibros, contentRecibidas, contentEnviadas);
    }

    private void selectTab(
        int tab,
        TextView tabMisLibros,
        TextView tabRecibidas,
        TextView tabEnviadas,
        LinearLayout contentMisLibros,
        LinearLayout contentRecibidas,
        LinearLayout contentEnviadas
    ) {
        tabMisLibros.setBackgroundResource(tab == TAB_MIS_LIBROS ? R.drawable.shape_tab_panel_active : R.drawable.shape_chip_unselected);
        tabRecibidas.setBackgroundResource(tab == TAB_RECIBIDAS ? R.drawable.shape_tab_panel_active : R.drawable.shape_chip_unselected);
        tabEnviadas.setBackgroundResource(tab == TAB_ENVIADAS ? R.drawable.shape_tab_panel_active : R.drawable.shape_chip_unselected);

        int activeColor = getColor(R.color.brand_text_title);
        int inactiveColor = getColor(R.color.brand_text_body);
        tabMisLibros.setTextColor(tab == TAB_MIS_LIBROS ? activeColor : inactiveColor);
        tabRecibidas.setTextColor(tab == TAB_RECIBIDAS ? activeColor : inactiveColor);
        tabEnviadas.setTextColor(tab == TAB_ENVIADAS ? activeColor : inactiveColor);

        contentMisLibros.setVisibility(tab == TAB_MIS_LIBROS ? LinearLayout.VISIBLE : LinearLayout.GONE);
        contentRecibidas.setVisibility(tab == TAB_RECIBIDAS ? LinearLayout.VISIBLE : LinearLayout.GONE);
        contentEnviadas.setVisibility(tab == TAB_ENVIADAS ? LinearLayout.VISIBLE : LinearLayout.GONE);
    }
}
