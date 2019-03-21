package model.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface MyDao {

    @Insert
    public void insertCommunities(List<Community> community);

    @Insert
    public void insertProvinces(List<Province> provinces);
    @Insert
    public void insertTowns(List<Town> towns);
}
