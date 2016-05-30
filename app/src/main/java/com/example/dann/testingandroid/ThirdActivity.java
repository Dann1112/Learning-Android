package com.example.dann.testingandroid;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> myAdapter;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        String[] myArray = {"In order", "To use a", "List View", "We can use",
                "An Array Adapter", "It is helpful", "Because it allows you",
                "To adapt dynamically", "The content of a DB", "Into your List View"};

        myAdapter = new ArrayAdapter<>(this, R.layout.list_item, myArray);
        list = (ListView) findViewById(R.id.listLayout);
        list.setAdapter(myAdapter);


        listListener();
        nextActivityListener();

    }

    public void listListener() {
        list = (ListView) findViewById(R.id.listLayout);
        list.setBackgroundColor(Color.WHITE);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView op = (TextView) view;
                ColorDrawable color = (ColorDrawable) op.getBackground();

                if (color.getColor() == Color.WHITE)
                    op.setBackgroundColor(Color.GREEN);

                else if (color.getColor() == Color.GREEN)
                    op.setBackgroundColor(Color.RED);

                else if (color.getColor() == Color.RED)
                    op.setBackgroundColor(Color.BLUE);

                else if (color.getColor() == Color.BLUE)
                    op.setBackgroundColor(Color.GRAY);

                else if (color.getColor() == Color.GRAY)
                    op.setBackgroundColor(Color.CYAN);

                else if (color.getColor() == Color.CYAN)
                    op.setBackgroundColor(Color.BLACK);

                else if (color.getColor() == Color.BLACK)
                    op.setBackgroundColor(Color.WHITE);

            }
        });
    }

    public void nextActivityListener() {
        Button next = (Button) findViewById(R.id.nextActivity3);
        intent = new Intent(this, FourthActivity.class);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);
            }
        });


    }


}
