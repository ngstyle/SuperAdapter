package me.ryoka.ngstyle.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Ryoka on 15/4/19.
 */
public class ViewHolder implements View.OnClickListener{
    private View mConvertView;
    private int mPosition;
    private SparseArray<View> mViews;

    private ViewHolder(Context context,ViewGroup parent,int layoutID,int position){
        mViews = new SparseArray<View>();
        this.mPosition = position;
        mConvertView = LayoutInflater.from(context).inflate(layoutID,parent,false);
        mConvertView.setTag(this);
    }

    public static ViewHolder getInstance(Context context, View convertView, ViewGroup parent,int layoutID,int position){
        ViewHolder holder;
        if(convertView == null){
            return new ViewHolder(context,parent,layoutID,position);
        }else{
            holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    public View getConvertView(){
        return mConvertView;
    }

    private <T extends View> T getView(int viewID){
        View view = mViews.get(viewID);
        if(view == null){
            view = mConvertView.findViewById(viewID);
            mViews.put(viewID,view);
        }
        return (T) view;
    }

    public ViewHolder setText(int viewID,String text){
        ((TextView)getView(viewID)).setText(text);
        return this;
    }

    public ViewHolder setText(int viewID,int StringID){
        ((TextView)getView(viewID)).setText(Resources.getSystem().getString(StringID));
        return this;
    }

    public void SetonChildClickListener(View ...childViews){
        for (View child:childViews){
            child.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
