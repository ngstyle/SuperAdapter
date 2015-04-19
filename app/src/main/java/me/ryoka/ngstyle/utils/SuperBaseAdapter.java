package me.ryoka.ngstyle.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Ryoka on 15/4/19.
 */
public abstract class SuperBaseAdapter<T> extends BaseAdapter {
    public Context context;
    public int layoutID;
    public List<T> mDatas;

    public SuperBaseAdapter(Context context, List<T> lists, int layoutID){
        this.context = context;
        this.layoutID = layoutID;
        this.mDatas = lists;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(context,convertView,parent,layoutID,position);

        convert(holder,getItem(position));

        return holder.getConvertView();
    }

    protected abstract void convert(ViewHolder holder,T t);
}
