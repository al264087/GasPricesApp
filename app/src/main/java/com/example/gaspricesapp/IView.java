package com.example.gaspricesapp;

import java.util.List;

interface IView {


    void showCommunities(List<String> Communities);

    void showProvinces(List<String> Provinces);

    void showTowns(List<String> Towns);


   // void showTowns(int province_id, List<String> Towns);

    void showGasTypes();
}


