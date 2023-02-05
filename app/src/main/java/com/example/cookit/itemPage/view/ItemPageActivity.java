package com.example.cookit.itemPage.view;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.cookit.R;
import com.example.cookit.favoritemeals.presenter.FavPresenterInterface;
import com.example.cookit.favoritemeals.view.FavoriteMealsAdapter;
import com.example.cookit.model.IngredientModel;
import com.example.cookit.model.MealModel;

import java.util.ArrayList;
import java.util.List;

public class ItemPageActivity extends AppCompatActivity {
    TextView mealName;
    RecyclerView recyclerView;
    IngredientAdapter ingredientAdapter;
    GridLayoutManager layoutManager;
    List<IngredientModel> ingredientList= new ArrayList<IngredientModel>();

    //final String VIDEO_URL="https:\\/\\/www.youtube.com\\/watch?v=4aZr5hZXP_s";
    final String VIDEO_URL="https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1https:\\/\\/www.youtube.com\\/watch?v=4aZr5hZXP_s";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);
        ingredientList.add(new IngredientModel("2 tbsp Parsley","https://www.themealdb.com/images/ingredients/Parsley.png"));
        ingredientList.add(new IngredientModel("1 Ib Fettuccine","https://www.themealdb.com/images/ingredients/Fettuccine.png"));
        ingredientList.add(new IngredientModel("Black Pepper","https://www.themealdb.com/images/ingredients/Black%20Pepper.png"));
        ingredientList.add(new IngredientModel("1/2 cup Butter","https://www.themealdb.com/images/ingredients/Butter.png"));
        mealName=findViewById(R.id.itemPageMealName);
        recyclerView=findViewById(R.id.ingredientRecyclerView);
        if(getIntent().hasExtra("mealName"))
            mealName.setText(getIntent().getStringExtra("mealName"));
        layoutManager=new GridLayoutManager(this,3);
        ingredientAdapter=new IngredientAdapter(this,ingredientList);
        ingredientAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(ingredientAdapter);
        recyclerView.setLayoutManager(layoutManager);
        // finding videoview by its id
        VideoView videoView = findViewById(R.id.videoView);

        // Uri object to refer the
        // resource from the videoUrl
        Uri uri = Uri.parse(VIDEO_URL);

        // sets the resource from the
        // videoUrl to the videoView
        videoView.setVideoURI(uri);

        // creating object of
        // media controller class
        MediaController mediaController = new MediaController(this);

        // sets the anchor view
        // anchor view for the videoView
        mediaController.setAnchorView(videoView);

        // sets the media player to the videoView
        mediaController.setMediaPlayer(videoView);

        // sets the media controller to the videoView
        videoView.setMediaController(mediaController);

        videoView.start();


    }
}