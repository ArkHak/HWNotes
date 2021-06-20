package com.example.hwnotes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ChangeDescriptionNotesFragment extends Fragment {
    public static final String CHANGE_NOTE_ARGS_KEY = "CHANGE_NOTE_ARGS_KEY";
    private NotesEntity note = null;
    private EditText titleTv;
    private EditText descriptionTv;
    private Button saveChangeNoteButton;

    public static ChangeDescriptionNotesFragment newInstance(NotesEntity notesEntity) {
        ChangeDescriptionNotesFragment changeDescriptionNotesFragment = new ChangeDescriptionNotesFragment();
        Bundle args = new Bundle();

        args.putParcelable(CHANGE_NOTE_ARGS_KEY, notesEntity);

        changeDescriptionNotesFragment.setArguments(args);
        return changeDescriptionNotesFragment;
    }

    public interface Controller {
        void saveNote(NotesEntity notesEntity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_description_note, null);
        titleTv = view.findViewById(R.id.change_title_note);
        descriptionTv = view.findViewById(R.id.change_description_note);
        saveChangeNoteButton = view.findViewById(R.id.save_change_note_button);

        saveChangeNoteButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Изменения записи сохарнены", Toast.LENGTH_SHORT).show();
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
            note = getArguments().getParcelable(CHANGE_NOTE_ARGS_KEY);
        }
    }
}


