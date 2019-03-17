package com.example.assigment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int unique_id=1;

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MovieAdapter ma = new MovieAdapter(movieList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(ma);

        movieList.addAll(generateData(unique_id));


    }


    protected ArrayList<Movie> generateData(int id){
        ArrayList<Movie> movies = new ArrayList<>();
        Movie m;
        m = new Movie(id++,"How to train your dragon", 3);
        movies.add(m);
        m = new Movie(id++,"Mocking Jay", 4);
        movies.add(m);
        m = new Movie(id++,"Brave Heart", 5);
        movies.add(m);
        m = new Movie(id++,"Forest Gump", 5);
        movies.add(m);

        return movies;
    }



}
