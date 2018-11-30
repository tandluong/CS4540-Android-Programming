package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder> {
    Context mContext;
    ArrayList<NewsItem> mRepos;
    private NewsItemViewModel mViewModel;

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

    public class NewsItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title;
        TextView name;
        TextView url;
        TextView description;
        TextView date;

        public NewsItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            name = itemView.findViewById(R.id.name);
            url = itemView.findViewById(R.id.url);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }

        void bind(final int listIndex) {
            title.setText(mRepos.get(listIndex).getTitle());
            name.setText((mRepos.get(listIndex).getName()));
            url.setText(mRepos.get(listIndex).getUrl());
            description.setText(mRepos.get(listIndex).getDescription());
            date.setText(mRepos.get(listIndex).getDate());
            Picasso.get().load(mRepos.get(listIndex).getUrlToImage()).into(image);
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
