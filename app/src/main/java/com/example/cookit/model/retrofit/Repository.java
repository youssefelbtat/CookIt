package com.example.cookit.model.retrofit;

import android.content.Context;

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

}
