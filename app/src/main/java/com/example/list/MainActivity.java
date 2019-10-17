package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] datanama;
    private String[] datadeskripsi;
    private TypedArray datapoto;
    private attaksiadapter adapter;
    private ArrayList<attraksi> places;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new attaksiadapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();
    }

    private void prepare() {
        datanama =getResources().getStringArray(R.array.data_wisata);
        datadeskripsi =getResources().getStringArray(R.array.deskripsi);
        datapoto =getResources().obtainTypedArray(R.array.image);
    }

    private void addItem(){
        places =new ArrayList<>();

        for (int i = 0; i < datanama.length;i++){
            attraksi place =new attraksi();
            place.setImage(datapoto.getResourceId(i,-1));
            place.setPlacename(datadeskripsi[i]);
            places.add(place);
        }
        adapter.setatraksi(places);
    }

}
