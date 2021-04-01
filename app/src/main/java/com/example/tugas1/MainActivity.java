package com.example.tugas1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), pendaftaran.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    //Deklarasi Variabel
    Button btnLogin;

    EditText edemail, edpassword;

    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan Variabel
        btnLogin=findViewById(R.id.btSignin);

        edemail=findViewById(R.id.edEmail);

        edpassword=findViewById(R.id.edPassword);

        //Membuat fungsi onclick
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user
                nama = edemail.getText().toString();

                password = edpassword.getText().toString();

                String email="fksandi@mail.com";
                String pass = "732745";
                //Mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()){
                    //membuat variabel toast dan menampilkan pesan "Edit text tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email Password wajib di isi!!!",
                            Toast.LENGTH_LONG);
                            t.show();

                } else {

                    //Mengecek apakah isi dari email dan password sudah sama dengan email dan
                    // password yang sudah diset
                    if (nama.equals(email) && password.equals(pass))
                    {
                        //Membuat variabel toast dan menampilkan pesan "Login Sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();
                        //Mmebuat object Bundle
                        Bundle b = new Bundle();
                        //memasukkan value dari variabel nama dengan kunci "a"
                        // dan dimasukkan ke dalam bundle
                        b.putString("a", nama.trim());
                        //memasukkan value dari variabel nama dengan kunci "b"
                        // dan dimasukkan ke dalam bundle
                        b.putString("b", password.trim());
                        //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);
                        //memasukkan bundle ke dalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);
                        //berpindah ke ActivityHasil
                        startActivity(i);

                    } else{
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }
}