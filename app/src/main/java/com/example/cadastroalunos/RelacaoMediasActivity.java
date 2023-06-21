package com.example.cadastroalunos;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cadastroalunos.R;

public class RelacaoMediasActivity extends AppCompatActivity {

    private Spinner spinnerDisciplina;
    private ListView listViewNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacao_medias);


        spinnerDisciplina = findViewById(R.id.spinnerDisciplina);
        listViewNotas = findViewById(R.id.listViewNotas);

        // Obter a lista de disciplinas
        String[] disciplinas = {"Matemática", "Ciências", "Português", "História"};

        // Criar um ArrayAdapter para o Spinner com as disciplinas
        ArrayAdapter<String> disciplinaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, disciplinas);
        disciplinaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDisciplina.setAdapter(disciplinaAdapter);

        // Obter as notas dos alunos para a disciplina selecionada (você precisa implementar essa lógica)

        // Exemplo de dados para a ListView
        String[] notas = {"Aluno 1: 8.5", "Aluno 2: 9.0", "Aluno 3: 7.5"};

        // Criar um ArrayAdapter para a ListView com as notas
        ArrayAdapter<String> notasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notas);
        listViewNotas.setAdapter(notasAdapter);
    }
}
