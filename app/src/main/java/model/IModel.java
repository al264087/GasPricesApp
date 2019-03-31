package model;

import com.example.gaspricesapp.Presenter;

import java.util.List;

public interface IModel {

   // void getCommunities(final List<Community> listaComunidades, final Response.Listener<List<Community>> communitylistener);

    List<String> SetCommunities();

    void getPresenter(Presenter p);

    List<String> SetCommunitiesList();

    List<String> SetProvinces();

    List<String> SetProvincesList();

    List<String> SetGasTypes();

    List<String> SetGasTypesList();

    List<String> SetTowns();

    List<String> SetTownsList();

    void InsertsBDCommunities();

    void InsertsBDProvinces(int id);

    void InsertsBDTowns(int position);
}
