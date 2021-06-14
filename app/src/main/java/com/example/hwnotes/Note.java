package com.example.hwnotes;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.Locale;

public class Note {
    private String headingNote;
    private String descriptionNote;
    private String dateCreateNote;
    private String timeChangeNote;


    public Note(String headingNote, String descriptionNote) {
        this.headingNote = headingNote;
        this.descriptionNote = descriptionNote;
        this.dateCreateNote = dateCreateNote();
        this.timeChangeNote = dateСhangeNote();
    }

    private String dateCreateNote() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    private String dateСhangeNote() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    public String getHeadingNote() {
        return headingNote;
    }

    public void setHeadingNote(String headingNote) {
        this.headingNote = headingNote;
    }

    public String getDescriptionNote() {
        return descriptionNote;
    }

    public void setDescriptionNote(String descriptionNote) {
        this.descriptionNote = descriptionNote;
    }
}
