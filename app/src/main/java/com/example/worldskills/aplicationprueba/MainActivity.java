package com.example.worldskills.aplicationprueba;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Long tiempo;
    CountDownTimer timer;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto= findViewById(R.id.texto);
    }

    public void iniciar(View view) {


        timer= new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempo= millisUntilFinished;
                texto.setText(""+ millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {

            }
        }.start();
    }


    public void detener(View view) {
        texto.setText("Pausa");
        timer.cancel();
    }

    public void replay(View view) {
        CountDownTimer again = new CountDownTimer(tiempo, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                texto.setText(""+ millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
