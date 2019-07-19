package com.example.github_api_json;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Button btnGetData;
    EditText etName;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetData = findViewById(R.id.btnGetData);
        etName = findViewById(R.id.etName);
        recyclerView = findViewById(R.id.recyclerView);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                NetworkTask networkTask = new NetworkTask();
                networkTask.execute("https://api.github.com/search/users?q=" + name);
            }
        });
    }

    class NetworkTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            String link = strings[0];
            try {
                URL url = new URL(link);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                if(scanner.hasNext())
                {
                    String data = scanner.next();
                    return data;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Fail to load !!!";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            ArrayList<GithubUser> users = parseJson(s);
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            GithubUserAdapter githubUserAdapter = new GithubUserAdapter(users);
            recyclerView.setAdapter(githubUserAdapter);
        }
    }
    ArrayList<GithubUser> parseJson(String s) {
        ArrayList<GithubUser> githubUsers = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject object = jsonArray.getJSONObject(i);
                String login = object.getString("login");
                Integer id = object.getInt("id");
                Double score = object.getDouble("score");
                String url = object.getString("url");

                GithubUser githubUser = new GithubUser(login,id,url,score);
                githubUsers.add(githubUser);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return githubUsers;
    }


}
