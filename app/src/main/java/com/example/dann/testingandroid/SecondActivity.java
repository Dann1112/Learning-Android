package com.example.dann.testingandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private Button autoTextBtn;
    private AutoCompleteTextView autoTxt;
    private ArrayList<String> text = new ArrayList<>();
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

    }

    public void sayHi(View v) {
        autoTxt = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        name = String.valueOf(autoTxt.getText());

        if (autoTxt != null && name != "") {
            text.add(String.valueOf(autoTxt.getText()));
            Toast.makeText(SecondActivity.this, "Hi " + name + " !", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(SecondActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
    }
}
