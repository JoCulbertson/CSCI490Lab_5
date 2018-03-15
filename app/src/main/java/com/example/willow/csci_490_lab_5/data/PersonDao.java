package com.example.willow.csci_490_lab_5.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.willow.csci_490_lab_5.entities.Person;

import java.util.List;

/**
 * Created by Willow on 3/15/2018.
 */

@Dao
public interface PersonDao {
    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();
}
