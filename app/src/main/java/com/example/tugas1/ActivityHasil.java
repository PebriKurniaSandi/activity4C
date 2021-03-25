package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityHasil extends AppCompatActivity {
    //Mendeklarasikan variabel dengan tipe data TextView
    TextView txEmail, txPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        //Menghubungkan variabel txEmail dengan komponen TextView pada Layout
        txEmail = findViewById(R.id.tvEmail);
        //Menghubungkan variabel txPassword dengan komponen TextView pada Layout
        txPassword = findViewById(R.id.tvPassword);
        //Membuat objek bundle dan mengambil data yang dikirimkan dari activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        //Membuat variabel string yang digunakan untuk menyimpan data yang
        // dikirimkan dari activity sebelemnya dengan kunci "a"
        String email = bundle.getString("a");
        //Membuat variabel string yang digunakan untuk menyimpan data yang
        // dikirimkan dari activity sebelemnya dengan kunci "b"
        String pass = bundle.getString("b");
        //Menampilkan value dari variabel email kedalam txEmail
        txEmail.setText(email);
        //Menampilkan value dari variabel email kedalam txPassword
        txPassword.setText(pass);
    }
}