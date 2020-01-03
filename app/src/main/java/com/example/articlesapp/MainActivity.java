package com.example.articlesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    ArrayList<ArticleModel> modelArrayList;
    RecyclerView recyclerView;
    ArticleAdapter adapter;
    LinearLayoutManager manager;
    String url = "https://articleservice.herokuapp.com/?format=json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        modelArrayList = new ArrayList<>();

        manager = new LinearLayoutManager(this);
        adapter = new ArticleAdapter(modelArrayList,MainActivity.this);

        recyclerView = findViewById(R.id.recyclerViewId);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        sendRequst();

    }

    private void sendRequst() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIHolder apiHolder = retrofit.create(APIHolder.class);
        Call<List<ArticleModel>> call = apiHolder.getArticles();
        call.enqueue(new Callback<List<ArticleModel>>() {
            @Override
            public void onResponse(Call<List<ArticleModel>> call, Response<List<ArticleModel>> response) {
                List<ArticleModel> arrayList = response.body();
                for (int i =0; i < arrayList.size(); i++) {
                    ArticleModel model = arrayList.get(i);
                    modelArrayList.add(new ArticleModel(model.getTitle(),model.getImage(),model.getBody(),model.getTime()));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<ArticleModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "There is some error, try again!",Toast.LENGTH_LONG).show();
            }
        });
    }

}



