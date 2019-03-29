package com.example.gaspricesapp;

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

}
