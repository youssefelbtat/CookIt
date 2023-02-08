package com.example.cookit.countries.view;

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

public class CountriesFragment extends Fragment {

    RecyclerView recyclerView;
    TextView textView ;
    List<MealModel> country;
    RecyclerCountriesAdapter recyclerCountriesAdapter;

    GridLayoutManager gridLayoutManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_countries, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerCountry);
        textView = view.findViewById(R.id.countryText);
        country = new ArrayList<>();

        textView.setText("Egypt");
        country.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        country.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        country.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));
        country.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        country.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        country.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));
        country.add(new MealModel("Fettuccine Alfredo","https://www.themealdb.com/images/media/meals/0jv5gx1661040802.jpg"));
        country.add(new MealModel("Chivito uruguayo","https://www.themealdb.com/images/media/meals/n7qnkb1630444129.jpg"));
        country.add(new MealModel("Croatian Bean Stew","https://www.themealdb.com/images/media/meals/tnwy8m1628770384.jpg"));

        recyclerView.setHasFixedSize(true);
        gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerCountriesAdapter=new RecyclerCountriesAdapter(getContext(),country);
        recyclerCountriesAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(recyclerCountriesAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);


    }
}