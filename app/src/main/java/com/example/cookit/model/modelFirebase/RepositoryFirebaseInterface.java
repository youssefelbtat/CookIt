package com.example.cookit.model.modelFirebase;

public interface RepositoryFirebaseInterface {

    public void SignUpWithGoogle(UserModel userModel);
    public void signUpWithCreateEmail(UserModel userModel);

    void saveUserData(UserModel userModel);

    boolean isUserExists(UserModel userModel);

    UserModel getSavedUserData();

    void updateUserData(UserModel userModel);

    void updateUserFirebaseData(UserModel userModel);

    void updateFavoriteInFirebase(UserModel userModel);

    void uploadPlanInFirebase(UserModel userModel);

}
