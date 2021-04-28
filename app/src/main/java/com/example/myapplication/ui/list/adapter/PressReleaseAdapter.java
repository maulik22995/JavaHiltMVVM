package com.example.myapplication.ui.list.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.data.model.Content;
import com.example.myapplication.databinding.ItemListRawBinding;

import java.util.ArrayList;
import java.util.List;


public class PressReleaseAdapter extends RecyclerView.Adapter<PressReleaseAdapter.MyViewHolder> {
    private List<Content> contentList = new ArrayList<Content>();
    private OnItemClickListener itemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ItemListRawBinding binding;

        public MyViewHolder(ItemListRawBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(Content content) {
            binding.tvTitle.setText(content.getMediaTitleCustom());
            binding.tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClicked(content);
                }
            });
        }

    }

    public PressReleaseAdapter(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(
                ItemListRawBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false
                ));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.bindData(contentList.get(position));
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public void addAllItem(List<Content> contents) {
        this.contentList.clear();
        this.contentList.addAll(contents);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        contentList.remove(position);
        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()
        notifyItemRemoved(position);
    }

    public void restoreItem(Content item, int position) {
        contentList.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }

    public interface OnItemClickListener {
        void onItemClicked(Content contents);
    }
}
