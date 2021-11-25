package com.cursoandroid.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    Funcao usuario = new Funcao();
    Funcao cpu = new Funcao();


    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");

    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");

    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");

    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);
        TextView placarUsuario = findViewById(R.id.placarUsuario);
        TextView placarCpu = findViewById(R.id.placarCpu);

        int numero = new Random().nextInt(3); // 0 1 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {

            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (escolhaApp == "tesoura" && escolhaUsuario == "papel" ||
                escolhaApp == "papel" && escolhaUsuario == "pedra" ||
                escolhaApp == "pedra" && escolhaUsuario == "tesoura") {//App Ganhador
            textoResultado.setText("Você Perdeu :(");
            placarCpu.setText("" + cpu.contador());

        } else if (escolhaUsuario == "tesoura" && escolhaApp == "papel" ||
                escolhaUsuario == "papel" && escolhaApp == "pedra" ||
                escolhaUsuario == "pedra" && escolhaApp == "tesoura") {
            textoResultado.setText("Você Ganhou :)");
            placarUsuario.setText("" + usuario.contador());

        } else {//Empate
            textoResultado.setText("Empatamos! :|");

        }
    }
}
