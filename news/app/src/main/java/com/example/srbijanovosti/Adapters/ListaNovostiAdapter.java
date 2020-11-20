package com.example.srbijanovosti.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.srbijanovosti.Model.NewsModel;
import com.example.srbijanovosti.R;

import java.util.ArrayList;

public class ListaNovostiAdapter extends RecyclerView.Adapter<ListaNovostiAdapter.ViewHolder> {
    Context context;
    ArrayList<NewsModel.Article> articles_Arraylist;

    public ListaNovostiAdapter(Context context, ArrayList<NewsModel.Article> articles_Arraylist) {
        this.context = context;
        this.articles_Arraylist = articles_Arraylist;
    }

    @NonNull
    @Override
    public ListaNovostiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_headlines_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaNovostiAdapter.ViewHolder holder, int position) {

        //Setting Values
        Glide.with(context).load(articles_Arraylist.get(position).getUrlToImage()).into(holder.slika);
        holder.vreme.setText(articles_Arraylist.get(position).getPublishedAt());
        holder.naslov.setText(articles_Arraylist.get(position).getTitle());
        holder.detalji.setText(articles_Arraylist.get(position).getDescription());
        holder.autor.setText(articles_Arraylist.get(position).getAuthor());


    }

    @Override
    public int getItemCount() {

        return articles_Arraylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView slika;
        TextView naslov,detalji,autor,vreme;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            slika=itemView.findViewById(R.id.slika);
            naslov=itemView.findViewById(R.id.naslov);
            detalji=itemView.findViewById(R.id.detalji);
            autor=itemView.findViewById(R.id.autor);
            vreme=itemView.findViewById(R.id.vreme);

        }
    }
}
