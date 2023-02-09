package com.example.cookit.model.retrofit;

import android.content.Context;

import com.example.cookit.network.NetworkDelegate;

public class Repository implements RepositoryInterface{

    private Context context ;
    private static Repository repository =null ;

    public Repository(Context context) {
        this.context = context;

    }

    public static Repository getInstance(Context context){
        if (repository == null){
            repository = new Repository(context);
        }

        return  repository;
    }

    @Override
    public void getRandomMeal(NetworkDelegate networkDelegate) {

    }
}
