package com.example.dann.testingandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        String[] myArray = {"A.M.", "Being There", "Summerteeth", "Yankee Hotel Foxtrot",
                "A Ghost Is Born", "Kicking Television: Live in Chicago", "Sky Blue Sky",
                "Wilco (The Album)", "The Whole Love", "Star Wars"};

        myAdapter = new ArrayAdapter<>(this, R.layout.list_item, myArray);
        list = (ListView) findViewById(R.id.listLayout);
        list.setAdapter(myAdapter);


        listListener();

    }

    public void listListener() {
        list = (ListView) findViewById(R.id.listLayout);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ThirdActivity.this, "Hello " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
