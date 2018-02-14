package com.example.asus.bbcnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.bbcnews.DetailActivity;
import com.example.asus.bbcnews.R;
import com.example.asus.bbcnews.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by asus on 2/13/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> news;
    private int rowLayout;
    private Context context;
    private String url;

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        LinearLayout newsLayout;
        TextView Title;
        TextView Description;
        TextView PublishedAt;
        ImageView NewsImage;

        public NewsViewHolder(View v) {
            super(v);
            newsLayout = v.findViewById(R.id.NewsLayout);
            Title = v.findViewById(R.id.tv_title);
            Description = v.findViewById(R.id.tv_description);
            PublishedAt = v.findViewById(R.id.tv_publishedtime);
            NewsImage = v.findViewById(R.id.iv_img);
        }
    }

    public NewsAdapter(List<News> news,int rowLayout,Context context){
        this.news = news;
        this.rowLayout = rowLayout;
        this.context = context;
    }



    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.NewsViewHolder holder, final int position) {
        holder.Title.setText(news.get(position).getTitle());
        holder.Description.setText(news.get(position).getDescription());
        holder.PublishedAt.setText(news.get(position).getDate());
        Picasso.with(context).load(news.get(position).getImageUrl())
                .resize(300,180)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.NewsImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = news.get(position).getUrl();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.setData(Uri.parse(url));
                Toast.makeText(context, "Please Wait " , Toast.LENGTH_LONG).show();
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
