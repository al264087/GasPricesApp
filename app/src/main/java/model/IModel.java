package model;

import com.example.gaspricesapp.Presenter;

import java.util.List;

public interface IModel {

  //  void getCommunities(final List<Community> listaComunidades, final Response.Listener<List<Community>> communitylistener);

  //  void GetCommunities(List<Community> listaComunidades, Response.Listener<List<Community>> communitylistener);


    void getPresenter(Presenter p);

    List<String> SetCommunitiesList();

    void InsertsBDCommunities();
}
