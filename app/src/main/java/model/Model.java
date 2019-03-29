package Model;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;

import com.android.volley.Response;
import com.example.gaspricesapp.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.database.Community;
import Model.database.GasType;
import Model.database.Province;
import Model.database.Town;
import androidx.room.Room;
import Model.database.DataBase;


public class Model implements IModel {

    private static Model instance = null;
    private final Resources resources;
    private static DataBase db;



    private static List<Community> listaComunidades = new ArrayList<>();
    private List<Town> listaCiudades = new ArrayList<>();
    private List<Province> listaProvincias = new ArrayList<>();
    private List<GasType> listaGasolinas = new ArrayList<>(); //Sacar los datos de la gasofa


    public static Model getInstance() {
        return instance;
    }

    public static Model getInstance(Context context) {

        if (instance == null) {
            instance = new Model(context);
        }
        return instance;
    }

    private Model(Context context) {

        this.db = Room.databaseBuilder(context, DataBase.class, "DataBase").build();
        this.resources = context.getResources();

    }



    public class RecoverCommunities extends AsyncTask<Void, Void, List<Community>> {

        final Response.Listener<List<Community>> communitylistener;


        public RecoverCommunities(Response.Listener<List<Community>> communitylistener) {
            this.communitylistener = communitylistener;
        }

        @Override
        protected List<Community> doInBackground(Void... voids) {
            listaComunidades = db.myDao().allCommunities();
            if (listaComunidades == null) {

                RellenarComunidades();

            }
            return listaComunidades;

        }

        @Override
        protected void onPostExecute(List<Community> listaComunidades) {

            communitylistener.onResponse(listaComunidades);

        }

}

@Override
public void getCommunities(final List<Community> listaComunidades, final Response.Listener<List<Community>> communitylistener){

        RecoverCommunities recoverCommunities = new RecoverCommunities(communitylistener);
        recoverCommunities.execute();
}


    public void  RellenarComunidades()
    {
        InputStream stream = resources.openRawResource(R.raw.communities);
        Scanner scanner = new Scanner(stream);


        while(scanner.hasNextLine())
        {
            String lectura = scanner.nextLine();
            String [] linea  = lectura.split("#");

            Community community = new Community(Integer.parseInt(linea[0]), linea[1]);
            listaComunidades.add(community);
        }
        scanner.close();
        db.myDao().insertCommunities(listaComunidades);

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

            GasType gasType    = new GasType(Integer.parseInt(linea[0]), linea[1].toString(), linea[2].toString());
            listaGasolinas.add(gasType);
        }
    }






}
