package com.example.assigment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class AddRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        final Intent i = getIntent();
        Button b_save = findViewById(R.id.btn_save);
        Button b_cancel = findViewById(R.id.btn_cancel);

        b_save.setOnClickListener(new View.OnClickListener() {
            EditText movieName = findViewById(R.id.input_name);
            RatingBar movieRating = findViewById(R.id.input_ratingBar);

            @Override
            public void onClick(View v) {
                i.putExtra("message","save");
                i.putExtra("newName",movieName.getText().toString());
                i.putExtra("newRating", movieRating.getRating());
                setResult(RESULT_OK,i);
                finish();
            }
        });

        b_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
     //           i.putExtra("message","cancel");
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
