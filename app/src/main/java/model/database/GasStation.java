package model.database;

import java.util.List;

import model.Model;

public class GasStation {

    Model model;

  public  List<GasStation> gasList;

  public GasStation(String addres, String price, String latitude, String length) {

        GasStation gasStation = new GasStation(addres,price,latitude, length);
        gasList.add(gasStation);

  }
}

