package com.example.fragmen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    ImageView gambar;
    TextView name, deskripsi;
    String nama, desc;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        gambar = findViewById(R.id.iv_gambar);
        name = findViewById(R.id.tv_nama);
        deskripsi = findViewById(R.id.tv_deskripsi);
        nama = getIntent().getStringExtra("nama");
        desc = getIntent().getStringExtra("desc");
        image = getIntent().getIntExtra("image", 0);
        gambar.setImageResource(image);
        name.setText(nama);
        deskripsi.setText(desc);
    }
}