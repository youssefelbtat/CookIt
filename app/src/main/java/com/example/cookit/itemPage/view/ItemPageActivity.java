package com.example.cookit.itemPage.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cookit.R;
import com.example.cookit.authentication.signup.view.SignupActivity;
import com.example.cookit.database.room.ConceretLocalSource;
import com.example.cookit.itemPage.presenter.ItemPagePresenter;
import com.example.cookit.itemPage.presenter.ItemPagePresenterInterface;
import com.example.cookit.model.IngredientModel;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Repository;
import com.example.cookit.network.APIResponse;
import com.example.cookit.utalites.Utalites;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemPageActivity extends AppCompatActivity implements ItemViewInterface,OnItemPageClickListenerInterface {
    TextView mealName,mealCountry,mealSteps;
    RecyclerView recyclerView;
    IngredientAdapter ingredientAdapter;
    GridLayoutManager layoutManager;
    List<IngredientModel> ingredientList= new ArrayList<IngredientModel>();
    ImageButton addToFav_btn,addToPlane_btn,backArrow;
    ImageView imageView;

    ItemPagePresenterInterface pagepresenter;

    MealModel model;
    YouTubePlayerView videoView ;

    String[] videoSplit;
    String videoId;
    String []days;

    ItemPagePresenterInterface itemPagePresenterInterface;
    boolean[] checkedDays;
    List<String> selectedDays;
    String mealNameItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        days=getResources().getStringArray(R.array.weekdays);
        checkedDays= new boolean[days.length];
        selectedDays = Arrays.asList(days);
//        Intent intent = getIntent();
//        model = (MealModel) intent.getSerializableExtra("MEAL_ITEM");
//
        Bundle extra=getIntent().getExtras();
        if(extra!=null){
            mealNameItem = extra.getString("MEAL_NAME");

        }
        init();
        pagepresenter=new ItemPagePresenter(this, Repository.getInstance(APIResponse.getInstance(this), ConceretLocalSource.getInstance(ItemPageActivity.this),ItemPageActivity.this));
        pagepresenter.getMealItem(mealNameItem);


        addToFav_btn.setOnClickListener(event -> {

            if(Utalites.SKIP == "skip"){
                Toast.makeText(this, "Please, Signup", Toast.LENGTH_SHORT).show();

            }else {
                model.setFavorite(true);
                model.setNameDay("Not");
                addToFavoriteOnClick(model);
            }
        });
        /*
        System.out.println("The Meal Name is ......."+model.getStrYoutube());

       itemPagePresenterInterface = new ItemPagePresenter(this, Repository.getInstance(APIResponse.getInstance(getApplicationContext())
               , ConceretLocalSource.getInstance(getApplicationContext()),this));



        videoID=model.getStrYoutube().split("=");
        System.out.println("The Meal Video:"+videoID[1]);
        mealName.setText(model.getStrMeal());
        mealCountry.setText(model.getStrArea());
        mealSteps.setText(model.getStrInstructions());
        Glide.with(this).load(model.getStrMealThumb())
                .apply(new RequestOptions().override(imageView.getWidth(),imageView.getHeight()))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);

        getLifecycle().addObserver(videoView);

        videoView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                youTubePlayer.loadVideo(videoID[1], 0);
            }
        });

        backArrow.setOnClickListener(v->{this.finish();});

        addToPlane_btn.setOnClickListener(
                v->{
                    AlertDialog.Builder builder = new AlertDialog.Builder(ItemPageActivity.this);
                    builder.setTitle(R.string.add_meal_to_plan_dialog_title);
                    builder.setIcon(imageView.getDrawable());
                    builder.setMultiChoiceItems(days, checkedDays, (dialog, which, isChecked) -> {
                        checkedDays[which] = isChecked;
                        String currentItem = selectedDays.get(which);
                    });

                    builder.setCancelable(false);
                    builder.setPositiveButton("add", (dialog, which) -> {
                        for (int i = 0; i < checkedDays.length; i++) {
                            if (checkedDays[i]) {
                                System.out.println("Selected days : "+ selectedDays.get(i));
                            }
                        }
                    });
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


//        if(getIntent().hasExtra("mealName"))
//            mealName.setText(getIntent().getStringExtra("mealName"));

        layoutManager=new GridLayoutManager(this,3);
        ingredientAdapter=new IngredientAdapter(this,ingredientList);
        ingredientAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(ingredientAdapter);
        recyclerView.setLayoutManager(layoutManager);*/
        backArrow.setOnClickListener(v->{this.finish();});

        addToPlane_btn.setOnClickListener(
                v-> {
                    if (Utalites.SKIP == "skip") {
                        Toast.makeText(this, "Please, Signup", Toast.LENGTH_SHORT).show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ItemPageActivity.this);
                        builder.setTitle(R.string.add_meal_to_plan_dialog_title);
                        builder.setIcon(imageView.getDrawable());
                        builder.setMultiChoiceItems(days, checkedDays, (dialog, which, isChecked) -> {
                            checkedDays[which] = isChecked;
                            String currentItem = selectedDays.get(which);
                        });

                    builder.setCancelable(false);
                    builder.setPositiveButton("add", (dialog, which) -> {
                        addTop(0);
                        addTop(1);
                        addTop(2);
                        addTop(3);
                        addTop(4);
                        addTop(5);
                        addTop(6);
                    });
                    builder.setNegativeButton("CANCEL", (dialog, which) -> {});
                    builder.create();
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                    }
                }
        );
    }
    void init(){
        videoView = findViewById(R.id.videoView);
        mealName=findViewById(R.id.itemPageMealName);
        recyclerView=findViewById(R.id.ingredientRecyclerView);
        mealCountry=findViewById(R.id.itemPageMealCountry);
        mealSteps=findViewById(R.id.itemPageMealSteps);
        addToFav_btn=findViewById(R.id.add_to_favorite);
        addToPlane_btn=findViewById(R.id.add_to_calender);
        backArrow=findViewById(R.id.itembackbutton);
        imageView=findViewById(R.id.profileUserImage);
    }

    @Override
    public void ViewMealItem(List<MealModel> meal) {
        System.out.println("The View Mealllll: "+meal.get(0).getStrMeal());
        model=meal.get(0);

        System.out.println("The Meal Name is ......."+model.getStrYoutube());
        if(!model.getStrYoutube().equals(""))
        {
            videoSplit =model.getStrYoutube().split("=");
            videoId =videoSplit[1];
        }else{
            videoId =" ";
        }

        mealName.setText(model.getStrMeal());
        mealCountry.setText(model.getStrArea());
        mealSteps.setText(model.getStrInstructions());
        Glide.with(this).load(model.getStrMealThumb())
                .apply(new RequestOptions().override(imageView.getWidth(),imageView.getHeight()))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);

        getLifecycle().addObserver(videoView);

        videoView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                youTubePlayer.loadVideo(videoId, 0);
            }
        });

        if(model.getStrIngredient1()!="")
            ingredientList.add(new IngredientModel(model.getStrIngredient1(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient1()+".png"));
        if(!model.getStrIngredient2().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient2(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient2()+".png"));
        if(!model.getStrIngredient3().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient3(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient3()+".png"));
        if(!model.getStrIngredient4().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient4(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient4()+".png"));
        if(!model.getStrIngredient5().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient5(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient5()+".png"));
        if(!model.getStrIngredient6().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient6(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient6()+".png"));
        if(!model.getStrIngredient7().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient7(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient7()+".png"));
        if(!model.getStrIngredient8().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient8(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient8()+".png"));
        if(!model.getStrIngredient9().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient9(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient9()+".png"));
        if(!model.getStrIngredient10().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient10(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient10()+".png"));
        if(!model.getStrIngredient11().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient11(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient11()+".png"));
        if(!model.getStrIngredient12().equals(""))
            ingredientList.add(new IngredientModel(model.getStrIngredient12(),"https://www.themealdb.com/images/ingredients/"+model.getStrIngredient12()+".png"));

        layoutManager=new GridLayoutManager(this,3);
        ingredientAdapter=new IngredientAdapter(this,ingredientList);
        ingredientAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(ingredientAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }
    @Override
    public void addToFavorite(MealModel mealModel) {
        pagepresenter.addToFavorite(mealModel);
    }

    @Override
    public void addToFavoriteOnClick(MealModel mealModel) {
        addToFavorite(mealModel);
    }

    @Override
    public void addToWeakPlanOnclick(MealModel mealModel) {
        addMealToPlan(mealModel);
    }


    @Override
    public void addMealToPlan(MealModel Meal) {
        pagepresenter.addToPlan(Meal);

    }
    void addTop(int i){
        if (checkedDays[i]) {
            model.setNameDay(selectedDays.get(i));
            addToWeakPlanOnclick(model);
            System.out.println("Selected days : "+ selectedDays.get(i));
        }
    }
}