package com.robi10minute.robitenminute.adapter;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.robi10minute.robitenminute.databinding.ItemParentBinding;
//import com.robi10minute.robitenminute.databinding.ItemSecondLayoutBinding;
//
//public class ParentAdapter extends RecyclerView.Adapter {
//    private List list;
//    private Context context;
//
//    public ParentAdapter(List<Item> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        if (Item.class.isInstance(list.get(position))){
//            return 0;
//        }
//        return 1;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if (this.getItemViewType(viewType) == 0) {
//            ItemParentBinding parentBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_parent, parent, false);
//        return new FirstViewHolder(parentBinding);
//        }
//        else {
//            ItemSecondLayoutBinding secondBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_second_layout, parent, false);
//            return new SecondViewHolder(secondBinding);
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        if(this.getItemViewType(position) == 0){
//            Item chapterItem = (Item) list.get(position);
//            FirstViewHolder viewHolder = (FirstViewHolder)holder;
//
//            viewHolder.parentBinding.chapterTitleTv.setText(chapterItem.getTitle());
//
//            List<ItemSecond> childList = new ArrayList<>();
//            for (int i=1; i<childList.size(); i++){
//
//                childList.add(new ItemSecond(1,"Hello","Hi"));
//                childList.add(new ItemSecond(1,"Hello","Hi"));
//                childList.add(new ItemSecond(1,"Hello","Hi"));
//                childList.add(new ItemSecond(1,"",""));
//                childList.add(new ItemSecond(1,"",""));
//            }
//
//            ChildAdapter childAdapter = new ChildAdapter(childList);
//            viewHolder.parentBinding.chapterSubItemRv.setLayoutManager(new LinearLayoutManager(context));
//            viewHolder.parentBinding.chapterSubItemRv.setAdapter(childAdapter);
//        }
//
//        else {
//            final ItemSecond secondItem = (ItemSecond)list.get(position);
////            SecondViewHolder viewHolderSecond = (SecondViewHolder)holder;
//
//            SecondViewHolder secondViewHolder = (SecondViewHolder)holder;
//            secondViewHolder.secondBinding.itemParentIv.setImageResource(secondItem.getImg());
//            secondViewHolder.secondBinding.itemParentTitleTv.setText(secondItem.getTitle());
//            secondViewHolder.secondBinding.itemParentAuthorTv.setText(secondItem.getDocAuthor());
//
//            secondViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(context, secondItem.getTitle(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }
//
////    @Override
////    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
////        final Item parentItem = list.get(position);
////
////
////        String item = new Item().getType();
////
//////        if(item == "CHAPTER"){
//////            holder.parentBinding.itemSecondLinLayout.setVisibility(View.GONE);
//////            holder.parentBinding.itemChapterLinLayout.setVisibility(View.VISIBLE);
//////
//////            holder.parentBinding.chapterTitleTv.setText(parentItem.getTitle());
//////
//////            List<Item> childList = new ArrayList<>();
//////            for (int i=1; i<childList.size(); i++){
//////                childList.add(new Item());
//////            }
//////
//////            ChildAdapter childAdapter = new ChildAdapter(childList);
//////            holder.parentBinding.chapterSubItemRv.setLayoutManager(new LinearLayoutManager(context));
//////            holder.parentBinding.chapterSubItemRv.setAdapter(childAdapter);
//////        }
////    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public static class FirstViewHolder extends RecyclerView.ViewHolder {
//        private ItemParentBinding parentBinding;
//        public FirstViewHolder(ItemParentBinding parentBinding) {
//            super(parentBinding.getRoot());
//            this.parentBinding = parentBinding;
//        }
//    }
//
//    public static class SecondViewHolder extends RecyclerView.ViewHolder {
//        private ItemSecondLayoutBinding secondBinding;
//        public SecondViewHolder(ItemSecondLayoutBinding secondBinding) {
//            super(secondBinding.getRoot());
//            this.secondBinding = secondBinding;
//        }
//    }
//}
