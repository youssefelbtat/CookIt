package com.example.cookit.home.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.cookit.R;
import com.example.cookit.model.Category;

import java.util.List;

    public class RecycleCategoryAdepter extends RecyclerView.Adapter<RecycleCategoryAdepter.ViewHolder> {

        private final Context context;
        private List<Category> list;
        public static final String TAG = "RECYCLER";

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

        public RecycleCategoryAdepter(Context context, List<Category> list) {
            this.context = context;
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.categoryitem,parent,false);
            ViewHolder viewHolder = new RecycleCategoryAdepter.ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            Glide.with(context).load("https://www.themealdb.com/images/ingredients/Lime.png")
                    .apply(new RequestOptions().override(500,500)
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_foreground)).into(holder.imageView);
            holder.name.setText(list.get(position).getStrCategory());

            holder.cardItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Navigation.findNavController(v).navigate(R.id.action_homePageFragment_to_categoryFragment);
                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


