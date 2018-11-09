package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder> {
    Context mContext;
    ArrayList<NewsItem> mRepos;

    public NewsAdapter(Context context, ArrayList<NewsItem> repos){
        this.mContext = context;
        this.mRepos = repos;
    }

    @Override
    public NewsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.news_recyclerview, parent, shouldAttachToParentImmediately);
        NewsItemViewHolder viewHolder = new NewsItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NewsItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public class NewsItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        TextView name;
        TextView url;
        TextView description;
        TextView date;

        public NewsItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            name = (TextView) itemView.findViewById(R.id.name);
            url = (TextView) itemView.findViewById(R.id.url);
            description = (TextView) itemView.findViewById(R.id.description);
            date = (TextView) itemView.findViewById(R.id.date);
        }

        void bind(final int listIndex) {
            title.setText("Title: " + mRepos.get(listIndex).getTitle());
            name.setText(("Author: " + mRepos.get(listIndex).getName()));
            url.setText("Url: " + mRepos.get(listIndex).getUrl());
            description.setText("Description: " + mRepos.get(listIndex).getDescription());
            date.setText("Date: " + mRepos.get(listIndex).getDate());
            itemView.setOnClickListener(this);
        }

        private void openWebPage(String url) {
            Uri webpage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

            if(intent.resolveActivity(mContext.getPackageManager()) != null) {
                mContext.startActivity(intent);
            }
        }

        @Override
        public void onClick(View view) {
            Log.d("view", "" + view);
            String urlString = mRepos.get(getAdapterPosition()).getUrl();
            openWebPage(urlString);
        }
    }
}
