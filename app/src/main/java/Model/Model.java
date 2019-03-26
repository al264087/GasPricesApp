package Model;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;

import com.example.gaspricesapp.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.database.Community;
import Model.database.GasType;
import Model.database.Province;
import Model.database.Town;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.room.Room;
import Model.database.DataBase;


public class Model implements IModel {

   static Model model;
   private Resources resources;


    Context contexto;
    DataBase dataBase;
    List<Community> listaComunidades = new ArrayList<>();
    List<Town> listaCiudades  = new ArrayList<>();
    List<Province> listaProvincias = new ArrayList<>();
    List<GasType> listaGasolinas = new ArrayList<>(); //Sacar los datos de la gasofa

    public Model(Context context)
    {
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

    //Funcion de inserts  llamando al Dao con el asynktasks

    public void InsertsBD()
    {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                LeerComunidades();
                dataBase.myDao().insertCommunities(listaComunidades);
                return null;
            }
        }.execute();

        new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected Void doInBackground(Void...voids)
            {
                LeerProvincias();
                dataBase.myDao().insertProvinces(listaProvincias);
                return null;
            }
        }.execute();

        new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected Void doInBackground(Void...voids)
            {
                LeerCiudades();
                dataBase.myDao().insertTowns(listaCiudades);
                return null;
            }
        }.execute();

        new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected Void doInBackground(Void...voids)
            {
                LeerCiudades();
                dataBase.myDao().insertGasTypes(listaGasolinas);
                return null;
            }
        }.execute();
    }

//cada vez que toques cosas del dao, lo haces en un AsyncTask
    //On postExecute, para trabajar y relacionarse con la AsyncTask para que le de tiempo a obtener la información

    public void  LeerComunidades( )
    {
        InputStream stream = resources.openRawResource(R.raw.communities);
        Scanner scanner = new Scanner(stream);


        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            Community community = new Community(Integer.parseInt(linea[0]), linea[1].toString());
            listaComunidades.add(community);
        }

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
        InputStream stream = resources.openRawResource(R.raw.gasTypes);
        Scanner scanner = new Scanner (stream);

        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            GasType gasType    = new GasType(Integer.parseInt(linea[0]), linea[1].toString(), linea[2].toString());
            listaGasolinas.add(gasType);
        }
    }

    // se usan en el presenter




}
