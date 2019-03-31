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
    public List<String> SetProvincesList() {return stringProvincias;}

    @Override
    public List<String> SetGasTypes() {return stringGasolinas;}

    @Override
    public List<String> SetGasTypesList() {return stringGasolinas;}



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
    public void InsertsBDProvinces(final int id)
    {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                LeerProvincias(id);
                dataBase.myDao().insertProvinces(listaProvincias);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Log.d("Status", "Hasta aqui llego");
                // presenter.onCommunitiesAvailable();
                presenter.ShowProvinces();

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

            Log.d("STATUS", "HE METIDO LAS COMUNIDADES");

        }
        Log.d("STATUS", "cantidad: " +stringComunidades.size());
        scanner.close();
    }




    public void  LeerProvincias (final int id)
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
            String community_id = Integer.toString(id);
            String provincia_id = Integer.toString(province.community_id);
            if(community_id.equals(provincia_id)){
                listaProvincias.add(province);
                stringProvincias.add(province.name);
            }

        }
        scanner.close();
    }

    public void LeerCiudades ()
    {
        InputStream stream = resources.openRawResource(R.raw.towns);
        Scanner scanner = new Scanner (stream);

        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");
        //cOGER LA POSICION, ListaProvincias.get(posicion.id)

         //   cp.toString()
            Town town    = new Town(Integer.parseInt(linea[0]), linea[1].toString());
            listaCiudades.add(town);
        }
    }

    // se usan en el presenter

/*
    public void getPrices(Town town, GasType type,
                   Response.Listener<List<StationPrice>> listListener,
                   Response.ErrorListener errorListener) {
// ...
    }*/




}