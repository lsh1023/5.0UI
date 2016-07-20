package com.lsh.complexui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LSH on 2016/7/19.
 */
public class NewsFragment extends Fragment{

    public static NewsFragment newInstance(int position, String msg) {
        NewsFragment fragment=new NewsFragment();
        Bundle args=new Bundle();
        args.putInt("position",position);
        args.putString("msg",msg);
        fragment.setArguments(args);
        return fragment;
    }
    public NewsFragment()
    {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView mView= (RecyclerView) view.findViewById(R.id.recycle_view);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mView.setLayoutManager(manager);

        String[] logos=new String[]{"p1","p2","p3","p4","p5","p6","p7","p8"};
        //构建数据源
        final List<Map<String,String>> mList=new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            Map<String,String> map=new HashMap<>();
            if (i <10) {
                map.put("name","美女0"+i);
            }else{
                map.put("name","美女"+i);
            }
            map.put("logo",logos[i%logos.length]);
            mList.add(map);
        }
        MyRecycleAdapter adapter=new MyRecycleAdapter(getActivity(),mList);
        mView.setAdapter(adapter);

        //处理点击事件
        adapter.setOnRecyclerItemClickListener(new MyRecycleAdapter.OnRecycleItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(),DetailActivity.class);
                Map<String,String> map=mList.get(position);
                intent.putExtra("name",(String)map.get("name"));
                intent.putExtra("logo",(String)map.get("logo"));
                startActivity(intent);
            }
        });
    }
}
