package model;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import com.example.gaspricesapp.Presenter;
import com.example.gaspricesapp.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import model.database.Community;
import model.database.DataBase;
import model.database.GasTypes;
import model.database.Province;
import model.database.Town;


public class Model extends AppCompatActivity implements IModel {

    private static Model model;
    Presenter presenter;
    private final Resources resources;


    Context contexto;
    DataBase dataBase;

    Province [] provinces;
    Town [] towns;


    List<Community> listaComunidades = new ArrayList<>();
    List<Town> listaCiudades = new ArrayList<>();
    List<Province> listaProvincias = new ArrayList<>();
    List<GasTypes> listaGasolinas = new ArrayList<>(); //Sacar los datos de la gasofa

    List <String> stringComunidades = new ArrayList<>();
    List <String> stringProvincias= new ArrayList<>();
    List <String> stringTowns= new ArrayList<>();
    List <String> stringGasolinas = new ArrayList<>();

    private Model(Context context) {

        contexto = context;
        dataBase = Room.databaseBuilder(context, DataBase.class, "DataBase").build();
        resources = context.getResources();
    }

    public static Model getInstance(Context context) {

        if (model == null)
        {
            model = new Model(context);
        }
        return model;
    }




    @Override
    public List<String> SetCommunities()
    {
        return stringComunidades;
    }

    @Override
    public void getPresenter(Presenter p){presenter = p;}

    @Override
    public List<String> SetCommunitiesList() {
        return stringComunidades;
    }

    @Override
    public List<String> SetProvinces() {return stringProvincias;}

    @Override
    public List<String> SetProvincesList()
    {
        stringProvincias.clear();
        for(int i = 0; i < provinces.length; i++)
        {
            stringProvincias.add(provinces[i].name);
        }
        return  stringProvincias;
    }

    @Override
    public List<String> SetGasTypes() {return stringGasolinas;}

    @Override
    public List<String> SetGasTypesList() {return stringGasolinas;}

    @Override
    public List<String> SetTowns()
    {
        return stringTowns;
    }

    @Override
    public List<String> SetTownsList()
    {
        stringTowns.clear();
        for(int i = 0 ; i< towns.length; i++)
        {
            stringTowns.add(towns[i].name);
        }
        Log.d("STATUS", "en SET TOWNS LIST , STRINGTOWNS VALE:   "+ stringTowns);
        return stringTowns;
    }



    @Override
    public void InsertsBDCommunities()
    {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                LeerComunidades();
                dataBase.myDao().insertCommunities(listaComunidades);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Log.d("Status", "Hasta aqui llego");
                // presenter.onCommunitiesAvailable();
                presenter.ShowCommunities();

            }
        }.execute();
    }

    @Override
    public void InsertsBDProvinces(final int id)//Revisar ese iDDDDDDDD
    {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                if(listaProvincias.size() == 0)
                {
                    LeerProvincias();
                    dataBase.myDao().insertProvinces(listaProvincias);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                extractProvincesList(id);

            }
        }.execute();
    }


    public void extractProvincesList(final int id) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
              provinces =  dataBase.myDao().provinceCommunity(id);
              return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {

                // presenter.onCommunitiesAvailable();
                presenter.ShowProvinces();
            }
        }.execute();
    }

    @Override
    public void InsertsBDTowns(final int position) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                if(listaCiudades.size() == 0)
                {
                    LeerCiudades();
                    dataBase.myDao().insertTowns(listaCiudades);
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {

                extractTownsList(position);

            }
        }.execute();
    }

    public void extractTownsList(final int position) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

                towns = dataBase.myDao().townProvince(position);
                Log.d("STATUS", "Towns:   " + towns.length);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                presenter.ShowTowns();

            }
        }.execute();
    }

    public void LeerComunidades()
    {

        InputStream stream = resources.openRawResource(R.raw.communities);
        Scanner scanner = new Scanner(stream);

        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            Community community = new Community(Integer.parseInt(linea[0]), linea[1]);
            listaComunidades.add(community);
            stringComunidades.add(community.name);


        }
        scanner.close();
    }




    public void  LeerProvincias ()
    {
        listaProvincias.clear();
        stringProvincias.clear();
        InputStream stream = resources.openRawResource(R.raw.provinces);
        Scanner scanner = new Scanner (stream);

        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            Province province = new Province(Integer.parseInt(linea[0]), linea[1].toString(), Integer.parseInt(linea[2]));
            listaProvincias.add(province);
            }

        scanner.close();
    }
    //Funcion que llama al método que genera el array de provincias
    public void LeerCiudades ()
    {
        listaCiudades.clear();
        stringTowns.clear();

        InputStream stream = resources.openRawResource(R.raw.towns);
        Scanner scanner = new Scanner (stream);

        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            Town town = new Town(Integer.parseInt(linea[0]), linea[1].toString(), Integer.parseInt(linea[2]));
            listaCiudades.add(town);

            }
        scanner.close();

    }

    // se usan en el presenter

/*
    public void getPrices(Town town, GasType type,
                   Response.Listener<List<StationPrice>> listListener,
                   Response.ErrorListener errorListener) {
// ...
    }*/




}