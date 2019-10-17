package com.example.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class attaksiadapter extends BaseAdapter {
    private Context context;
    private ArrayList<attraksi> places =new ArrayList<>();

    public void setatraksi(ArrayList<attraksi> places) {
        this.places = places;
    }

    public attaksiadapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() { //mengembalikan isi arraylisnya
        return places.size();
    }

    @Override
    public Object getItem(int i) { //mengembalikan sesuai posisinya
        return places.get(i);
    }

    @Override
    public long getItemId(int i) { //
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { //mengembalikan apa yang kita butuhkan dari rey adpater
        if (view == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.item, viewGroup, false); //memberi isian item place untuk mengisianya
        }

        ViewHolder viewHolder = new ViewHolder(view);
        attraksi places = (attraksi) getItem(i);
        viewHolder.bind(places);
        return view;
    }


    private class ViewHolder{
        private TextView txtnama;
        private  TextView txtdeskripsi;
        private ImageView image;

      ViewHolder (View view){
          txtnama = view.findViewById(R.id.txt_nama);
          txtdeskripsi = view.findViewById(R.id.txt_deskripsi);
          image = view.findViewById(R.id.praw);
      }

      void bind (attraksi places){
          txtnama.setText(places.getPlacename());
          txtdeskripsi.setText(places.getDescription());
          image.setImageResource(places.getImage());
      }
    }
}
