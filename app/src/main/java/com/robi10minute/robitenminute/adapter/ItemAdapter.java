package com.robi10minute.robitenminute.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.robi10minute.robitenminute.R;
import com.robi10minute.robitenminute.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {
    private List<Item> itemList;
    private Context context;

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        if (itemList.get(position).getTitle().toLowerCase().contains("chapter")) {
            return 0;
        }

        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view;
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.item_chapter, parent, false);
            return new ViewHolderChapter(view);
        }

        view = layoutInflater.inflate(R.layout.item_others, parent, false);
        return new ViewHolderOthers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final Item item = itemList.get(position);
        if (itemList.get(position).getTitle().toLowerCase().contains("chapter")) {
            final ViewHolderChapter viewHolderChapter = (ViewHolderChapter) holder;
            viewHolderChapter.chapterTitle.setText(item.getTitle());

            boolean isExpanded = itemList.get(position).isExpandable();
            viewHolderChapter.subItemRv.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            viewHolderChapter.tesTv.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

            List<Item> subList = new ArrayList<>();
            for (int i = 0; i<=4; i++) {
                subList.add(new Item(R.drawable.ic_document, "Doc File", "Rifat Khan"));
                subList.add(new Item(R.drawable.ic_document, "Doc File", "Rifat Khan"));
                subList.add(new Item(R.drawable.ic_document, "Doc File", "Rifat Khan"));
            }

            SubItemAdapter subItemAdapter = new SubItemAdapter(subList);
            viewHolderChapter.subItemRv.setLayoutManager(new LinearLayoutManager(context));
            viewHolderChapter.subItemRv.setAdapter(subItemAdapter);

        } else {
            ViewHolderOthers viewHolderOthers = (ViewHolderOthers) holder;
            viewHolderOthers.itemIv.setImageResource(item.getImg());
            viewHolderOthers.title.setText(item.getTitle());
            viewHolderOthers.author.setText(item.getAuthor());

            viewHolderOthers.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolderChapter extends RecyclerView.ViewHolder {
        private TextView chapterTitle, tesTv;
        private RecyclerView subItemRv;

        public ViewHolderChapter(@NonNull View itemView) {
            super(itemView);

            chapterTitle = itemView.findViewById(R.id.itemChapterTvId);
            tesTv = itemView.findViewById(R.id.itemTestTv);
            subItemRv = itemView.findViewById(R.id.chapterSubItemRvId);

            chapterTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Item chapterItem = itemList.get(getAdapterPosition());
                    chapterItem.setExpandable(!chapterItem.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

    class ViewHolderOthers extends RecyclerView.ViewHolder {
        private TextView title, author;
        private ImageView itemIv;

        public ViewHolderOthers(@NonNull View itemView) {
            super(itemView);

            itemIv = itemView.findViewById(R.id.itemOthersIvId);
            title = itemView.findViewById(R.id.itemOthersTitleTvId);
            author = itemView.findViewById(R.id.itemDocAuthorTvId);
        }
    }
}
