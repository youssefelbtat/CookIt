package com.example.cookit.search.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cookit.R;
import com.example.cookit.model.MealModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchMealAdapter extends RecyclerView.Adapter<SearchMealAdapter.ViewHolder> {
    Context context;
    List<MealModel> list;

    SearchClickListener searchClickListener;

    public SearchMealAdapter(Context context, List<MealModel> mealModelList,SearchClickListener searchClickListener){
        this.context=context;
        this.list =mealModelList;
        this.searchClickListener = searchClickListener;
    }
    @NonNull
    @Override
    public SearchMealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.mealitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.meal_name.setText(list.get(position).getStrMeal());
        Glide.with(context).load(list.get(position).getStrMealThumb())
                .apply(new RequestOptions().override(holder.meal_image.getWidth(),holder.meal_image.getHeight()))
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.meal_image);


        holder.btnFav.setOnClickListener( event -> {
            list.get(position).setFavorite(true);
            list.get(position).setNameDay("Not");
            searchClickListener.addToFavoriteOnClick(list.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<MealModel> list){

        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView meal_name;
        CircleImageView meal_image;
        ImageButton btnFav;
        CardView item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            meal_name =itemView.findViewById(R.id.mealName);
            meal_image =itemView.findViewById(R.id.mealImage);
            btnFav =itemView.findViewById(R.id.mealFav);
            item=itemView.findViewById(R.id.mealItemCard);

        }
    }
}

