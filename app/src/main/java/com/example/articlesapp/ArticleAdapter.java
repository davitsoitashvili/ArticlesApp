package com.example.articlesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    ArrayList<ArticleModel> arrayModel;
    Context context;
    LayoutInflater inflater;

    public ArticleAdapter(ArrayList<ArticleModel> arrayModel, Context context) {
        this.arrayModel = arrayModel;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleView,bodyView,timeView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.titleView);
            bodyView = itemView.findViewById(R.id.bodyView);
            imageView = itemView.findViewById(R.id.imageView);
            timeView = itemView.findViewById(R.id.timeView);

        }
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.articles, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {
        ArticleModel item = arrayModel.get(position);
        holder.titleView.setText(item.getTitle());
        holder.bodyView.setText(item.getBody());
        holder.timeView.setText(item.getTime());
        Glide.with(context).load(item.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return arrayModel.size();
    }

}
