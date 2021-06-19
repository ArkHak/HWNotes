package com.example.hwnotes;

import android.os.Parcel;
import android.os.Parcelable;

public class NotesEntity implements Parcelable {
    public String title;
    public String description;

    @Override
    public String toString() {
        return title + ' ' + description;
    }

    public NotesEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    protected NotesEntity(Parcel in) {
        title = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NotesEntity> CREATOR = new Creator<NotesEntity>() {
        @Override
        public NotesEntity createFromParcel(Parcel in) {
            return new NotesEntity(in);
        }

        @Override
        public NotesEntity[] newArray(int size) {
            return new NotesEntity[size];
        }
    };
}
