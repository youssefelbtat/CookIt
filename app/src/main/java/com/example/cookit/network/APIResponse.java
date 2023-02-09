package com.example.cookit.network;

import com.example.cookit.model.MealModelResponse;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIResponse {

    public static final String url="www.themealdb.com/api/json/v1/1/";
   MealService mealService;
    private static APIResponse apiResponse = null;

    public APIResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        mealService = retrofit.create(MealService.class);

    }

    public static APIResponse getInstance(){

        if (apiResponse == null){
            apiResponse = new APIResponse();
        }

        return apiResponse;
    }

    public Single<MealModelResponse> getRandomMeals(){
        return mealService.getRandomMeals();
    }





}
