package com.example.booking.adapters;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.booking.R;
import com.example.booking.RowItem;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    List<RowItem> rowItems;

    public CustomBaseAdapter(Context context, List<RowItem> items) {
        this.context = context;
        this.rowItems = items;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView1, imageView2;
        TextView txtPrice;
        TextView txtPlace;
        TextView txtRating;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtPrice = (TextView) convertView.findViewById(R.id.price);
            holder.txtPlace = (TextView) convertView.findViewById(R.id.place);
            holder.txtRating = (TextView) convertView.findViewById(R.id.rating);
            holder.imageView1 = (ImageView) convertView.findViewById(R.id.icon);
            holder.imageView2 = (ImageView) convertView.findViewById(R.id.rating_img);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        RowItem rowItem = (RowItem) getItem(position);

        holder.txtPrice.setText(rowItem.getPrice());
        holder.txtPlace.setText(rowItem.getPlace());
        holder.txtRating.setText(rowItem.getRating());
        holder.imageView1.setImageResource(rowItem.getImageId());
        holder.imageView2.setImageResource(rowItem.getRating_img());

        return convertView;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }
}
