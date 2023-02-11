package com.example.cookit.profile.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cookit.R;
import com.example.cookit.database.firebase.FirebaseSource;
import com.example.cookit.database.sharedpreference.SharedPreferenceSource;
import com.example.cookit.model.modelFirebase.RepositoryFirebase;
import com.example.cookit.model.modelFirebase.UserModel;
import com.example.cookit.profile.presenter.profilePresenter;
import com.example.cookit.profile.presenter.profilePresenterInterface;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment implements ProfileViewInterface{

   CircleImageView profileImage , editImage ;
    TextView userName , email ;
    EditText editUserName , currentPassword , newPassword ,confirmPassword;
    ImageButton logout , editName , editPassword;

    profilePresenterInterface  profilePresenterInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

        profilePresenterInterface = new profilePresenter(RepositoryFirebase.getInstance(FirebaseSource.getInstance(getContext())
                , SharedPreferenceSource.getInstance(getContext()),getContext()));

        showData(getSavedUserData());

    }

    public void init(View view){
        profileImage = view.findViewById(R.id.profileImage);
        editImage = view.findViewById(R.id.editProfileImage);
        userName = view.findViewById(R.id.profileName);
        email = view.findViewById(R.id.profileEmail);
        editUserName = view.findViewById(R.id.editTextPersonName);
        currentPassword = view.findViewById(R.id.current_password_edt);
        newPassword = view.findViewById(R.id.new_password_edt);
        confirmPassword =view.findViewById(R.id.confirm_new_password);
        logout = view.findViewById(R.id.log_out_btn);
        editName = view.findViewById(R.id.edit_name_Imagebutton);
        editPassword = view.findViewById(R.id.sava_change_password);
    }
    @Override
    public UserModel getSavedUserData() {
        return profilePresenterInterface.getSavedUserData();
    }

    @Override
    public void showData(UserModel userModel) {
        userName.setText(userModel.getUserName());
        email.setText(userModel.getEmail());
        editUserName.setText(userModel.getUserName());
    }
}