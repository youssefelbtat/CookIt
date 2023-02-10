package com.example.cookit.network;

import com.example.cookit.model.retrofit.CategoryResponse;
import com.example.cookit.model.retrofit.CountryResponse;
import com.example.cookit.model.retrofit.IngredientResponse;
import com.example.cookit.model.MealModelResponse;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIResponse implements RemoteSource{

    public static final String url="https://www.themealdb.com/api/json/v1/1/";
   MealService mealService;
    private static APIResponse apiResponse = null;

    public APIResponse( ) {

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

    @Override
    public void getRandomMeals(NetworkDelegate networkDelegate) {

        Single<MealModelResponse> mealModelResponseSingle= mealService.getRandomMeals();
        mealModelResponseSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> networkDelegate.onSuccessMeals(item.getMealsModel()));
    }

    @Override
    public void getAllCategories(NetworkDelegate networkDelegate) {

        Single<CategoryResponse> categoryResponseSingle= mealService.getAllCategories();
        categoryResponseSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> networkDelegate.onSuccessCategories(item.getCategories()));
    }

    @Override
    public void getAllCountries(NetworkDelegate networkDelegate) {

        Single<CountryResponse> countryResponseSingle= mealService.getAllCountries();
        countryResponseSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> networkDelegate.onSuccessCountries(item.getCountries()));
    }

    @Override
    public void getAllIngredient(NetworkDelegate networkDelegate) {

        Single<IngredientResponse> ingredientResponseSingle= mealService.getAllIngredient();
        ingredientResponseSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> networkDelegate.onSuccessIngredients(item.getIngredients()));

    }

    @Override
    public void getMealsByName(NetworkDelegate networkDelegate, String name) {

        Single<MealModelResponse> mealModelResponseSingle= mealService.getMealsByName(name);
        mealModelResponseSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .onErrorComplete()
                .subscribe(item -> networkDelegate.onSuccessMeals(item.getMealsModel()));
    }

    @Override
    public void getMealsByCategories(NetworkDelegate networkDelegate, String category) {

        Single<MealModelResponse> mealModelResponseSingle= mealService.getMealsByCategories(category);
        mealModelResponseSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> networkDelegate.onSuccessMeals(item.getMealsModel()));

    }

    @Override
    public void getMealsByCountries(NetworkDelegate networkDelegate, String country) {

        Single<MealModelResponse> mealModelResponseSingle= mealService.getMealsByCountries(country);
        mealModelResponseSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> networkDelegate.onSuccessMeals(item.getMealsModel()));
    }

    @Override
    public void getMealsByIngredients(NetworkDelegate networkDelegate, String ingredient) {

        Single<MealModelResponse> mealModelResponseSingle= mealService.getMealsByIngredients(ingredient);
        mealModelResponseSingle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> networkDelegate.onSuccessMeals(item.getMealsModel()));

    }
}
