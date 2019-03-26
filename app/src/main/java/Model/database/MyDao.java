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
    @Insert
    public void insertGasTypes(List<GasType> gasTypes);




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

    @Update
    void updateGas(GasType gasType);
    @Delete
    void deleteGas(GasType gasType);



    @Query("SELECT * FROM Community ORDER BY name")
    List<Community>allCommunities();

    @Query("SELECT * FROM Province WHERE  community_id == :community_id ORDER BY name")
    List<Province> allProvinces(int community_id);

    @Query("SELECT * FROM Town WHERE  province_id == :province_id ORDER BY name")
    List<Town> allTown(int province_id);

    @Query("SELECT * FROM Town WHERE  province_id == :gas_id ORDER BY name")
    List<GasType> allGas(int gas_id);




}
