package com.example.cookit.network;

import com.example.cookit.model.MealModelResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface MealService {
    @GET("random.php")
     Single<MealModelResponse> getRandomMeals();

}
