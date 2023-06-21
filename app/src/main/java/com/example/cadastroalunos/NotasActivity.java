package com.example.cadastroalunos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        TextView textViewNotas = findViewById(R.id.textViewNotas);

        ArrayList<Aluno> listaAlunos = getIntent().getParcelableArrayListExtra("listaAlunos");

        StringBuilder stringBuilder = new StringBuilder();

        if (listaAlunos != null) {
            for (Aluno aluno : listaAlunos) {
                stringBuilder.append("Nome: ").append(aluno.getNome()).append("\n")
                        .append("Disciplina: ").append(aluno.getDisciplina()).append("\n")
                        .append("Bimestre: ").append(aluno.getBimestre()).append("\n")
                        .append("Nota: ").append(aluno.getNota()).append("\n\n");
            }
        } else {
            stringBuilder.append("Nenhum aluno adicionado.");
        }

        textViewNotas.setText(stringBuilder.toString());
    }
}
