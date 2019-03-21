package Model.database;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Province.class,
        parentColumns = "id",
        childColumns = "province_id"), indices = @Index(value ={"province_id"}))


public class Town implements Comparable <Town>, Parcelable {


    @PrimaryKey
    public int id;

    public String name;

    public int province_id;

    public String toString() {
        return " " + name + " ";


    }
    public Town(String name){
        this.name=name;
    }

    @Override
    public int compareTo(Town anotherTown) {
        return anotherTown.toString().compareTo(this.name);
    }



    protected Town(Parcel in) {
        id = in.readInt();
        name = in.readString();
        province_id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(province_id);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Town> CREATOR = new Parcelable.Creator<Town>() {
        @Override
        public Town createFromParcel(Parcel in) {
            return new Town(in);
        }

        @Override
        public Town[] newArray(int size) {
            return new Town[size];
        }
    };
}