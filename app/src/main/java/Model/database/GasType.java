package Model.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = GasType.class,
        parentColumns = "id",
        childColumns = "name"), indices = @Index(value = {"gas_id"}))//Falta añadir una columna más


public class GasType {



    @PrimaryKey
    public int id;

    public String gas;
    public String code;

    public String toString() {
        return " " + gas + " ";
    }

    public GasType(int id, String gas, String code) {

        this.id = id;
        this.gas = gas;
        this.code = code;
    }

    }
