package com.example.hwnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private NotesEntity note1 = new NotesEntity("Запись 1", "Сделать дз за 6 и 7 уроки");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_fragment_button).setOnClickListener( v -> {
            DescriptionNotesFragment descriptionNotesFragment = new DescriptionNotesFragment(note1);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, descriptionNotesFragment)
                    .commit();
        });
    }
}