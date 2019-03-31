package model.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Community.class,
        parentColumns = "id",
        childColumns = "community_id"), indices = @Index(value = {"community_id"}))


public class Province {

    @NonNull
    @PrimaryKey
    public int id;


    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "community_id")
    public int community_id;




    public Province(int id, String name, int community_id){
        this.id=id;
        this.name=name;
        this.community_id = community_id;
    }
}