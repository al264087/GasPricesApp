package Model;

import com.android.volley.Response;

import java.util.List;

import Model.database.Community;

public interface IModel {

    void getCommunities(final List<Community> listaComunidades, final Response.Listener<List<Community>> communitylistener);
}
