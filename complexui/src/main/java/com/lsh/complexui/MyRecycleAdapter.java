package com.lsh.complexui;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by LSH on 2016/7/19.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter <MyRecycleAdapter.MyViewHolder>{

    private final LayoutInflater inflater;
    private List<Map<String,String>> mList;
    private Context mContext;

    public interface OnRecycleItemClickListener{
        void onItemClick(View view,int position);
    }
    private OnRecycleItemClickListener mListener;

    public void setOnRecyclerItemClickListener(OnRecycleItemClickListener listener)
    {
        this.mListener=listener;
    }

    public MyRecycleAdapter(Context context,List<Map<String,String>> list) {
        inflater=LayoutInflater.from(context);
        this.mContext=context;
        this.mList=list;
    }

    static  class  MyViewHolder extends  RecyclerView.ViewHolder{

        private TextView tvName;
        private ImageView ivLogo;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName= (TextView) itemView.findViewById(R.id.tv_name);
            ivLogo= (ImageView) itemView.findViewById(R.id.iv_logo);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Map<String,String> map=mList.get(position);
        String name=map.get("name");
        holder.tvName.setText(name);

        String logoName=map.get("logo");
        int mipmap=mContext.getResources().getIdentifier(logoName,"mipmap",mContext.getPackageName());
        holder.ivLogo.setImageResource(mipmap);

        //接口回调
        holder.ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(v,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



}
