package com.pscube.parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
  // private RequestQueue requestQueue;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // requestQueue=Volley.newRequestQueue(this);

        queue=MySingleton.getInstance(this).getRequestQueue();

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
                //below method id for getting all the objects particular item


                for (int i = 0 ;i<response.length();i++){

                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        Log.d("happy",""+jsonObject.getString("username"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


                //below method is for getting only one object particular item
//                try {
//                    JSONObject jsonObject = response.getJSONObject(1);
//
//                    Toast.makeText(MainActivity.this, ""+jsonObject.getString("username"), Toast.LENGTH_SHORT).show();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }//

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("sad",""+error.getMessage());

            }
        });







  //  requestQueue.add(jsonArrayRequest);

       // requestQueue.add(objectRequest);
        queue.add(jsonArrayRequest);









    }

}
