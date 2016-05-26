package com.example.dann.testingandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button actionButton;
    private ToggleButton toggleBtn;
    private TextView viewTxt, viewList;
    private ArrayList<String> data = new ArrayList<>();
    private StringBuffer list;
    private int color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textListListener();
        toggleBtnListener();
        toggleListener();

    }

    public void toggleListener() {

        toggleBtn = (ToggleButton) findViewById(R.id.toggleButton);

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleBtn.isChecked())
                    setUI(true);
                else setUI(false);
            }
        });


    }

    public void textListListener() {

        viewTxt = (TextView) findViewById(R.id.textView);
        actionButton = (Button) findViewById(R.id.testTextView);
        viewList = (TextView) findViewById(R.id.list);


        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*StringBuffer list = new StringBuffer();
                list.append(viewList.getText()).append("\n").append(viewTxt.getText());
                viewList.setText(list);*/

                list = new StringBuffer();

                if (viewTxt != null || String.valueOf(viewTxt.getText()).equals(""))
                    data.add(String.valueOf(viewTxt.getText()));

                for (int cont = 0; cont < data.size(); cont++) {
                    list.append(data.get(cont) + "\n");
                }

                viewList.setText(list);

            }
        });


    }

    public void toggleBtnListener() {
        toggleBtn = (ToggleButton) findViewById(R.id.toggleButton);
        actionButton = (Button) findViewById(R.id.testToggleButton);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleBtn.toggle();

                if (!toggleBtn.isChecked()) {
                    Toast.makeText(MainActivity.this, "We are OFF!!", Toast.LENGTH_SHORT).show();
                    color = R.color.colorPrimaryLight;

                    setUI(false);
                    toggleBtn.setBackgroundColor(color);
                    Log.v("Color Desactivado: ", String.valueOf(color));

                } else {
                    Toast.makeText(MainActivity.this, "We are ON!!", Toast.LENGTH_SHORT).show();
                    color = R.color.colorPrimaryDark;
                    setUI(true);
                    Log.v("Color Activado: ", String.valueOf(color));
                    toggleBtn.setBackgroundColor(color);
                }


            }
        });
    }

    private void setUI(boolean isOn) {
        viewTxt = (TextView) findViewById(R.id.textView);
        actionButton = (Button) findViewById(R.id.testTextView);
        viewList = (TextView) findViewById(R.id.list);

        viewTxt.setEnabled(isOn);
        actionButton.setEnabled(isOn);
        viewList.setEnabled(isOn);
    }

    private void test(String what) {
        Toast.makeText(MainActivity.this, what, Toast.LENGTH_SHORT).show();
    }

}
