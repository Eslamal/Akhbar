package com.eslamali.news.news.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.eslamali.news.news.data.model.NewsModel.Article;
import com.eslamali.news.news.helper.HelperMethod;
import com.eslamali.news.news.ui.activity.MainActivity;
import com.eslamali.news.news.ui.fragment.NewsDetailsFragment;
import com.eslamali.news.R;
import com.eslamali.news.databinding.ItemViewNewsBinding;

import java.util.ArrayList;
import java.util.List;


public class ViewNewsAdapter extends RecyclerView.Adapter<ViewNewsAdapter.ViewHolder> {
    private Context context;
    private List<Article> newsList = new ArrayList<>();

    public ViewNewsAdapter(Context context) {
        this.context = context;

    }

    public void setNewsList(List<Article> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ItemViewNewsBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext())
                        , R.layout.item_view_news, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewNewsAdapter.ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        HelperMethod.onLoadImageFromUrl(holder.itemViewNewsBinding.itemViewNewsImvNewsImage,
                newsList.get(position).getUrlToImage(), context);

        holder.itemViewNewsBinding.itemViewNewsTxtNewsTittle.setText(newsList.get(position).getTitle());


    }

    private void setAction(ViewHolder holder, final int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailsFragment newsDetailsFragment = new NewsDetailsFragment();
                newsDetailsFragment.article = newsList.get(position);
                HelperMethod.replaceFragment(((MainActivity) context).getSupportFragmentManager(), R.id.main_Activity_frame_layout_id, newsDetailsFragment);
            }
        });

    }


    @Override
    public int getItemCount() {
        if (newsList == null)
            return 0;
        return newsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemViewNewsBinding itemViewNewsBinding;
        private View view;

        public ViewHolder(ItemViewNewsBinding binding) {
            super(binding.getRoot());
            view = binding.getRoot();
            itemViewNewsBinding = binding;
        }
    }
}
