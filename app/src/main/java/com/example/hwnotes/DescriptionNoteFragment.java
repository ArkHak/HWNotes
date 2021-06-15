package com.example.hwnotes;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DescriptionNoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DescriptionNoteFragment extends Fragment {

    protected static final String ARG_INDEX = "index";
    private int index;

    public static DescriptionNoteFragment newInstance(int index) {
        DescriptionNoteFragment frag = new DescriptionNoteFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_note, container, false);
        TextView textViewDescriptionNote = view.findViewById(R.id.descriptionNote);
        TypedArray textDescriptionNote = getResources().obtainTypedArray(R.array.description_note);
        textViewDescriptionNote.setText(textDescriptionNote.getText(index));
        textViewDescriptionNote.setTextSize(30);
        return view;
    }
}