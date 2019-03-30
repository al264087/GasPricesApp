package model.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MyDao {

    @Insert
    public void insertCommunities(List<Community> community);
    @Insert
    public void insertProvinces(List<Province> provinces);
    @Insert
    public void insertTowns(List<Town> towns);





    @Update
    void updateProvince(Province province);
    @Delete
    void deleteProvince(Province province);

    @Update
    void updateCommunity(Community community);
    @Delete
    void deleteCommunity(Community community);

    @Update
    void updateTown(Town town);
    @Delete
    void deleteTown(Town town);





    @Query("SELECT * FROM Community ORDER BY name")
    //List<Community>allCommunities();
    Community[] allCommunities();


    @Query("SELECT * FROM Province  ORDER BY name")
    //List<Province> allProvinces(int community_id);
    Province[] allProvinces();

    @Query("SELECT * FROM Province WHERE id = community_id")
    Province [] provinceCommunity();


    @Query("SELECT * FROM Town  ORDER BY name")
    //List<Town> allTown(int province_id);
    Town[] allTowns();





}
