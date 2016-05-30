package com.example.dann.testingandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {

    private GridView grid;
    private Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        nextActivityListener();

        grid = (GridView) findViewById(R.id.gridView);
        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FourthActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void nextActivityListener() {
        Button next = (Button) findViewById(R.id.nextActivity4);
        intent = new Intent(this, FifthActivity.class);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
            }
        });
    }
}
