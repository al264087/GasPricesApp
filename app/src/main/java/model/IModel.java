package model;

import com.android.volley.Response;
import com.example.gaspricesapp.Presenter;

import java.util.List;

import model.database.Community;

public interface IModel {

 //   void getCommunities(final List<Community> listaComunidades, final Response.Listener<List<Community>> communitylistener);

    List<String> SetCommunities();

    void getPresenter(Presenter p);

    List<String> SetCommunitiesList();

    //public class RecoverCommunities extends AsyncTask<Void, Void, List<model.database.Community>> {
    void InsertsBDCommunities();
}
