package com.basil.jsonparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonData = getString(R.string.json_data);

        TextView title = findViewById(R.id.title);
        TextView overview = findViewById(R.id.overview);
        TextView vote = findViewById(R.id.vote);

        try {
            Movies movie = getDataFromJson(jsonData);
            title.setText(movie.title);
            overview.setText(movie.overview);
            vote.setText(String.valueOf(movie.vote));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    Movies getDataFromJson(String jsonData) throws JSONException {
        JSONObject root = new JSONObject(jsonData);
        JSONArray results = root.getJSONArray("results");
        JSONObject movie = results.getJSONObject(0);
        String title = movie.getString("title");
        String overview = movie.getString("overview");
        long id = movie.getLong("id");
        float vote = (float) movie.getDouble("vote_average");

        return new Movies(title, overview, id, vote);
    }
}
