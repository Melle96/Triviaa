package com.example.melle.trivia_melle;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

public class TriviaHelper implements
        Response.Listener<JSONArray>, Response.ErrorListener{

    Context contextt;
    Callback callbackk;

    public TriviaHelper(Context context) {

        contextt = context;
    }

    public interface Callback {
        void gotQuestions(JSONObject questions);
        void gotQuestionsError(String message);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        callbackk.gotQuestionsError(error.getMessage());
    }

    @Override
    public void onResponse(JSONArray response) {

        JSONObject json;
        try {
            json = response.getJSONObject(0);
        }
        catch (JSONException e) {
            e.printStackTrace();
            return;
        }
        callbackk.gotQuestions(json);
    }


    public void Trivia(Callback activity){

        callbackk = activity;
        RequestQueue q = Volley.newRequestQueue(contextt);
        String url = "http://jservice.io/api/random";
        JsonArrayRequest jar = new JsonArrayRequest(url, this, this);
        q.add(jar);

    }
}