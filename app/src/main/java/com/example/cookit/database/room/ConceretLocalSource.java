package com.example.cookit.database.room;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import com.example.cookit.model.MealModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class ConceretLocalSource implements LocalSource{

    private static ConceretLocalSource conceretLocalSource = null;
    private MealDao mealDao ;

    Single<List<MealModel>> mealFavorites;

    private ConceretLocalSource(Context context){

        AppDataBase appDataBase = AppDataBase.getInstance(context.getApplicationContext());
        mealDao = appDataBase.mealDao();
        mealFavorites = mealDao.getFavorites();

    }

    public static ConceretLocalSource getInstance(Context context){

        if(conceretLocalSource == null){
            conceretLocalSource = new ConceretLocalSource(context);
        }
        return conceretLocalSource;
    }

    @Override
    public void insertFavorite(MealModel mealModel) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    mealDao.insertFavorite(mealModel);
                }catch (SQLiteConstraintException e){

                }

            }
        }).start();
    }

    @Override
    public void removeFavorite(MealModel mealModel) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mealDao.deleteFavorite(mealModel);
            }
        }).start();
    }

    @Override
    public Single<List<MealModel>> getAllStoredFavorites() {
        return mealFavorites;
    }

    @Override
    public void insertPlan(MealModel mealModel) {

    }

    @Override
    public void removePlan(MealModel mealModel) {

    }

    @Override
    public Single<List<MealModel>> getAllStoredPlans() {
        return null;
    }
}
