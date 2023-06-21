package com.example.cadastroalunos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Parcelable {
    private String ra;
    private String nome;
    private String disciplina;
    private String bimestre;
    private double nota;
    private List<Nota> notas;

    public Aluno(String ra, String nome, String disciplina, String bimestre, double nota) {
        this.ra = ra;
        this.nome = nome;
        this.disciplina = disciplina;
        this.bimestre = bimestre;
        this.nota = nota;
        this.notas = new ArrayList<>();
    }

    protected Aluno(Parcel in) {
        ra = in.readString();
        nome = in.readString();
        disciplina = in.readString();
        bimestre = in.readString();
        nota = in.readDouble();
        notas = in.createTypedArrayList(Nota.CREATOR);
    }

    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in);
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getBimestre() {
        return bimestre;
    }

    public double getNota() {
        return nota;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ra);
        dest.writeString(nome);
        dest.writeString(disciplina);
        dest.writeString(bimestre);
        dest.writeDouble(nota);
        dest.writeTypedList(notas);
    }
}
