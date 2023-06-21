package com.example.cadastroalunos;

import android.os.Parcel;
import android.os.Parcelable;

public class Nota implements Parcelable {
    private int valor;

    public Nota(int valor) {
        this.valor = valor;
    }

    protected Nota(Parcel in) {
        valor = in.readInt();
    }

    public static final Creator<Nota> CREATOR = new Creator<Nota>() {
        @Override
        public Nota createFromParcel(Parcel in) {
            return new Nota(in);
        }

        @Override
        public Nota[] newArray(int size) {
            return new Nota[size];
        }
    };

    public int getValor() {
        return valor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(valor);
    }
}
