package Model.database;


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


    public Community(int id, String name){

        this.id = id;
        this.name=name;
    }
}



