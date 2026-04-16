package com.example.librosolidario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialButton btnLogin = findViewById(R.id.btnLogin);
        MaterialButton btnGoogle = findViewById(R.id.btnGoogle);
        MaterialButton btnFacebook = findViewById(R.id.btnFacebook);

        btnLogin.setOnClickListener(v -> {
            Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, InicioActivity.class));
        });

        btnGoogle.setOnClickListener(v ->
            Toast.makeText(this, getString(R.string.login_google_message), Toast.LENGTH_SHORT).show()
        );

        btnFacebook.setOnClickListener(v ->
            Toast.makeText(this, getString(R.string.login_facebook_message), Toast.LENGTH_SHORT).show()
        );
    }
}