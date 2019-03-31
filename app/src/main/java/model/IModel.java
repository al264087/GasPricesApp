package model;

import com.example.gaspricesapp.Presenter;

import java.util.List;

public interface IModel {
    List<String> SetCommunities();

    void getPresenter(Presenter p);

    List<String> SetCommunitiesList();

    List<String> SetProvinces();

    List<String> SetProvincesList();

    List<String> SetGasTypes();

    List<String> SetGasTypesList();

    void InsertsBDCommunities();

    void InsertsBDProvinces(int id);

    //void getCommunities(final List<Community> listaComunidades, final Response.Listener<List<Community>> communitylistener);


}
