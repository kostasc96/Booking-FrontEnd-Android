package com.example.booking.adapters;

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
import com.example.booking.RowItemReservation;

import java.util.List;

public class RowItemReservationBaseAdapter extends BaseAdapter {
    Context context;
    List<RowItemReservation> rowItems;

    public RowItemReservationBaseAdapter (Context context, List<RowItemReservation> items) {
        this.context = context;
        this.rowItems = items;
    }
    private class ViewHolder {
        TextView txtCondition;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        RowItemReservationBaseAdapter.ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_reservation, null);
            holder = new RowItemReservationBaseAdapter.ViewHolder();
            holder.txtCondition = (TextView) convertView.findViewById(R.id.list_item_reservation_condition);
            convertView.setTag(holder);
        }
        else {
            holder = (RowItemReservationBaseAdapter.ViewHolder) convertView.getTag();
        }

        RowItemReservation rowItem = (RowItemReservation) getItem(position);

        holder.txtCondition.setText(rowItem.getCondition());

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
