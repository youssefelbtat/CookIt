package com.example.cookit.authentication.signin.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.cookit.authentication.signin.view.SignInViewInterface;
import com.example.cookit.model.modelFirebase.RepositoryFirebaseInterface;
import com.example.cookit.model.modelFirebase.UserModel;

public class SigninPresenter implements SigninPresenterInterface{

    private RepositoryFirebaseInterface _repo;

    private SignInViewInterface _view;

    public SigninPresenter(SignInViewInterface view, RepositoryFirebaseInterface repo){
        _repo=repo;
        _view=view;
    }
    @Override
    public void addUserDataToShered(UserModel userModel) {
        _repo.saveUserData(userModel);
    }

    @Override
    public boolean checkUserData(Context context, String email, String pass) {
        return _repo.isLoginSuccessed(context,email,pass);
    }
}
