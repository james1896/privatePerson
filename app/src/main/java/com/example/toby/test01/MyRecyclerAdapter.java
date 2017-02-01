package com.example.toby.test01;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //item类型
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_FOOTER = 1;
    public static final int TYPE_NORMAL = 2;

    private View mHeaderView;
    private View mFooterView;
    //每一行 item个数
    public static final int ITEM_ROW_COUNT = 2;

    private List<String> mDatas;
    private Context mContext;

//    private int mHeaderCount=1;   //头部View个数
//    private int mFooterCount=0;   //底部View个数

    private LayoutInflater inflater;
    private OnItemClickListener mOnItemClickListener;

    public MyRecyclerAdapter(Context context, List<String> datas){
        this. mContext=context;
        this. mDatas=datas;
        inflater=LayoutInflater. from(mContext);
    }
    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public void setFooterView(View footerView){
        mFooterView = footerView;
        notifyDataSetChanged();

    }

    //判断当前item类型
    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        if(position == mDatas.size()+1) return TYPE_FOOTER;

        return TYPE_NORMAL;
    }

//添加cell点击接口
    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return  mDatas.size() + 2;
    }
    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }
    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if(getItemViewType(position) == TYPE_HEADER) return;
        if(getItemViewType(position) == TYPE_FOOTER) return;

        final int pos = getRealPosition(holder);
//        Log.v("dafdsafdsafdsafdsafdsa",String.valueOf(pos));
        final String data = mDatas.get(pos);
        if(holder instanceof ViewHolder) {
            ((MyViewHolder) holder).tv.setText(data);
            if(mOnItemClickListener == null) return;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
        }
//        if(position == 0){
//            Log.v("head",String.valueOf(position));
//            HeaderViewHolder myHolder = (HeaderViewHolder) holder;
//        } else if(position !=0 && position < ITEM_ROW_COUNT){
//           return;
//
//        }else if(position>=mHeaderCount+mDatas.size()){
//            Log.v("footer",String.valueOf(position));
////            FooterViewHolder myHolder = (FooterViewHolder) holder;
//
//        }else {
//            Log.v("content",String.valueOf(position));
//            MyViewHolder myHolder = (MyViewHolder) holder;
//            myHolder.tv.setText(mDatas.get(position-mHeaderCount));
//            if(mOnItemClickListener!= null){
//                holder. itemView.setOnClickListener( new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        mOnItemClickListener.onClick(position);
//                    }
//                });
//
//                holder. itemView.setOnLongClickListener( new View.OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View v) {
//                        mOnItemClickListener.onLongClick(position);
//                        return false;
//                    }
//                });
//            }
//        }
    }

    //如果item为多列，解决headerView占满一行的问题
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if(manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);

            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return (getItemViewType(position) == TYPE_HEADER || getItemViewType(position) == TYPE_FOOTER)
                            ? gridManager.getSpanCount() : 1;
                }
            });
        }
    }

    //重写onCreateViewHolder方法，返回一个自定义的ViewHolder
//    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
        if(viewType == TYPE_HEADER) return new HeaderViewHolder(mHeaderView);
        if(viewType == TYPE_FOOTER) return new HeaderViewHolder(mFooterView);
        return new MyViewHolder(layout);
    }

    //cell 内容
    class MyViewHolder extends ViewHolder{
        TextView tv;
        public MyViewHolder(View view) {
            super(view);
            tv= (TextView)view.findViewById(R.id.tv_item);
        }
    }

    //头部 ViewHolder
   class HeaderViewHolder extends ViewHolder {
        TextView tv;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            tv= (TextView)itemView.findViewById(R.id.tv_item);
//            tv.setText("HeaderView");
        }
    }

    //底部 ViewHolder
   class FooterViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public FooterViewHolder(View itemView) {
            super(itemView);
            tv= (TextView)itemView.findViewById(R.id.tv_item);
//            tv.setText("FooterView");
        }
    }
}
