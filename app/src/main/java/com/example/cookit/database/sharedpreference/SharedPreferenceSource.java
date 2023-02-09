package com.example.cookit.database.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.utalites.Utalites;

public class SharedPreferenceSource implements SharedPreferenceSourceInterfece{

    private static SharedPreferenceSource sharedPreferenceSource = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPreferenceSource(Context context){

        sharedPreferences = context.getSharedPreferences(Utalites.SHARDPREFERENCE,context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public static SharedPreferenceSource getInstance(Context context){

        if (sharedPreferenceSource == null) {
            sharedPreferenceSource = new SharedPreferenceSource(context);
        }
        return sharedPreferenceSource;
    }

    @Override
    public void saveUserData(UserModel userModel) {
        editor.putInt(String.valueOf(Utalites.ID),userModel.getId());
        editor.putString(Utalites.USERNAME,userModel.getUserName());
        editor.putString(Utalites.EMAIL,userModel.getEmail());
        editor.putString(Utalites.PASSWORD,userModel.getPassWord());
        editor.commit();
    }

    @Override
    public UserModel getSavedUserData() {
        return null;
    }
}
