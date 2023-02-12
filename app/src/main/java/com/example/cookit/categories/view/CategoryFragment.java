package com.example.cookit.categories.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cookit.R;
import com.example.cookit.categories.presenter.CategoriesPresenter;
import com.example.cookit.categories.presenter.CategoriesPresenterInterface;
import com.example.cookit.countries.presenter.CountriesPresenter;
import com.example.cookit.countries.view.CountriesFragmentArgs;
import com.example.cookit.countries.view.RecyclerCountriesAdapter;
import com.example.cookit.database.room.ConceretLocalSource;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Repository;
import com.example.cookit.network.APIResponse;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment implements CategoriesViewInterface,OnCategoriesClickListenterInterface{

    RecyclerView recyclerView;
    TextView textView ;
    RecyclerCategoriesAdapter recyclerCategoriesAdapter;
    CategoriesPresenterInterface categoriesPresenter;

    GridLayoutManager gridLayoutManager;
    String categoryMealName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        categoryMealName = CategoryFragmentArgs.fromBundle(getArguments()).getCMealName();
        if (categoryMealName != null) {
            textView.setText(categoryMealName);
        }


        gridLayoutManager=new GridLayoutManager(getContext(),2);
        categoriesPresenter=new CategoriesPresenter(this, Repository.getInstance(APIResponse.getInstance(getContext()), ConceretLocalSource.getInstance(getContext()),view.getContext()));
        recyclerCategoriesAdapter=new RecyclerCategoriesAdapter(getContext(),new ArrayList<>(),this);
        recyclerView.setAdapter(recyclerCategoriesAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);

        categoriesPresenter.getMeals(categoryMealName);
    }

    void init(View view){
        recyclerView = view.findViewById(R.id.recyclerCategory);
        textView = view.findViewById(R.id.categoryText);
    }

    @Override
    public void ViewCategoriesMeal(List<MealModel> models) {
        recyclerCategoriesAdapter.setCategoriesMealModelList(models);
        recyclerCategoriesAdapter.notifyDataSetChanged();
    }

    @Override
    public void addToFavorite(MealModel mealModel) {
        categoriesPresenter.addToFavorite(mealModel);
    }


    @Override
    public void addToFavoriteOnClick(MealModel mealModel) {
        addToFavorite(mealModel);
    }
}