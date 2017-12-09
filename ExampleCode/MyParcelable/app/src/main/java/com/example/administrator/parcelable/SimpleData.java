package com.example.administrator.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2017-11-26.
 */

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel src){
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new SimpleData(source);
        }
        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
