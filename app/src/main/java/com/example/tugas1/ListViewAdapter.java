package com.example.tugas1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data Layout inflanter
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data arrayList
    private ArrayList<ClassNama> arrayList;

    //Membuat konstriktor ListviewAdapter
    public ListViewAdapter(Context context) {
        //Memberi nilai mContext dengan ontext
        mContext = context;

        //mengatur Layoutinflater dari context uang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikan nilai arrayList dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke arrayList
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    //Membuat class untuk mendeklarasikan tempat untuk meletakkan isi kedalam Listview
    public class ViewHolder {
        //mendeklarasikan vaiabel dengan jenis TextView
        TextView name;
    }

    //Fungsi getCount () mengambilkan jumlah item yang akan ditampilkan dalam List
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return Home_Activity.classNamaArrayList.size();
    }

    //Fungis ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    //tertentu dalam kumpulan data untuk mendapatkan data yang sesuai dari lokasi
    //tertentu dalam pengumpulan data item
    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa objek dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }

    //fungsi mengembalikan nilai dari posisi item ke adapter
    @Override
    public long getItemId(int i) {
        return i;
    }

    //Fungsi ini secara otomatis dipanggil ketika tampilan item List siap untuk
    //ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis data ViewHolder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if (view == null) {

            //membuat objek view holder
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview,null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);
        } else {
            //mengatur holder untuk mengembalikan nilai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        //set item ke TextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getNama());

        //mengembalikan nilai ke variabel view
        return view;
    }
}
