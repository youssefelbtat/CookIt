package com.example.cookit.model.retrofit;

import android.content.Context;
import com.example.cookit.network.NetworkDelegate;
import com.example.cookit.network.RemoteSource;

public class Repository implements RepositoryInterface{

    private Context context ;

    RemoteSource remoteSource;
    private static Repository repository =null ;

    public Repository(RemoteSource remoteSource,Context context) {
        this.context = context;
        this.remoteSource = remoteSource;

    }

    public static Repository getInstance(RemoteSource remoteSource,Context context){
        if (repository == null){
            repository = new Repository(remoteSource,context);
        }

        return  repository;
    }


    @Override
    public void getAllCategories(NetworkDelegate networkDelegate) {
        remoteSource.getAllCategories(networkDelegate);
    }

    @Override
    public void getAllCountries(NetworkDelegate networkDelegate) {
        remoteSource.getAllCountries(networkDelegate);
    }

    @Override
    public void getAllIngredient(NetworkDelegate networkDelegate) {
        remoteSource.getAllIngredient(networkDelegate);
    }

    @Override
    public void getMealsByName(NetworkDelegate networkDelegate, String name) {
        remoteSource.getMealsByName(networkDelegate,name);
    }

    @Override
    public void getMealsByCategories(NetworkDelegate networkDelegate, String category) {
        remoteSource.getMealsByCategories(networkDelegate,category);
    }

    @Override
    public void getMealsByCountries(NetworkDelegate networkDelegate, String country) {
        remoteSource.getMealsByCountries(networkDelegate,country);
    }

    @Override
    public void getMealsByIngredients(NetworkDelegate networkDelegate, String ingredient) {
        remoteSource.getMealsByIngredients(networkDelegate,ingredient);
    }
}
