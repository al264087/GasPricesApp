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
import model.database.GasType;
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
    List<GasType> listaGasolinas = new ArrayList<>(); //Sacar los datos de la gasofa

    List <String> stringComunidades = new ArrayList<>();
    List <String> stringProvinces= new ArrayList<>();
    List <String> stringTowns= new ArrayList<>();

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


    //public class RecoverCommunities extends AsyncTask<Void, Void, List<model.database.Community>> {
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

/*@Override
public void getCommunities(final List<Community> listaComunidades, final Response.Listener<List<Community>> communitylistener){

        RecoverCommunities recoverCommunities = new RecoverCommunities(communitylistener);
        recoverCommunities.execute();
}*/

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

    public void  LeerProvincias ()
    {
        InputStream stream = resources.openRawResource(R.raw.provinces);
        Scanner scanner = new Scanner (stream);

        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            Province province = new Province(Integer.parseInt(linea[0]), linea[1].toString());
            listaProvincias.add(province);
        }

    }

    public void LeerCiudades ()
    {
        InputStream stream = resources.openRawResource(R.raw.towns);
        Scanner scanner = new Scanner (stream);

        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            Town town    = new Town(Integer.parseInt(linea[0]), linea[1].toString());
            listaCiudades.add(town);
        }
    }

    public void LeerGasofa()
    {
        InputStream stream = resources.openRawResource(R.raw.gastypes);
        Scanner scanner = new Scanner (stream);

        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            GasType gasType = new GasType(Integer.parseInt(linea[0]), linea[1].toString(), linea[2].toString());
            listaGasolinas.add(gasType);
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
