package com.example.willow.csci_490_lab_5.asyncs;

import android.os.AsyncTask;

import com.example.willow.csci_490_lab_5.data.LabDatabase;
import com.example.willow.csci_490_lab_5.entities.Person;

/**
 * Created by Willow on 3/15/2018.
 */

public class MyAsyncTask extends AsyncTask<String, Void, Void> {
    LabDatabase database;

    public MyAsyncTask(LabDatabase database) {this.database = database;}

    @Override
    protected Void doInBackground(String... strings) {
        Person person = new Person();
        person.setName(strings[0]);

        database.personDao().insertPerson(person);
        return null;
    }
}
