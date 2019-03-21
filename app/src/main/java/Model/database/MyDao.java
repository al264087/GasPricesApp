package Model.database;

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
    void updateProvince(Province provinces);
    @Delete
    void deleteProvince(Province provinces);

    @Update
    void updateCommunity(Community community);
    @Delete
    void deleteCommunity(Community community);

    @Update
    void updateTown(Town towns);
    @Delete
    void deleteTowns(Town towns);



    @Query("SELECT * FROM Community")
    Community[] allCommunities();

    @Query("SELECT * FROM Province WHERE  community_id == :community_id")
    Province[] allProvinces(int community_id);

    @Query("SELECT * FROM Town WHERE  province_id == :province_id")
    Town[] allTown(int province_id);




}
