package AcquiringData;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.gaspricesapp.R;

import java.util.ArrayList;
import java.util.List;

import Model.Model;
import Model.database.Community;
import androidx.appcompat.app.AppCompatActivity;

public class AcqDataActivity extends AppCompatActivity implements AcqDataView{

    private Spinner communitySpinner;
    private Spinner provinceSpinner;
    private AcqDataPresenter presenter;
    public static final List<Community> communityList=new ArrayList<>();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        communitySpinner=findViewById(R.id.spinner0);
        presenter = new AcqDataPresenter(this, Model.getInstance(getApplicationContext()));
        // Aqui se inicia la llamada a la lista de comunidades
        presenter.onCommunitiesAvailable(communityList);




    }

    @Override
    public void showCommunities(List<String> Communities){

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item    , Communities);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_item);
        communitySpinner.setAdapter(adapter);



    }

    @Override
    public void showProvinces(List<String> Provinces) {

    }

    @Override
    public void showTowns(List<String> Towns) {

    }
}
