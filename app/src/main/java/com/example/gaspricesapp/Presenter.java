package com.example.gaspricesapp;

import android.util.Log;

import java.util.List;

import model.Model;

public class Presenter {

    private MainActivity view;
    private Model model;

    public Presenter(MainActivity view, Model model){
        this.view=view;
        this.model=model;
        model.getPresenter(this);
    }

    public void InsertCommunities()
    {
        model.InsertsBDCommunities();
    }

    public void ShowCommunities()
    {
        List<String> c = model.SetCommunitiesList();
        view.showCommunities(c);
    }

    public void InsertProvinces(int id)
    {
        model.InsertsBDProvinces(id);
    }


    public void ShowProvinces()
    {

        List<String> p = model.SetProvincesList();
        view.showProvinces(p);
    }

    public void InsertTowns(int position)
    {
        Log.d("Status", "PresenterInserTowns llamando a model InserTownsBDT");
        model.InsertsBDTowns(position);
    }

    public void ShowTowns()
    {
        List<String> t = model.SetTownsList();
        Log.d("Status", "PresenterSowTowns llamando a model view.showTowns LA LISTA T" + t.size());
        view.showTowns(t);
    }






}
