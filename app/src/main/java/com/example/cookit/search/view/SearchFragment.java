package com.example.cookit.search.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookit.R;
import com.example.cookit.favoritemeals.view.FavoriteMealsAdapter;
import com.example.cookit.model.MealModel;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    RecyclerView recyclerView;
    FavoriteMealsAdapter favoriteAdapter;
    GridLayoutManager layoutManager;
    List<MealModel> searchList= new ArrayList<MealModel>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerSearch);
        searchList.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        searchList.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));
        searchList.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        searchList.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));
        searchList.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        searchList.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));

        layoutManager=new GridLayoutManager(getContext(),2);
        favoriteAdapter=new FavoriteMealsAdapter(getContext(),searchList);
        favoriteAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(favoriteAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}