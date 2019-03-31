package com.example.gaspricesapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import model.Model;
import model.database.GasTypes;

public class MainActivity extends AppCompatActivity implements IView  {

    private Spinner communitySpinner;
    private Spinner provinceSpinner;
    private Spinner fuellSpinner;

    AutoCompleteTextView townsTextView;
    private Presenter presenter;
    private Model model;
    private GasTypes gasTypes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        communitySpinner=findViewById(R.id.spinner0);
        provinceSpinner = findViewById(R.id.spinner1);
        fuellSpinner = findViewById(R.id.spinner2);

        townsTextView = findViewById(R.id.autoCompleteTextView);
        //showPrices = findViewById(R.id.showp);

        model = Model.getInstance(getApplicationContext());
        presenter = new Presenter(this, model);
        // Aqui se inicia la llamada a la lista de comunidades
        presenter.InsertCommunities();
        showGasTypes();

    }

    @Override
    public void showCommunities(List<String> communities){

        String [] com = communities.toArray(new String[communities.size()]);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,com);
        communitySpinner.setAdapter(adapter);

        communitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               presenter.InsertProvinces(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void showProvinces(List<String> provinces) {

        String [] pro = provinces.toArray(new String[provinces.size()]);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,pro);
        provinceSpinner.setAdapter(adapter);

        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("STATUS", "POSITION  :" + position);
                  presenter.InsertTowns(position);
                  townsTextView.setText("");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public void showTowns( List<String> Towns) {
        String [] twns = Towns.toArray(new String[Towns.size()]);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item,twns);
        townsTextView.setAdapter(adapter);
        townsTextView.showDropDown();

        townsTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    @Override
    public void showGasTypes()
    {
        GasTypes [] gtgt = gasTypes.values();
        String [] stgt = new String[gtgt.length];

        for(int i = 0; i < gtgt.length; i++)
        {
            stgt[i] = gtgt[i].name;
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,stgt);
        fuellSpinner.setAdapter(adapter);

        fuellSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }

}
