package com.example.cookit.home.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.cookit.R;
import com.example.cookit.model.Category;
import com.example.cookit.model.MealModel;

import java.util.Arrays;
import java.util.List;

public class HomePageFragment extends Fragment {

    RecyclerView viewPager2;
    RecyclerView category;
    RecyclerView country;

    RecyclerView meal;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager2 = view.findViewById(R.id.viewPager);
        viewPager2.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        viewPager2.setLayoutManager(linearLayoutManager);

        List<MealModel> meals = Arrays.asList();
        ViewPagerAdepter viewPagerAdepter = new ViewPagerAdepter(view.getContext(),meals);
        viewPager2.setAdapter(viewPagerAdepter);



        category = view.findViewById(R.id.categoryRecycler);
        category.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(view.getContext());
        linearLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);
        category.setLayoutManager(linearLayoutManager2);
        List<Category> categories = Arrays.asList(new Category(
                        "Beef")
                ,new Category("Beef"
                ),new Category("Beef"
                ),new Category("Beef"
                ),new Category("Beef"
                ),new Category("Beef"
                ),new Category("Beef"
                ),new Category("Beef"
                ));
        RecycleCategoryAdepter recycleCategoryAdepter = new RecycleCategoryAdepter(view.getContext(),categories);
        category.setAdapter(recycleCategoryAdepter);



        country = view.findViewById(R.id.countryRecycler);
        country.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(view.getContext());
        linearLayoutManager3.setOrientation(RecyclerView.HORIZONTAL);
        country.setLayoutManager(linearLayoutManager3);
        List<Category> countries = Arrays.asList(new Category(
                        "Egypt")
                ,new Category("Egypt"
                ),new Category("Egypt"
                ),new Category("Egypt"
                ),new Category("Egypt"
                ),new Category("Egypt"
                ),new Category("Egypt"
                ),new Category("Egypt"
                ));
        RecycleCountryAdepter recycleCountryAdepter = new RecycleCountryAdepter(view.getContext(),countries);
        country.setAdapter(recycleCountryAdepter);

    }
}