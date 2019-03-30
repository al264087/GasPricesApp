package com.example.gaspricesapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import model.Model;

public class MainActivity extends AppCompatActivity implements IView  {

    private Spinner communitySpinner;
    private Spinner provinceSpinner;
    private Spinner fuellSpinner;

    AutoCompleteTextView towns;
    private Presenter presenter;
    private Model model;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        communitySpinner=findViewById(R.id.spinnerCommunity);
        provinceSpinner = findViewById(R.id.spinnerProvince);
        fuellSpinner = findViewById(R.id.spinnerFuell);

        towns = findViewById(R.id.autoCompleteTextView);
        //showPrices = findViewById(R.id.showp);


        model = Model.getInstance(getApplicationContext());
        presenter = new Presenter(this, model);
        // Aqui se inicia la llamada a la lista de comunidades
        presenter.InsertCommunities();
        //presenter.InsertProvinces();//Version Comentada




    }

    @Override
    public void showCommunities(List<String> communities){

        String [] com = communities.toArray(new String[communities.size()]);

       // Log.d("STATE", ""+ "SHOWCOMMUNITIES" + communities.size());

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,com);
        communitySpinner.setAdapter(adapter);

        communitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               // presenter.InsertProvinces(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

              //  presenter.InsertProvinces(1);
            }
        });



    }



    @Override
    public void showProvinces(int community_id, List<String> provinces) {

        String [] pro = provinces.toArray(new String[provinces.size()]);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,pro);
        provinceSpinner.setAdapter(adapter); //Corroborar

        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               //  presenter.InsertProvinces(position+1); //Version Comentada
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                  //presenter.InsertProvinces(1);  // Versión Comentada
            }
        });


    }

    @Override
    public void showTowns(List<String> Towns) {

    }
}
