package com.example.assigment2;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    static int unique_id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_addRecord = findViewById(R.id.btn_add);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MovieAdapter ma = new MovieAdapter(movieList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(ma);

        movieList.addAll(generateData(unique_id));

        b_addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddRecordActivity.class);
                startActivityForResult(i,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK && requestCode==1){
            if(data.hasExtra("message")){
                String newMovieName = data.getStringExtra("newName");
                Float newMovieRating = data.getFloatExtra("newRating",0);

                Movie newMovie = new Movie(unique_id++,newMovieName,newMovieRating);
                movieList.add(newMovie);
                Toast.makeText(this, "Record added", Toast.LENGTH_LONG).show();
                refreshView();




/*                if (data.getStringExtra("message")=="save"){
                }*/
            }
        }
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

    private void refreshView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }



}
