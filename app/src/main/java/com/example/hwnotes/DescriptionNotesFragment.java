package com.example.hwnotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DescriptionNotesFragment extends Fragment {
    private NotesEntity note = null;

    private TextView titleTv;
    private TextView descriptionTv;

    public DescriptionNotesFragment(NotesEntity notesEntity) {
        note = notesEntity;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_note, null);
        titleTv = view.findViewById(R.id.title_note);
        descriptionTv = view.findViewById(R.id.description_note);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        titleTv.setText(note.title);
        descriptionTv.setText(note.description);
    }
}


