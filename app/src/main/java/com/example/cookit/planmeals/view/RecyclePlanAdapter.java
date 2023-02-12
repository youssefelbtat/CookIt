package com.example.cookit.planmeals.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cookit.R;
import com.example.cookit.itemPage.view.ItemPageActivity;
import com.example.cookit.model.MealModel;

import java.util.List;

public class RecyclePlanAdapter extends RecyclerView.Adapter<RecyclePlanAdapter.ViewHolder> {

    private final Context context;
    private List<MealModel> list;
    public static final String TAG = "RECYCLER";
    OnPlanClickListner onplanClickListner;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView name;
        public CardView cardItem;
        public View view;
        Button remove_from_plan;
        ImageButton addToFav;

        public ViewHolder(View v){
            super(v);
            view = v;
            addToFav=v.findViewById(R.id.mealFav);
            remove_from_plan=v.findViewById(R.id.remove_btn);

            imageView = v.findViewById(R.id.mealImage);
            name = v.findViewById(R.id.mealName);
            cardItem = v.findViewById(R.id.planmealitem);

        }

    }
    public void setRecyclePlanAdapterList(List<MealModel> models){
        list=models;
    }

    public RecyclePlanAdapter(Context context, List<MealModel> list,OnPlanClickListner onplanClickListner) {
        this.onplanClickListner=onplanClickListner;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclePlanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.planmealsitem,parent,false);
        RecyclePlanAdapter.ViewHolder viewHolder = new RecyclePlanAdapter.ViewHolder(view);
        return viewHolder;
    }
    public void removePlan(MealModel mealModel){
        this.list.remove(mealModel);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclePlanAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(list.get(position).getStrMealThumb())
                .apply(new RequestOptions().override(500,500)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)).into(holder.imageView);
        holder.name.setText(list.get(position).getStrMeal());

        holder.remove_from_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onplanClickListner.onRemovePlanClicked(list.get(position));
            }
        });
        holder.addToFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setFavorite(true);
                list.get(position).setNameDay("Not");

            }
        });

        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent =new Intent(context, ItemPageActivity.class);
                myIntent.putExtra("MEAL_NAME",list.get(position).getStrMeal());
                context.startActivity(myIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}