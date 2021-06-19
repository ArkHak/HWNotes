package com.example.hwnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

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
        boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(isLandscape ? R.id.description_note_container : R.id.container, DescriptionNotesFragment.newInstance(notesEntity))
                .addToBackStack(null)
                .commit();
    }
}