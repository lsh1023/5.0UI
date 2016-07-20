package com.lsh.complexui;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * Created by LSH on 2016/7/19.
 */
public class FragmentFactory {

    private static SparseArray<Fragment> fragments=new SparseArray<>();
    private static  final int NEW_ARMY=0;
    private static  final int NEW_SCIENCE=1;
    private static  final int NEWS_ENTERMAIN=2;
    private static  final int NEW_SOCIETY=3;
    private static  final int NEW_SPORT=4;

    public static  Fragment createFragment(int position,String msg)
    {
        //从集合中去
        Fragment fragment=fragments.get(position);
        if (fragment == null) {
            switch (position)
            {
                case NEW_ARMY:
                case NEW_SCIENCE:
                case NEWS_ENTERMAIN:
                case NEW_SOCIETY:
                case NEW_SPORT:
                    fragment=NewsFragment.newInstance(position,msg);
                    break;
            }
            //存到集合中去
            fragments.put(position,fragment);
        }
        return fragment;
    }
}
