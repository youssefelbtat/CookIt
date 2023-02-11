package com.example.cookit.favoritemeals.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cookit.R;
import com.example.cookit.database.room.ConceretLocalSource;
import com.example.cookit.favoritemeals.presenter.FavPresenterInterface;
import com.example.cookit.favoritemeals.presenter.FavoriteMealsPresenter;
import com.example.cookit.model.MealModel;
import com.example.cookit.model.retrofit.Repository;
import com.example.cookit.network.APIResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class FavoriteMealsFragment extends Fragment implements FavViewInterface ,OnFavClickListner{

    RecyclerView recyclerView;
    Group group;
    FavoriteMealsAdapter favoriteAdapter;
    GridLayoutManager layoutManager;
    FavPresenterInterface favPresenterInterface;
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

        recyclerView.setHasFixedSize(true);
        layoutManager=new GridLayoutManager(getContext(),2);
        favoriteAdapter=new FavoriteMealsAdapter(getContext(),favList,this);

        favPresenterInterface = new FavoriteMealsPresenter((Repository.getInstance(APIResponse.getInstance(),
                ConceretLocalSource.getInstance(getContext()),getContext())));

        recyclerView.setAdapter(favoriteAdapter);
        recyclerView.setLayoutManager(layoutManager);

        favPresenterInterface.getAllStoredFavorites().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorComplete()
                .subscribe(item ->{
                    if(item.size() == 0){
                        group.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                    }else {
                        group.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        favoriteAdapter.setList(item);
                        favoriteAdapter.notifyDataSetChanged();
                    }
                });


    }
    void initUI(){
        recyclerView= recyclerView.findViewById(R.id.favItemsRecyclerView);
        group=group.findViewById(R.id.group);
    }


    @Override
    public void removeFromFav(MealModel meal) {
        favPresenterInterface.removeFromFavorite(meal);
    }

    @Override
    public void showData(List<MealModel> products) {

    }

    @Override
    public void onRemoveFavClick(MealModel mealModel) {
        removeFromFav(mealModel);
        favoriteAdapter.removeFavorite(mealModel);
        favoriteAdapter.notifyDataSetChanged();
    }
}