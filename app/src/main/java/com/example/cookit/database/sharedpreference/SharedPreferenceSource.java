package com.example.cookit.database.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.cookit.model.modelFirebase.User;
import com.example.cookit.model.modelFirebase.UserModel;

public class SharedPreferenceSource implements SharedPreferenceSourceInterfece{

    private static SharedPreferenceSource sharedPreferenceSource = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPreferenceSource(Context context){

        sharedPreferences = context.getSharedPreferences(User.SHARDPREFERENCE,context.MODE_PRIVATE);
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
        editor.putInt(String.valueOf(User.ID),userModel.getId());
        editor.putString(User.USERNAME,userModel.getUserName());
        editor.putString(User.EMAIL,userModel.getEmail());
        editor.putString(User.PASSWORD,userModel.getPassWord());
        editor.commit();
    }

    @Override
    public UserModel getSavedUserData() {
        return null;
    }
}
