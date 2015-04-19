package me.ryoka.ngstyle.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ryoka on 15/4/19.
 */
public abstract  class SuperAdapter<T> extends BaseAdapter {
    private List<T> mDatas;
    private Context context;
    private int layoutID;

    private View mConvertView;
    private SparseArray<View> mViews;

    public SuperAdapter(Context context, List<T> lists, int layoutID){
        this.mDatas = lists;
        this.context = context;
        this.layoutID = layoutID;
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
        if(convertView == null){
            mConvertView = LayoutInflater.from(context).inflate(layoutID,parent,false);
            mViews = new SparseArray<View>();
            mConvertView.setTag(mViews);
        }else{
            mViews = (SparseArray<View>) convertView.getTag();
        }

        convert(getItem(position));


        return convertView == null ? mConvertView : convertView;
    }

    public abstract void convert(T t);

    public <V extends View> V getView(int viewID){
        View view = mViews.get(viewID);
        if(view == null){
            view = mConvertView.findViewById(viewID);
            mViews.put(viewID,view);
        }
        return (V) view;
    }

    public SuperAdapter setText(int viewID,String text){
        ((TextView)getView(viewID)).setText(text);
        return this;
    }
}
