package com.example.hwnotes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class DescriptionNotesFragment extends Fragment {
    public static final String NOTE_ARGS_KEY = "NOTE_ARGS_KEY";
    private NotesEntity note = null;
    private TextView titleTv;
    private TextView descriptionTv;
    private Button saveChangeNoteButton;

    public static DescriptionNotesFragment newInstance(NotesEntity notesEntity) {
        DescriptionNotesFragment descriptionNotesFragment = new DescriptionNotesFragment();
        Bundle args = new Bundle();

        args.putParcelable(NOTE_ARGS_KEY, notesEntity);

        descriptionNotesFragment.setArguments(args);
        return descriptionNotesFragment;
    }

    public interface Controller {
        void saveNote(NotesEntity notesEntity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_note, null);
        titleTv = view.findViewById(R.id.title_note);
        descriptionTv = view.findViewById(R.id.description_note);
        saveChangeNoteButton = view.findViewById(R.id.save_change_note_button);

        saveChangeNoteButton.setOnClickListener(v -> {
            Controller controller = (Controller) getActivity();
            controller.saveNote(new NotesEntity(
                    titleTv.getText().toString(),
                    descriptionTv.getText().toString()
            ));
        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        titleTv.setText(note.title);
        descriptionTv.setText(note.description);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof Controller)) {
            throw new RuntimeException("Activity must implement NoteController");
        }
        if (getArguments() != null) {
            note = getArguments().getParcelable(NOTE_ARGS_KEY);
        }
    }
}


