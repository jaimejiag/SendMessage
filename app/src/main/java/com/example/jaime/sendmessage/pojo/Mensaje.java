package com.example.jaime.sendmessage.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase modelo para guardar
 */
public class Mensaje implements Parcelable {
    private String user;
    private String message;


    public Mensaje(String user, String message) {
        this.user = user;
        this.message = message;
    }



    protected Mensaje(Parcel in) {
        user = in.readString();
        message = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user);
        dest.writeString(message);
    }

    public static final Creator<Mensaje> CREATOR = new Creator<Mensaje>() {
        @Override
        public Mensaje createFromParcel(Parcel in) {
            return new Mensaje(in);
        }

        @Override
        public Mensaje[] newArray(int size) {
            return new Mensaje[size];
        }
    };


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public boolean equals(Object o) {
        boolean result = true;

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mensaje mensaje1 = (Mensaje) o;
        result = ((message.equals(mensaje1.message)) && (user.equals(mensaje1.user)));

        return result;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
