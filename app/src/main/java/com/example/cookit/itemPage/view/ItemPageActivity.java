package com.example.cookit.itemPage.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.cookit.R;
import com.example.cookit.model.IngredientModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemPageActivity extends AppCompatActivity {
    TextView mealName;
    RecyclerView recyclerView;
    IngredientAdapter ingredientAdapter;
    GridLayoutManager layoutManager;
    List<IngredientModel> ingredientList= new ArrayList<IngredientModel>();
    ImageButton addToFav_btn,addToPlane_btn;

    //final String VIDEO_URL="https:\\/\\/www.youtube.com\\/watch?v=4aZr5hZXP_s";
    final String VIDEO_URL="https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1https:\\/\\/www.youtube.com\\/watch?v=4aZr5hZXP_s";
    final String []days=new String[]{"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
    final boolean[] checkedDays = new boolean[days.length];
    final List<String> selectedDays = Arrays.asList(days);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);
        addToFav_btn=findViewById(R.id.add_to_favorite);
        addToPlane_btn=findViewById(R.id.add_to_calender);

        addToPlane_btn.setOnClickListener(
                v->{

                    // initialise the alert dialog builder
                    AlertDialog.Builder builder = new AlertDialog.Builder(ItemPageActivity.this);

                    // set the title for the alert dialog
                    builder.setTitle(R.string.add_meal_to_plan_dialog_title);

                    // set the icon for the alert dialog
                    builder.setIcon(R.drawable.fettuccinealfredo);

                    // now this is the function which sets the alert dialog for multiple item selection ready
                    builder.setMultiChoiceItems(days, checkedDays, (dialog, which, isChecked) -> {
                        checkedDays[which] = isChecked;
                        String currentItem = selectedDays.get(which);
                    });

                    // alert dialog shouldn't be cancellable
                    builder.setCancelable(false);

                    // handle the positive button of the dialog
                    builder.setPositiveButton("add", (dialog, which) -> {
                        for (int i = 0; i < checkedDays.length; i++) {
                            if (checkedDays[i]) {
                                System.out.println("Selected days : "+ selectedDays.get(i));
                            }
                        }
                    });

                    // handle the negative button of the alert dialog
                    builder.setNegativeButton("CANCEL", (dialog, which) -> {});
                    builder.create();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
        );

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
        Uri uri = Uri.parse(VIDEO_URL);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();


    }
}