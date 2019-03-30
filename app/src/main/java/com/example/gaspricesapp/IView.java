package com.example.gaspricesapp;

import java.util.List;

interface IView {


    void showCommunities(List<String> Communities);

    void showProvinces(int community_id, List<String> Provinces);

    void showTowns(List<String> Towns);
}


