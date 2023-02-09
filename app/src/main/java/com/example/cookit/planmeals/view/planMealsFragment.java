package com.example.cookit.planmeals.view;

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
import com.example.cookit.model.MealModel;

import java.util.Arrays;
import java.util.List;


public class planMealsFragment extends Fragment {

    LinearLayoutManager linearLayoutManager1 , linearLayoutManager2 , linearLayoutManager3 ;

    LinearLayoutManager linearLayoutManager4 , linearLayoutManager5 , linearLayoutManager6 ,linearLayoutManager7;
    RecyclerView saturday , sunday ,monday , tuesday , wednesday , thursday , friday ;

    List<MealModel> saturdayList ;
    List<MealModel> sundayList ;
    List<MealModel> mondayList ;
    List<MealModel> tuesdayList ;
    List<MealModel> wednesdayList ;
    List<MealModel> thursdayList ;
    List<MealModel> fridayList ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plan_meals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saturday = view.findViewById(R.id.recyclerSaturday);
        sunday = view.findViewById(R.id.recyclerSunday);
        monday = view.findViewById(R.id.recyclerMonday);
        tuesday = view.findViewById(R.id.recyclerTuesday);
        wednesday = view.findViewById(R.id.recyclerWednesday);
        thursday = view.findViewById(R.id.recyclerThursday);
        friday = view.findViewById(R.id.recyclerFriday);


        saturday.setHasFixedSize(true);
        linearLayoutManager1= new LinearLayoutManager(view.getContext());
        linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);
        saturday.setLayoutManager(linearLayoutManager1);

        saturdayList = Arrays.asList(
                /*
                new MealModel("Spicy Arrabiata Penne","https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg"),
                new MealModel("Spicy Arrabiata Penne", "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg"),
                new MealModel("Spicy Arrabiata Penne","https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg"),
                new MealModel("Spicy Arrabiata Penne", "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg"),
                new MealModel("Spicy Arrabiata Penne","https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg"),
                new MealModel("Spicy Arrabiata Penne", "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg"),
                new MealModel("Spicy Arrabiata Penne","https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg"),
                new MealModel("Spicy Arrabiata Penne", "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg")*/);
        RecyclePlanAdapter recyclePlanAdapter = new RecyclePlanAdapter(view.getContext(),saturdayList);
        saturday.setAdapter(recyclePlanAdapter);

        sunday.setHasFixedSize(true);
        linearLayoutManager2= new LinearLayoutManager(view.getContext());
        linearLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);
        sunday.setLayoutManager(linearLayoutManager2);
        RecyclePlanAdapter recyclePlanAdapter2 = new RecyclePlanAdapter(view.getContext(),saturdayList);
        sunday.setAdapter(recyclePlanAdapter2);

        monday.setHasFixedSize(true);
        linearLayoutManager3= new LinearLayoutManager(view.getContext());
        linearLayoutManager3.setOrientation(RecyclerView.HORIZONTAL);
        monday.setLayoutManager(linearLayoutManager3);
        RecyclePlanAdapter recyclePlanAdapter3 = new RecyclePlanAdapter(view.getContext(),saturdayList);
        monday.setAdapter(recyclePlanAdapter3);

        tuesday.setHasFixedSize(true);
        linearLayoutManager4= new LinearLayoutManager(view.getContext());
        linearLayoutManager4.setOrientation(RecyclerView.HORIZONTAL);
        tuesday.setLayoutManager(linearLayoutManager4);
        RecyclePlanAdapter recyclePlanAdapter4 = new RecyclePlanAdapter(view.getContext(),saturdayList);
        tuesday.setAdapter(recyclePlanAdapter4);

        wednesday.setHasFixedSize(true);
        linearLayoutManager5= new LinearLayoutManager(view.getContext());
        linearLayoutManager5.setOrientation(RecyclerView.HORIZONTAL);
        wednesday.setLayoutManager(linearLayoutManager5);
        RecyclePlanAdapter recyclePlanAdapter5 = new RecyclePlanAdapter(view.getContext(),saturdayList);
        wednesday.setAdapter(recyclePlanAdapter5);

        thursday.setHasFixedSize(true);
        linearLayoutManager6= new LinearLayoutManager(view.getContext());
        linearLayoutManager6.setOrientation(RecyclerView.HORIZONTAL);
        thursday.setLayoutManager(linearLayoutManager6);
        RecyclePlanAdapter recyclePlanAdapter6 = new RecyclePlanAdapter(view.getContext(),saturdayList);
        thursday.setAdapter(recyclePlanAdapter6);

        friday.setHasFixedSize(true);
        linearLayoutManager7= new LinearLayoutManager(view.getContext());
        linearLayoutManager7.setOrientation(RecyclerView.HORIZONTAL);
        friday.setLayoutManager(linearLayoutManager7);
        RecyclePlanAdapter recyclePlanAdapter7 = new RecyclePlanAdapter(view.getContext(),saturdayList);
        friday.setAdapter(recyclePlanAdapter7);

    }
}