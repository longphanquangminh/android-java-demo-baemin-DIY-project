package com.phanquangminhlong.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phanquangminhlong.models.Restaurant;
import com.phanquangminhlong.MLBaemin.R;

import java.util.List;

public class Adapter extends BaseAdapter {

    Activity activity;
    int layout;
    List<Restaurant> list_restaurant;

    public Adapter(Activity activity, int layout, List<Restaurant> list_restaurant) {
        this.activity = activity;
        this.layout = layout;
        this.list_restaurant = list_restaurant;
    }

    @Override
    public int getCount() {
        return list_restaurant.size();
    }

    @Override
    public Object getItem(int i) {
        return list_restaurant.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.imv_Photo = view.findViewById(R.id.imv_photo);
            holder.txt_placeName = view.findViewById(R.id.txt_placeName);
            holder.txt_dishName = view.findViewById(R.id.txt_dishName);
            holder.txt_RatingValue = view.findViewById(R.id.txt_ratingValue);
            holder.txt_RatingCount = view.findViewById(R.id.txt_ratingCount);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        Restaurant restaurant = list_restaurant.get(i);
        holder.imv_Photo.setImageResource(restaurant.getPhoto());
        holder.txt_placeName.setText(restaurant.getPlaceName());
        holder.txt_dishName.setText(restaurant.getDishName());
        holder.txt_RatingCount.setText(restaurant.getRatingCount());
        holder.txt_RatingValue.setText(String.valueOf(restaurant.getRatingValue()));
        return view;
    }

    private class ViewHolder {
        ImageView imv_Photo;
        TextView txt_placeName, txt_dishName, txt_RatingValue, txt_RatingCount;

    }
}
