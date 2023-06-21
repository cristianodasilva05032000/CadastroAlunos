package com.example.cadastroalunos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button buttonAdicionar;
    private Button buttonVerNotas;
    private Button buttonVerMedias;

    private ArrayList<Aluno> listaAlunos = new ArrayList<>(); // Removemos a palavra-chave "static"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdicionar = findViewById(R.id.buttonAdicionar);
        buttonVerNotas = findViewById(R.id.buttonVerNotas);
        buttonVerMedias = findViewById(R.id.buttonVerMedias);

        EditText editTextRA = findViewById(R.id.editTextRA);
        EditText editTextNome = findViewById(R.id.editTextNome);

        Spinner spinnerDisciplina = findViewById(R.id.spinnerDisciplina);
        String[] disciplinas = {"Matemática", "Ciências", "Português", "História"};

        ArrayAdapter<String> disciplinaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, disciplinas);
        disciplinaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDisciplina.setAdapter(disciplinaAdapter);

        Spinner spinnerBimestre = findViewById(R.id.spinnerBimestre);
        String[] bimestres = {"1º Bimestre", "2º Bimestre", "3º Bimestre", "4º Bimestre"};

        ArrayAdapter<String> bimestreAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bimestres);
        bimestreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBimestre.setAdapter(bimestreAdapter);

        EditText editTextNota = findViewById(R.id.editTextNota);

        buttonAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ra = editTextRA.getText().toString().trim();
                String nome = editTextNome.getText().toString().trim();
                String notaStr = editTextNota.getText().toString().trim();
                String disciplina = spinnerDisciplina.getSelectedItem().toString();
                String bimestre = spinnerBimestre.getSelectedItem().toString();
                double nota = Double.parseDouble(notaStr);

                Aluno aluno = new Aluno(ra, nome, disciplina, bimestre, nota);
                aluno.getNotas().add(new Nota((int) nota)); // Adiciona a nota convertendo para inteiro
                listaAlunos.add(aluno);

                editTextRA.setText("");
                editTextNome.setText("");
                editTextNota.setText("");

                Toast.makeText(MainActivity.this, "Aluno adicionado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonVerNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaAlunos.size() > 0) {
                    Intent intent = new Intent(MainActivity.this, NotasActivity.class);
                    intent.putParcelableArrayListExtra("listaAlunos", listaAlunos);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Nenhum aluno adicionado.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonVerMedias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listaAlunos.size() > 0) {
                    Intent intent = new Intent(MainActivity.this, RelacaoMediasActivity.class);
                    intent.putParcelableArrayListExtra("listaAlunos", listaAlunos);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Nenhum aluno adicionado.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
