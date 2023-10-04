package com.example.table_study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ListView listView;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        listView=findViewById(R.id.list);
        seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(25);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                populate(progress);
            }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
        public void populate(int table) {
            ArrayList<String>mulTable=new ArrayList<>();
            for (int i=1;i<=10;i++){
                mulTable.add(table + "X" + i +"=" +table*i);
            }

            ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mulTable);
            if (table!=0){
                listView.setAdapter(arrayAdapter);
                textView.setText("Multiplication Table of " +table);
            }

        }

}