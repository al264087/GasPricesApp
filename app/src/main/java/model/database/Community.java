package model.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Community {

    @NonNull
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    public Community(int id, String name){

        this.id = id;
        this.name=name;
    }
}



