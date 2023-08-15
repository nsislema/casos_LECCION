package com.edu.casos;

import android.os.Parcel;
import android.os.Parcelable;

public class SuperTema implements Parcelable {
    private String name;
    private String alertEgo;
    private String bio;
    private float power;

    public SuperTema(String name, String alertEgo, String bio, float power)
    {
        this.name = name;
        this.alertEgo = alertEgo;
        this.bio = bio;
        this.power = power;
    }
    protected SuperTema(Parcel in) {
        name = in.readString();
        alertEgo = in.readString();
        bio = in.readString();
        power = in.readFloat();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(alertEgo);
        dest.writeString(bio);
        dest.writeFloat(power);
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public static final Creator<SuperTema> CREATOR = new
            Creator<SuperTema>() {
                @Override
                public SuperTema createFromParcel(Parcel in) {
                    return new SuperTema(in);


                }
                @Override
                public SuperTema[] newArray(int size) {
                    return new SuperTema[size];
                }
            };
    public String getName() {
        return name;
    }
    public String getAlertEgo() {
        return alertEgo;
    }
    public String getBio() {
        return bio;
    }
    public float getPower() {
        return power;
    }
}