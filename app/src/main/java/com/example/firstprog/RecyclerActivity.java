package com.example.firstprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {
    String[] languages = new String[]{
            "English","Kannada","Hindi","Urdu","Tamil","Telgu",
            "English","Kannada","Hindi","Urdu","Tamil","Telgu",
            "English","Kannada","Hindi","Urdu","Tamil","Telgu",
            "English","Kannada","Hindi","Urdu","Tamil","Telgu",
            "English","Kannada","Hindi","Urdu","Tamil","Telgu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        RecyclerView rView = findViewById(R.id.languagesRview);
        LangsAdapter adapter = new LangsAdapter(languages);
        rView.setLayoutManager(new LinearLayoutManager(this));
        rView.setAdapter(adapter);
    }
}