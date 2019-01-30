package com.aisyah.kopi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView ListView;

    String nama[] = {
            "kopigayo", "kopi java", "kopi semendo", "kopi toraja"
    };

    int gambar [] = {
            R.drawable.gayo, R.drawable.ijenraung, R.drawable.semendo, R.drawable.toraja
    };

    int keterangan [] = {
            R.string.ketGayo, R.string.ketIjenRaung, R.string.ketSemendo, R.string.ketToraja
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView = findViewById(R.id.listview);
        Adapterlist adapterlist = new Adapterlist(this, nama, gambar, keterangan);
        ListView.setAdapter(adapterlist);
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent q = new Intent(getApplicationContext(), DetailActivity.class);
                q.putExtra("nama", nama[position]);
                q.putExtra("gambar", gambar[position]);
                q.putExtra("keterangan", keterangan[position]);
                startActivity(q);

            }
        });

    }
}
