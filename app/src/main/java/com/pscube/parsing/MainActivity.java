package com.pscube.parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
//coding team = sambhav jain
public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue=Volley.newRequestQueue(this);

//
//        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET,
//                "https://jsonplaceholder.typicode.com/users/1", null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    Log.d("happy","RESULT "+ response.getString("name"));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("sad","RESULT"+error.getMessage());
//            }
//        });


        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("happy",""+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("sad",""+error.getMessage());

            }
        });







    requestQueue.add(jsonArrayRequest);

       // requestQueue.add(objectRequest);









    }

}
