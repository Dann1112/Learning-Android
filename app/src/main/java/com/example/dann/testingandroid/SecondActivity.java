package com.example.dann.testingandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button autoTextBtn;
    private AutoCompleteTextView autoTxt;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        autoTextListener();
    }

    private void autoTextListener() {
        autoTextBtn = (Button) findViewById(R.id.testAutoComplete);
        autoTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoTxt = (AutoCompleteTextView) findViewById(R.id.autoComplete);

                if (autoTxt.toString() != null || autoTxt.toString().equals(""))
                    Toast.makeText(null, "Hi " + autoTxt.getText(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
