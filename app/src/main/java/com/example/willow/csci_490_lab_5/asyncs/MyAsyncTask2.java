package com.example.willow.csci_490_lab_5.asyncs;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.willow.csci_490_lab_5.PersonsActivity;
import com.example.willow.csci_490_lab_5.data.LabDatabase;
import com.example.willow.csci_490_lab_5.entities.Person;

import java.util.ArrayList;

/**
 * Created by Willow on 3/15/2018.
 */

public class MyAsyncTask2 extends AsyncTask<Void, Void, ArrayList<Person>> {

    LabDatabase personDB;
    Context context;

    public MyAsyncTask2(Context context, LabDatabase personDB) {
        this.personDB = personDB;
        this.context = context;
    }

    @Override
    protected ArrayList<Person> doInBackground(Void... voids) {
        ArrayList<Person> persons = (ArrayList) personDB.personDao().getAllPersons();
        return persons;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> persons) {
        super.onPostExecute(persons);

        ArrayList<String> personNames = new ArrayList<>();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
    }
}
