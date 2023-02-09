package com.example.cookit.authentication.signup.presenter;

import com.example.cookit.authentication.signup.view.SignUpViewInterface;
import com.example.cookit.model.modelFirebase.RepositoryFirebaseInterface;
import com.example.cookit.model.modelFirebase.UserModel;

public class SignupPresenter implements SignUpPresenterInterface {

    private RepositoryFirebaseInterface _repo;

    private SignUpViewInterface _view;

    public SignupPresenter(RepositoryFirebaseInterface _repo){

        this._repo = _repo;

    }

    @Override
    public void onSuccessSignUpWithGoogle() {

    }

    @Override
    public void onFailureSignUpWithGoogle(String error) {

    }

    @Override
    public void addUserData(UserModel userModel) {
        _repo.signUpWithCreateEmail(userModel);
    }

    @Override
    public void saveUserData(UserModel userModel) {
        repositoryFirebaseInterface.saveUserData(userModel);
    }

    @Override
    public UserModel getSavedUserData() {
        return null;
    }
}
