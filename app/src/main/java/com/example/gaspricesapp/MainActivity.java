package com.example.gaspricesapp;

import Model.Model;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IView  {

    Model model;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Aqui van cosas



        model = Model.getInstance(this);
        presenter =  new Presenter(this, model);

    }
}
