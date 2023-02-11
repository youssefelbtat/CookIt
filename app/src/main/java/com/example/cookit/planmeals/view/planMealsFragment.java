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
import com.example.cookit.database.room.ConceretLocalSource;
import com.example.cookit.favoritemeals.presenter.FavoriteMealsPresenter;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Repository;
import com.example.cookit.network.APIResponse;
import com.example.cookit.planmeals.presenter.PlanMealsPresenter;
import com.example.cookit.planmeals.presenter.PlanPresenterInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class planMealsFragment extends Fragment implements OnPlanClickListner,OnPlanViewListner{

    LinearLayoutManager[] linearLayoutManager=new LinearLayoutManager[7];
    RecyclerView []recyclerView=new RecyclerView[7];

    RecyclePlanAdapter[] recyclePlanAdapter=new RecyclePlanAdapter[7];

    PlanPresenterInterface planPresenterInterface;
    String [] daysWeak;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_plan_meals, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         daysWeak=getResources().getStringArray(R.array.weekdays);

        Init(view);

        planPresenterInterface = new PlanMealsPresenter((Repository.getInstance(APIResponse.getInstance(),
                ConceretLocalSource.getInstance(getContext()),getContext())));


      /*
        saturdayRV.setAdapter(recyclePlanAdapter);

        sundayRV.setHasFixedSize(true);
        linearLayoutManagerSat = new LinearLayoutManager(view.getContext());
        linearLayoutManagerSat.setOrientation(RecyclerView.HORIZONTAL);
        sundayRV.setLayoutManager(linearLayoutManagerSat);
        sundayRV.setAdapter(recyclePlanAdapter2);

        mondayRV.setHasFixedSize(true);
        linearLayoutManagerMon = new LinearLayoutManager(view.getContext());
        linearLayoutManagerMon.setOrientation(RecyclerView.HORIZONTAL);
        mondayRV.setLayoutManager(linearLayoutManagerMon);
        mondayRV.setAdapter(recyclePlanAdapter3);

        tuesdayRv.setHasFixedSize(true);
        linearLayoutManagerTus = new LinearLayoutManager(view.getContext());
        linearLayoutManagerTus.setOrientation(RecyclerView.HORIZONTAL);
        tuesdayRv.setLayoutManager(linearLayoutManagerTus);
        tuesdayRv.setAdapter(recyclePlanAdapter4);

        wednesdayRV.setHasFixedSize(true);
        linearLayoutManagerWed = new LinearLayoutManager(view.getContext());
        linearLayoutManagerWed.setOrientation(RecyclerView.HORIZONTAL);
        wednesdayRV.setLayoutManager(linearLayoutManagerWed);
        wednesdayRV.setAdapter(recyclePlanAdapter5);

        thursdayRV.setHasFixedSize(true);
        linearLayoutManagerThu = new LinearLayoutManager(view.getContext());
        linearLayoutManagerThu.setOrientation(RecyclerView.HORIZONTAL);
        thursdayRV.setLayoutManager(linearLayoutManagerThu);
        thursdayRV.setAdapter(recyclePlanAdapter6);

        fridayRV.setHasFixedSize(true);
        linearLayoutManagerFri.setOrientation(RecyclerView.HORIZONTAL);
        fridayRV.setLayoutManager(linearLayoutManagerFri);
        fridayRV.setAdapter(recyclePlanAdapter7);
        List<MealModel> allPlanedMeal=new ArrayList<>();*/


          getPlan(0);
          getPlan(1);
          getPlan(2);
          getPlan(3);
          getPlan(4);
          getPlan(5);
          getPlan(6);

    }
    void Init(View view){
        recyclerView[0]= view.findViewById(R.id.recyclerSaturday);
        recyclerView[1] = view.findViewById(R.id.recyclerSunday);
        recyclerView[2] = view.findViewById(R.id.recyclerMonday);
        recyclerView[3] = view.findViewById(R.id.recyclerTuesday);
        recyclerView[4] = view.findViewById(R.id.recyclerWednesday);
        recyclerView[5] = view.findViewById(R.id.recyclerThursday);
        recyclerView[6] = view.findViewById(R.id.recyclerFriday);
        linearLayoutManager[0]=new LinearLayoutManager(view.getContext());
        linearLayoutManager[1]=new LinearLayoutManager(view.getContext());
        linearLayoutManager[2]=new LinearLayoutManager(view.getContext());
        linearLayoutManager[3]=new LinearLayoutManager(view.getContext());
        linearLayoutManager[4]=new LinearLayoutManager(view.getContext());
        linearLayoutManager[5]=new LinearLayoutManager(view.getContext());
        linearLayoutManager[6]=new LinearLayoutManager(view.getContext());
        recyclePlanAdapter[0] = new RecyclePlanAdapter(view.getContext(),new ArrayList<>(),this);
        recyclePlanAdapter[1] = new RecyclePlanAdapter(view.getContext(),new ArrayList<>(),this);
        recyclePlanAdapter[2] = new RecyclePlanAdapter(view.getContext(),new ArrayList<>(),this);
        recyclePlanAdapter[3] = new RecyclePlanAdapter(view.getContext(),new ArrayList<>(),this);
        recyclePlanAdapter[4]= new RecyclePlanAdapter(view.getContext(),new ArrayList<>(),this);
        recyclePlanAdapter[5] = new RecyclePlanAdapter(view.getContext(),new ArrayList<>(),this);
        recyclePlanAdapter[6] = new RecyclePlanAdapter(view.getContext(),new ArrayList<>(),this);

    }

    @Override
    public void onRemovePlanClicked(MealModel mealModel) {
        removeMealFromPlaned(mealModel);
    }

    @Override
    public void removeMealFromPlaned(MealModel meal) {
        planPresenterInterface.removeFromPlan(meal);
        updateData(0,meal);
        updateData(1,meal);
        updateData(2,meal);
        updateData(3,meal);
        updateData(4,meal);
        updateData(5,meal);
        updateData(6,meal);
    }

    @Override
    public void ViewData(List<MealModel> Meals) {

    }
    public void updateData(int i,MealModel meal){
        recyclePlanAdapter[i].removePlan(meal);
        recyclePlanAdapter[i].notifyDataSetChanged();
    }

    public void getPlan(int i){
        planPresenterInterface.getAllPlanedMeals(daysWeak[i]).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorComplete()
                .subscribe(e->{
                    recyclerView[i].setHasFixedSize(true);
                    recyclerView[i].setAdapter(recyclePlanAdapter[i]);
                    linearLayoutManager[i].setOrientation(RecyclerView.HORIZONTAL);
                    recyclerView[i].setLayoutManager(linearLayoutManager[i]);
                    System.out.println("The size of :"+e.size());
                    recyclePlanAdapter[i].setRecyclePlanAdapterList(e);
                    recyclePlanAdapter[i].notifyDataSetChanged();
                });
    }
}