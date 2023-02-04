package com.example.cookit.itemPage.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cookit.R;

public class ItemPageActivity extends AppCompatActivity {
    TextView mealName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);
        mealName=findViewById(R.id.itemPageMealName);
        if(getIntent().hasExtra("mealName"))
            mealName.setText(getIntent().getStringExtra("mealName"));

    }
}