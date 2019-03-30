package model;

import com.example.gaspricesapp.Presenter;

import java.util.List;

public interface IModel {

 //   void getCommunities(final List<Community> listaComunidades, final Response.Listener<List<Community>> communitylistener);

    List<String> SetCommunities();

    void getPresenter(Presenter p);

    List<String> SetCommunitiesList();

   // List<String> SetProvinces(); Version Comentada

   // List<String> SetProvincesList(); Version Comentada

    //public class RecoverCommunities extends AsyncTask<Void, Void, List<model.database.Community>> {
    void InsertsBDCommunities();

 //   void InsertsBDProvinces(); VersionComentada
}
