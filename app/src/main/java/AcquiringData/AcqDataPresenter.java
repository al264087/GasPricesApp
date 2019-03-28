package AcquiringData;

import com.android.volley.Response;

import java.util.ArrayList;
import java.util.List;

import Model.Model;
import Model.database.Community;

public class AcqDataPresenter {

    private AcqDataView view;
    private Model model;


    public AcqDataPresenter(AcqDataView view, Model model){
        this.view=view;
        this.model=model;
    }

    public void onCommunitiesAvailable(final List<Community> communities){

        model.getCommunities(communities, new Response.Listener<List<Community>>() {
            @Override
            public void onResponse(List<Community> response) {
                List<String> stringCommunities= new ArrayList<>();
                for (Community community: communities) {

                  stringCommunities.add(community.toString());
                }
                view.showCommunities(stringCommunities);
            }
        });

    }


}
