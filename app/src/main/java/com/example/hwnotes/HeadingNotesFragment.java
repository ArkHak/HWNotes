package com.example.hwnotes;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.widget.LinearLayout;
import android.widget.TextView;


public class HeadingNotesFragment extends Fragment {

    public static final String CURRENT_NOTE = "CurrentNote";
    private int currentPosition = 0;
    private boolean isLandscape;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_heading_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListNotes(view);
    }

    private void initListNotes(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.heading_note);

        for (int i = 0; i < notes.length; i++) {
            String note = notes[i];
            TextView noteEditText = new TextView(getContext());
            noteEditText.setText(note);
            noteEditText.setTextSize(30);
            layoutView.addView(noteEditText);
            final int fi = i;
            noteEditText.setOnClickListener(v -> {
                currentPosition = fi;
                showDescriptionNote(currentPosition);
            });
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        isLandscape = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(CURRENT_NOTE, currentPosition);
        super.onSaveInstanceState(outState);
    }


    private void showDescriptionNote(int index) {
        if (isLandscape) {
            showLandDescriptionNote(index);
        } else {
            showPortDescriptionNote(index);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(CURRENT_NOTE, 0);
        }
        if (isLandscape){
            showLandDescriptionNote(currentPosition);
        }
    }

    private void showLandDescriptionNote(int index) {
        DescriptionNoteFragment detail = DescriptionNoteFragment.newInstance(index);

        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.description_note, detail);

        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private void showPortDescriptionNote(int index) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), DescriptionNoteActivity.class);
        intent.putExtra(DescriptionNoteFragment.ARG_INDEX, index);
        startActivity(intent);
    }

}