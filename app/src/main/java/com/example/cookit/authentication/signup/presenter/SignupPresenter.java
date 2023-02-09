package com.example.cookit.authentication.signup.presenter;

import com.example.cookit.model.modelFirebase.RepositoryFirebaseInterface;
import com.example.cookit.model.modelFirebase.UserModel;

public class SignupPresenter implements SignUpPresenterInterface {

    private RepositoryFirebaseInterface repositoryFirebaseInterface;

    public SignupPresenter(RepositoryFirebaseInterface repositoryFirebaseInterface){

        this.repositoryFirebaseInterface = repositoryFirebaseInterface;

    }

    @Override
    public void onSuccessSignUpWithGoogle() {

    }

    @Override
    public void onFailureSignUpWithGoogle(String error) {

    }

    @Override
    public void addUserData(UserModel userModel) {
        repositoryFirebaseInterface.signUpWithCreateEmail(userModel);
    }
}
