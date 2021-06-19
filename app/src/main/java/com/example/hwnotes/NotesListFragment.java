package com.example.hwnotes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class NotesListFragment extends Fragment {
    private LinearLayout linearLayout;

    private final NotesEntity note1 = new NotesEntity("Запись 1", "Сделать дз за 6 и 7 урок");
    private final NotesEntity note2 = new NotesEntity("Запись 2", "Что-то для записи 2");
    private final NotesEntity note3 = new NotesEntity("Запись 3", "Что-то для записи 3333");
    private final NotesEntity note4 = new NotesEntity("Запись 4", "Что-то для записи 444");
    private final NotesEntity note5 = new NotesEntity("Запись 5", "Что-то для записи 55555");
    private final NotesEntity note6 = new NotesEntity("Запись 6", "Что-то для записи 66666");

    interface Controller {
        void openDescriptionNote(NotesEntity notesEntity);
    }

    private void addNotesToList(NotesEntity notesEntity) {
        Button button = new Button(getContext());
        button.setText(notesEntity.toString());
        button.setOnClickListener(v -> {
            ((Controller) getActivity()).openDescriptionNote(notesEntity);
        });
        linearLayout.addView(button);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        linearLayout = view.findViewById(R.id.linear);
        addNotesToList(note1);
        addNotesToList(note2);
        addNotesToList(note3);
        addNotesToList(note4);
        addNotesToList(note5);
        addNotesToList(note6);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof Controller)) {
            throw new RuntimeException("Activity must implement NoteController");
        }
    }
}