package com.robi10minute.robitenminute.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robi10minute.robitenminute.R;
import com.robi10minute.robitenminute.model.Item;

import java.util.List;

public class SubItemAdapter extends RecyclerView.Adapter<SubItemAdapter.ViewHolder> {
    List<Item> subItemList;

    public SubItemAdapter(List<Item> subItemList) {
        this.subItemList = subItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_others,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item subItem = subItemList.get(position);
        holder.img.setImageResource(subItem.getImg());
        holder.sTitle.setText(subItem.getTitle());
        holder.sAuthor.setText(subItem.getAuthor());
    }

    @Override
    public int getItemCount() {
        return subItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sTitle, sAuthor;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.itemOthersIvId);
            sTitle = itemView.findViewById(R.id.itemOthersTitleTvId);
            sAuthor = itemView.findViewById(R.id.itemDocAuthorTvId);
        }
    }
}
