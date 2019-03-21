package model.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Community {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public String toString(){
        return " "+name+" ";
    }


    public Community(String name){

        this.name=name;
    }
}



