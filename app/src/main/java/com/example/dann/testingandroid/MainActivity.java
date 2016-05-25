package com.example.dann.testingandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private Button actionButton;
    private ToggleButton toggleBtn;
    private TextView viewTxt, viewList;
    private ArrayList<String> data;
    private Iterator<String> iter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleListener();
        textListListener();

    }

    private void textListListener() {

        viewTxt = (TextView) findViewById(R.id.textView);
        actionButton = (Button) findViewById(R.id.testTextView);
        viewList = (TextView) findViewById(R.id.list);


        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*StringBuffer list = new StringBuffer();
                list.append(viewList.getText()).append("\n").append(viewTxt.getText());
                viewList.setText(list);*/

                data = new ArrayList<>();

                if (viewTxt != null || viewTxt.getText().equals(""))
                    data.add((String) viewTxt.getText());

                for (iter = data.iterator(); iter.hasNext(); iter.next()) {
                    viewList.setText(iter.toString() + "\n");
                }

            }
        });


    }


    private void toggleListener() {
        toggleBtn = (ToggleButton) findViewById(R.id.toggleButton);
        actionButton = (Button) findViewById(R.id.testToggleButton);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleBtn.toggle();

                if(!toggleBtn.isChecked())
                    disableUI();

            }
        });
    }

    private void disableUI() {
        viewTxt = (TextView) findViewById(R.id.textView);
        actionButton = (Button) findViewById(R.id.testTextView);
        viewList = (TextView) findViewById(R.id.list);

        viewTxt.setEnabled(false);
        actionButton.setEnabled(false);
        viewList.setEnabled(false);
    }
}
