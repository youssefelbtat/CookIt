package com.example.cookit.favoritemeals.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cookit.R;
import com.example.cookit.model.MealModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FavoriteMealsAdapter extends RecyclerView.Adapter<FavoriteMealsAdapter.ViewHolder> {
    Context context;
    List<MealModel> model;
    //OnFavClickListner onListener;
    FavoriteMealsAdapter(Context context, List<MealModel> mealModelList){
        this.context=context;
        this.model=mealModelList;
        //this.onListener=onFavClickListner;
    }
    @NonNull
    @Override
    public FavoriteMealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.favorite_meal_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.meal_name.setText(model.get(position).getMealName());
        Glide.with(context).load(model.get(position).getMealImage())
                .apply(new RequestOptions().override(holder.meal_image.getWidth(),holder.meal_image.getHeight()))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.meal_image);
        holder.remove_from_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.remove(holder.getAdapterPosition());
//                onListener.onRemoveFavClick(model.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView meal_name;
        CircleImageView meal_image;
        ImageButton remove_from_fav;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_name =itemView.findViewById(R.id.fav_meal_name);
            meal_image =itemView.findViewById(R.id.fav_meal_img);
            remove_from_fav =itemView.findViewById(R.id.remove_from_fav);
        }
    }
}

