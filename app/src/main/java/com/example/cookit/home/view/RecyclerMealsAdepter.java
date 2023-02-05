package com.example.cookit.home.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cookit.R;
import com.example.cookit.model.Category;
import com.example.cookit.model.MealModel;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerMealsAdepter extends RecyclerView.Adapter<RecyclerMealsAdepter.ViewHolder>{

        private Context context;
        private List<MealModel> list;
        public static final String TAG = "RECYCLER";

public static class ViewHolder extends RecyclerView.ViewHolder{
    TextView meal_name;
    CircleImageView meal_image;
    ImageButton remove_from_fav;
    CardView item;

    public ViewHolder(View v){
        super(v);
        meal_name =itemView.findViewById(R.id.mealName);
        meal_image =itemView.findViewById(R.id.mealImage);
        remove_from_fav =itemView.findViewById(R.id.mealFav);
        item=itemView.findViewById(R.id.mealItemCard);

    }
}

    public RecyclerMealsAdepter(Context context, List<MealModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerMealsAdepter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mealitem,parent,false);
        RecyclerMealsAdepter.ViewHolder viewHolder = new RecyclerMealsAdepter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMealsAdepter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(list.get(position).getMealImage())
                .apply(new RequestOptions().override(500,500)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)).into(holder.meal_image);
        holder.meal_name.setText(list.get(position).getMealName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


