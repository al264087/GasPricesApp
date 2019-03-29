package com.example.gaspricesapp;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
/*
    Model model;
    GasStation gasStation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void ShowList()
    {
        CustomAdapter adapter = new CustomAdapter (SecondActivity.this, gasList); //Nueva clase custom Adapter que contenga un XML

        lista.setAdapter(adapter);

        ShowAll();

        if(gasStation.gasList.size()== 0)
        {
            Toast.makeText(getApplicationContext(),"0 RESULTS FOR SEARCH", Toast.LENGTH_LONG).show();
        }

        lista.setOnItemClickListener((parent, view, position, id){

            final StationPrice stationPrice = StationPrice.get(position); //

        AlertDialog.Builder  builder = new AlertDialog.Builder(SecondActivity.this);

        builder.setTitle("Fuel Station");
        builder.setMessage("Search on Google Maps?");

        builder.setCancelable(true);

        builder.setPositiveButton("Open",)
        {
            String latitude = SecondPresenter.ConvertString(g.getLatitude);
            String length = SecondPresenter.ConvertString(g.getLength);
            Intent intent = new Intent();

            intent.setAction(Intent.ACTION_VIEW);
            String label = URLEncoder.encode(g.getDirection());

            if(intent.resolveActivity(getPackageManager() != null)
            {
                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Google Maps ERROR", Toast.LENGTH_LONG).show();
            }

        }

        }
    }

    public void CreateRequest()
    {
        int town = Integer.parseInt(SecondPresenter.leerCiudades());
        int fuel = SecondPresenter.GetFuel();

        String url = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroMunicipioProducto/";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null, FillList(response.toString());

                ShowList();
        ), new Response.ErrorListener()
    {
        @Override
        public void onErrorResponse(VolleyError error)
        {

        }
        };
        model.addRequestQueue(jsonObjectRequest);
    }

    public void FillList (String response)
    {
        try {
            JSONObject jsonObject = new JSONObject(response);

            StationPrice stationPrice;
            gasStation.gasList.add();

            JSONArray jsonArray = jsonObject.getJSONArray("priceList");

            String addres;
            String price;
            String latitude;
            String length;

            for (int i = 0; i < jsonArray.length(); i++) {
                addres = jsonArray.getJSONObject(i).getString("Addres");
                price = jsonArray.getJSONObject(i).getString("Price");
                latitude = jsonArray.getJSONObject(i).getString("Latitude");
                length = jsonArray.getJSONObject(i).getString("Length");

                tempGas = new StationPrice(price, addres, latitude, length);
                gaslist.add(tempGas);
            }
        }catch (Exception i)
        {

        }
    }

    public void HideAll()
    {

    }

    public void ShowAll()
    {

    }
*/
}
