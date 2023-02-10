package com.example.cookit.model.modelFirebase;

public interface RepositoryFirebaseInterface {

    public void SignUpWithGoogle(UserModel userModel);
    public void signUpWithCreateEmail(UserModel userModel);

    void saveUserData(UserModel userModel);

    boolean isUserExists(UserModel userModel);

    UserModel getSavedUserData();

}
