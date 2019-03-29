package model.database;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Community.class,
        parentColumns = "id",
        childColumns = "community_id"), indices = @Index(value = {"community_id"}))


public class Province {


    @PrimaryKey
    public int id;

    public String name;

    public int community_id;

    public String toString() {
        return " " + name + " ";


    }
    public Province(int id, String name){
        this.id=id;
        this.name=name;
    }
}