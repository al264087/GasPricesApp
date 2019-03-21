package Model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

    @Database(entities = {Community.class, Province.class, Town.class}, version = 1)
    public abstract class DataBase extends RoomDatabase {
        public abstract MyDao myDao();
    }
