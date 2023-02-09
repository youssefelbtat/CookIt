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
import com.example.cookit.model.MealModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {

    RecyclerView recyclerView;
    TextView textView ;
    List<MealModel> category;
    RecyclerCategoriesAdapter recyclerCategoriesAdapter;

    GridLayoutManager gridLayoutManager;

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

        recyclerView = view.findViewById(R.id.recyclerCategory);
        textView = view.findViewById(R.id.categoryText);
        category = new ArrayList<>();

        textView.setText("Beef");
        /*category.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        category.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        category.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));
        category.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        category.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        category.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));
        category.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        category.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        category.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));*/

        recyclerView.setHasFixedSize(true);
        gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerCategoriesAdapter=new RecyclerCategoriesAdapter(getContext(),category);
        recyclerCategoriesAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(recyclerCategoriesAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}