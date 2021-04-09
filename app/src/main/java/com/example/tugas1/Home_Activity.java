package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Deklarasi variabel dengan jenis data Listview
    private ListView list;

    //Memanggil class ListviewAdapter dan diinisiai menjadi variabel adapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listNama;

    //Memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //membuat object bundle
    Bundle bundle = new Bundle();

    //Membuat object intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        //Menyimpan nama didalam array ListNama
        listNama = new String[]{"Inayah", "Ilham", "Eris",
                "Fikri", "Maul", "Intan", "Vina", "Gita",
                "Vian", "Lutfi"};
        list = findViewById(R.id.listKontak);

        //membuat objek dari class ClassNama menjadi arrayList
        classNamaArrayList = new ArrayList<>();

        //Membaca seluruh data pada array ListNama
        for (int i = 0; i < listNama.length; i++){
            //membuat objek class nama da
            ClassNama classNama = new ClassNama(listNama[i]);
            //Binds strings ke array
            classNamaArrayList.add(classNama);
        }

        //Membuat objek dari ListViewAdapter
        adapter = new ListViewAdapter(this);

        //Binds Adapte ke ListView
        list.setAdapter(adapter);

        //Mmebuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getNama();

                //memasukkan value dari variabel nama dengan kunci "a"
                //dan dimasukkan kedalam bundle
                bundle.putString("a",nama.trim());

                //membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                //membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);

                //menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

                //menampilkan popup menu
                pm.show();
            }
        });

    }

    //event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}