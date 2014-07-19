package com.robot.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.ButterKnife;

/**
 * A simple adapter for lists of elements. This class automatically handles view holding on your
 * behalf so you don't have to. To use simply subclass and implement the {@link #getViewHolder(Object, int, android.view.View)}.
 */
public abstract class ListAdapter<T> extends BaseAdapter {

    private List<T> list;
    private LayoutInflater inflater;
    private int resource;

    public ListAdapter(Context context, int resource){
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource = resource;
        this.list = new ArrayList<T>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        T model = getItem(position);

        ViewHolder<T> holder;
        if(view != null){
            holder = (ViewHolder<T>) view.getTag();
        }
        else {
            view = inflater.inflate(resource, parent, false);
            holder = getViewHolder(model, position, view);
            ButterKnife.inject(holder, view);
            view.setTag(holder);
        }

        holder.update(model, position);
        return view;
    }

    public void add(T el){
        list.add(el);
    }

    public void addAll(Collection<? extends T> elements){
        for (T el : elements) {
            add(el);
        }
    }

    public abstract ViewHolder<T> getViewHolder(T model, int pos, View view);

    public interface ViewHolder<T>{

        public void update(T t, int pos);
    }
}
