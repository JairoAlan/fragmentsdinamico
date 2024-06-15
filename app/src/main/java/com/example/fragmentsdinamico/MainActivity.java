package com.example.fragmentsdinamico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    Button btnUno,btnDos,btnTres;
    FragmentAzul fragmentAzul;
    FragmentRojo fragmentRojo;
    FragmentVerde fragmentVerde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnUno = (Button) findViewById(R.id.btnUno);
        btnDos = (Button) findViewById(R.id.btnDos);
        btnTres = (Button) findViewById(R.id.btnTres);

        fragmentAzul = new FragmentAzul();
        fragmentRojo = new FragmentRojo();
        fragmentVerde = new FragmentVerde();

        // Esta aplicacion manda llamar al id del contenedor con fragment Verde
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFrag,fragmentVerde).commit();

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFrag,fragmentVerde);
                transaction.commit();
            }
        });

        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFrag,fragmentAzul);
                transaction.commit();
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFrag,fragmentRojo);
                transaction.commit();
            }
        });


    }
}