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
import Model.database.MyDao;
import androidx.room.Room;
import Model.database.DataBase;


public class Model implements IModel {

   static Model model;
   private Resources resources;


    Context ctx;
    DataBase dataBase;
    List<Community> listaComunidades = new ArrayList<>();

    public Model(Context context)
    {
        ctx = context;
        dataBase = Room.databaseBuilder(context, DataBase.class, "BaseDeDatos").build();
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
    }
//cada vez que toques cosas del dao, lo haces en un AsyncTask
    //On postExecute, para trabajar y relacionarse con la AsyncTask para que le de tiempo a obtener la información
    public void  LeerComunidades( )
    {
        InputStream stream = resources.openRawResource(R.raw.Ciudades);
        Scanner scanner = new Scanner(stream);


        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            Community community = new Community(Integer.parseInt(linea[0]), linea[1].toString());
            listaComunidades.add(community);
        }
    }

    //Repetir, se usan en el presenter




}
