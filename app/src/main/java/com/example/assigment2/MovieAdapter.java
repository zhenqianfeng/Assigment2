package com.example.assigment2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_row,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        final Movie movie = movieList.get(i);
        myViewHolder.id.setText("Movie Record #" + movie.getId());
        myViewHolder.name.setText(movie.getMovieName());
        myViewHolder.rating.setRating(movie.getRating());


        myViewHolder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieList.remove(movie);
                Toast.makeText(v.getContext(),"Record deleted",Toast.LENGTH_LONG).show();

                notifyDataSetChanged();
            }
        });
           }



    @Override
    public int getItemCount() {
        return this.movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id,name;
        RatingBar rating;
        Button btn_delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txt_id);
            name = itemView.findViewById(R.id.txt_movie_name);
            rating = itemView.findViewById(R.id.ratingBar);
            btn_delete = itemView.findViewById(R.id.btn_delete);
        }
    }
}
