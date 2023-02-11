package com.example.cookit.profile.presenter;

import com.example.cookit.model.modelFirebase.RepositoryFirebaseInterface;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.profile.view.ProfileViewInterface;

public class profilePresenter implements profilePresenterInterface{

    private RepositoryFirebaseInterface repositoryFirebaseInterface;

    private ProfileViewInterface profileViewInterface;

    public profilePresenter(RepositoryFirebaseInterface repositoryFirebaseInterface){
        this.repositoryFirebaseInterface = repositoryFirebaseInterface;
    }
    @Override
    public UserModel getSavedUserData() {
        return repositoryFirebaseInterface.getSavedUserData();
    }


    @Override
    public void updateUserData(UserModel userModel) {
        repositoryFirebaseInterface.updateUserData(userModel);
    }

    @Override
    public void updateUserFirebaseData(UserModel userModel) {
        repositoryFirebaseInterface.updateUserFirebaseData(userModel);
    }
}
