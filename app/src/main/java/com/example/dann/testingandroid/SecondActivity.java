package com.example.dann.testingandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private Button sayHi;
    private AutoCompleteTextView autoTxt;
    private ArrayList<String> text = new ArrayList<>();
    private String name;
    private Spinner spnr;
    private ArrayAdapter<String> adapt;
    private String[] lang = {"Spanish", "English", "French"};
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        populateSpinner();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        layout = (RelativeLayout) findViewById(R.id.activity2GralLayout);
        switch (item.getOrder()) {
            case 1:
                layout.setBackgroundColor(Color.RED);
                item.setChecked(true);


                break;
            case 2:
                layout.setBackgroundColor(Color.YELLOW);
                item.setChecked(true);
                break;
            case 3:
                layout.setBackgroundColor(Color.GREEN);
                item.setChecked(true);
                break;
            case 4:
                item.setChecked(true);
                layout.setBackgroundColor(getResources().getColor(R.color.colorAccentLight));
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    private void populateSpinner() {

        spnr = (Spinner) findViewById(R.id.spinner);
        adapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lang);
        spnr.setAdapter(adapt);
        spnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sayHi = (Button) findViewById(R.id.sayHello);
                switch (position) {
                    case 0:
                        sayHi.setText("Hola ");
                        break;
                    case 1:
                        sayHi.setText("Hi ");
                        break;
                    case 2:
                        sayHi.setText("Salut ");
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SecondActivity.this, "Nothing has been selected", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void sayHi(View v) {
        autoTxt = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        name = String.valueOf(autoTxt.getText());
        sayHi = (Button) findViewById(R.id.sayHello);

        if (autoTxt != null && !name.equals("")) {
            text.add(String.valueOf(autoTxt.getText()));
            Toast.makeText(SecondActivity.this, sayHi.getText() + name + " !", Toast.LENGTH_SHORT).show();

        } else
            Toast.makeText(SecondActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
    }
}
