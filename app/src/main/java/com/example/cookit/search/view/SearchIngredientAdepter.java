package com.example.cookit.search.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookit.R;
import com.example.cookit.model.retrofit.Ingredient;

import java.util.List;

public class SearchIngredientAdepter extends RecyclerView.Adapter<SearchIngredientAdepter.ViewHolder> {

    private final Context context;
    private List<Ingredient> list;
    public static final String TAG = "RECYCLER";
    SearchClickListener searchClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView name;
        public CardView cardItem;
        public View view;

        public ViewHolder(View v){
            super(v);
            view = v;
            imageView = v.findViewById(R.id.imageCategory);
            name = v.findViewById(R.id.categoryName);
            cardItem = v.findViewById(R.id.cardCategory);

        }
    }

    public SearchIngredientAdepter(Context context, List<Ingredient> list,SearchClickListener searchClickListener) {
        this.context = context;
        this.list = list;
        this.searchClickListener = searchClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.categoryitem,parent,false);
        ViewHolder viewHolder = new SearchIngredientAdepter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(R.drawable.egypt);
        holder.name.setText(list.get(position).getStrIngredient());
        holder.cardItem.setOnClickListener(event ->
                searchClickListener.ingredientItemOnclick(list.get(position).getStrIngredient()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Ingredient> list){

        this.list = list;
    }
}


