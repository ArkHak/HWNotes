package com.example.hwnotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HeadingNotesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeadingNotesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
            noteEditText.setHint("15.12.2020");
            noteEditText.setTextSize(30);
            layoutView.addView(noteEditText);
        }
    }


    public HeadingNotesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment headingNotesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HeadingNotesFragment newInstance(String param1, String param2) {
        HeadingNotesFragment fragment = new HeadingNotesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
}