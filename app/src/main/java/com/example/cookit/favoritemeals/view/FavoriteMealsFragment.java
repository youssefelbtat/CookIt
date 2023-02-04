package com.example.cookit.favoritemeals.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookit.R;
import com.example.cookit.favoritemeals.presenter.FavPresenterInterface;
import com.example.cookit.favoritemeals.presenter.FavoriteMealsPresenter;
import com.example.cookit.model.MealModel;

import java.util.ArrayList;
import java.util.List;


public class FavoriteMealsFragment extends Fragment {

    RecyclerView recyclerView;
    Group group;
    FavoriteMealsAdapter favoriteAdapter;
    GridLayoutManager layoutManager;
    FavPresenterInterface favPresnter;
    List<MealModel>favList= new ArrayList<MealModel>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite_meals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= view.findViewById(R.id.favItemsRecyclerView);
        group=view.findViewById(R.id.group);
        favList.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        favList.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        favList.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));
        favList.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        favList.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        favList.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));
        favList.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        favList.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        favList.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));


        if (favList.size()==0)
        {
            group.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
        else {
            group.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            layoutManager=new GridLayoutManager(getContext(),2);
            favoriteAdapter=new FavoriteMealsAdapter(getContext(),favList);
            favoriteAdapter.notifyDataSetChanged();
            recyclerView.setAdapter(favoriteAdapter);
            recyclerView.setLayoutManager(layoutManager);
        }



    }
    void initUI(){
        recyclerView= recyclerView.findViewById(R.id.favItemsRecyclerView);
        group=group.findViewById(R.id.group);
    }


}