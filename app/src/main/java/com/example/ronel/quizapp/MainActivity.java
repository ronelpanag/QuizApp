package com.example.ronel.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private TextView txtPregunta, txtPuntos;
    private Button btnVerdadero, btnFalso;
    Preguntas p;
    int tamano;
    ArrayList<Item> r;
    int actual = 0;
    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        txtPregunta = (TextView) findViewById(R.id.txtPregunta);
        txtPuntos = (TextView) findViewById(R.id.txtPuntos);
        btnFalso = (Button) findViewById(R.id.btnFalso);
        btnVerdadero = (Button) findViewById(R.id.btnVerdadero);
        p = new Preguntas();
        tamano = p.pregunta.length;
        r = new ArrayList<>();

        //Para actuaizar la puntuación
        for(int x = 0; x < tamano; x++){
            r.add(new Item(p.getPregunta(x), p.getRespuesta(x)));
        }
        actualizarPizarra(this.puntos(cont));

        //Randomizar las preguntas
        Collections.shuffle(r);

        mostrar(actual);
    }

    //Metodo boton verdadero
    public void verdadero(View v){
        if(actual < tamano) {
            //La respuesta es verdadera
            if (corregir(actual)) {
                actual++;
                Toast.makeText(this, "Excelente", Toast.LENGTH_SHORT).show();
                mostrar(actual);
                cont++;
                actualizarPizarra(this.puntos(cont));

            }
            //La respuesta es falsa
            else {
                actual++;
                Toast.makeText(this, "Fallaste", Toast.LENGTH_SHORT).show();
                mostrar(actual);
            }
        }
        //Se acabó el juego
        else{
            txtPregunta.setText("Game Over");
            Toast.makeText(this, "Terminaste", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Deja el force, ya se acabó el juego", Toast.LENGTH_SHORT).show();
        }

    }

    //Metodo boton falso
    public void falso(View v){
        if(actual < tamano){
            //La respuesta es falsa
            if(!corregir(actual)){
                actual++;
                Toast.makeText(this, "Excelente", Toast.LENGTH_SHORT).show();
                mostrar(actual);
                cont++;
                actualizarPizarra(this.puntos(cont));

            }
            //La respuesta es verdadera
            else{
                actual++;
                Toast.makeText(this, "Fallaste", Toast.LENGTH_SHORT).show();
                mostrar(actual);
            }
            //Se acabó el juego
        }else{
            Toast.makeText(this, "Deja el force, ya se acabó el juego", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Terminaste", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Deja el force, ya se acabó el juego", Toast.LENGTH_SHORT).show();
        }

    }

    private void mostrar(int n){
        txtPregunta.setText(r.get(n).getPregunta());
    }

    //Metodo que corrige las preguntas
    public boolean corregir(int n){
        String respuesta = r.get(n).getRespuesta();
        return respuesta.equals("true");
    }


    public String puntos(int n){
        String puntaje = String.valueOf(n);
        return puntaje;
    }

    public void actualizarPizarra(String t){
        txtPuntos.setText(t);
    }


}
