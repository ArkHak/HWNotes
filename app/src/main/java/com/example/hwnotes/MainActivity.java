package com.example.hwnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DescriptionNotesFragment.Controller, NotesListFragment.Controller {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new NotesListFragment())
                .commit();
    }


    @Override
    public void saveNote(NotesEntity note) {
        //todo
    }

    @Override
    public void openDescriptionNote(NotesEntity notesEntity) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, DescriptionNotesFragment.newInstance(notesEntity))
                .commit();
    }
}