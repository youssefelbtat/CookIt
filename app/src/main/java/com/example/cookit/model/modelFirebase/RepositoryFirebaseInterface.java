package com.example.cookit.model.modelFirebase;

public interface RepositoryFirebaseInterface {

    public void SignUpWithGoogle();
    public void signUpWithCreateEmail(UserModel userModel);

    void saveUserData(UserModel userModel);

    UserModel getSavedUserData();

}
