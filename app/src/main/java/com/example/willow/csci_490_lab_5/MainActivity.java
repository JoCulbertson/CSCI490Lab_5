package com.example.willow.csci_490_lab_5;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.willow.csci_490_lab_5.asyncs.MyAsyncTask;
import com.example.willow.csci_490_lab_5.asyncs.MyAsyncTask2;
import com.example.willow.csci_490_lab_5.data.LabDatabase;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "person_db";
    private Button submit;
    private Button listAll;
    private EditText name;
    private LabDatabase personDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = findViewById(R.id.submitButton);
        listAll = findViewById(R.id.listButton);
        name = findViewById(R.id.submitName);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Name: " + name.getText().toString(), Toast.LENGTH_SHORT).show();
                MyAsyncTask myAsyncTask = new MyAsyncTask(personDB);
                myAsyncTask.execute(name.getText().toString());
            }
        });

        listAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "List All accepted", Toast.LENGTH_SHORT).show();
                MyAsyncTask2 myAsyncTask2 = new MyAsyncTask2(getApplicationContext(), personDB);
                myAsyncTask2.execute();
            }
        });

        personDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME).build();
    }
}
