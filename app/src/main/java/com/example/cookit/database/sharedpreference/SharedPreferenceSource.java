package com.example.cookit.database.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.utalites.Utalites;

public class SharedPreferenceSource implements SharedPreferenceSourceInterfece{

    private static SharedPreferenceSource sharedPreferenceSource = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private UserModel userModel ;

    private SharedPreferenceSource(Context context){

        sharedPreferences = context.getSharedPreferences(Utalites.SHARDPREFERENCE,context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        userModel = new UserModel();

    }

    public static SharedPreferenceSource getInstance(Context context){

        if (sharedPreferenceSource == null) {
            sharedPreferenceSource = new SharedPreferenceSource(context);
        }
        return sharedPreferenceSource;
    }

    @Override
    public void saveUserData(UserModel userModel) {
        editor.putString(Utalites.USERNAME,userModel.getUserName());
        editor.putString(Utalites.PASSWORD,userModel.getPassWord());
        editor.putString(Utalites.EMAIL,userModel.getEmail());
        editor.commit();


    }


    @Override
    public UserModel getSavedUserData() {
        userModel.setUserName(sharedPreferences.getString(Utalites.USERNAME,"Null"));
        userModel.setEmail(sharedPreferences.getString(Utalites.EMAIL,"Null"));
        userModel.setPassWord(sharedPreferences.getString(Utalites.PASSWORD,"Null"));
        userModel.setImage(sharedPreferences.getString(Utalites.IMAGE,"null"));
        return userModel;


    }

    @Override
    public void updateUserData(UserModel userModel) {
        editor.putString(Utalites.USERNAME,userModel.getUserName());
        editor.putString(Utalites.PASSWORD,userModel.getPassWord());
        editor.putString(Utalites.EMAIL,userModel.getEmail());
        editor.putString(Utalites.IMAGE,userModel.getImage());
        editor.commit();

    }
}
