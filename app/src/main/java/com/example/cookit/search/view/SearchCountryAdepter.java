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
import com.example.cookit.model.retrofit.Country;

import java.util.List;

public class SearchCountryAdepter extends RecyclerView.Adapter<SearchCountryAdepter.ViewHolder> {

    private final Context context;
    private List<Country> list;
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

    public SearchCountryAdepter(Context context, List<Country> list, SearchClickListener searchClickListener) {
        this.context = context;
        this.list = list;
        this.searchClickListener = searchClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.categoryitem,parent,false);
        ViewHolder viewHolder = new SearchCountryAdepter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(R.drawable.egypt);
        holder.name.setText(list.get(position).getStrArea());
        holder.cardItem.setOnClickListener(event ->
                searchClickListener.countryItemOnClick(list.get(position).strArea));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Country> list){
        this.list = list;
    }
}


