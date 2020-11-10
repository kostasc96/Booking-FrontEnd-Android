package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.booking.adapters.CustomBaseAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AvailableRooms extends Activity implements
        AdapterView.OnItemClickListener {

    Button  user_profile, entrance_as_user;

    private String filtered_place, startDate, endDate;
    public static final String[] price = new String[] { "30$",
            "43$", "55$","21$", "19$","40$", "20$","32$", "44$","55$" };
    public static final String[] place = new String[] {
            "New York",
            "Athene", "Roma","Paris", "London",
            "Sydney", "Berlin", "Barcelona", "Madrid", "London" };
    public static final Integer[] images = { R.drawable.blue_apple,
            R.drawable.cap, R.drawable.honey, R.drawable.small, R.drawable.red_apple,
            R.drawable.small, R.drawable.honey, R.drawable.blue_apple,R.drawable.man_green, R.drawable.man_round };
    public static final String[] rating = {"4.3","4.5","3.4","4.2","3.7","4.0","4.4","4.7","3.9","4.5"};
    public static final Integer rating_img = R.drawable.yellow_star;

    ListView listView;
    List<RowItem> rowItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_rooms);

        Intent myIntent = getIntent();
        filtered_place = myIntent.getStringExtra("place");
        startDate = myIntent.getStringExtra("startDate");
        endDate = myIntent.getStringExtra("endDate");
        Toast.makeText(this,"OK Received---"+filtered_place+startDate+endDate,Toast.LENGTH_SHORT).show();

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < price.length; i++) {
            RowItem item = new RowItem(images[i], price[i], place[i],rating[i], rating_img);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.avail_list);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(AvailableRooms.this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Intent room_reservation = new Intent(AvailableRooms.this, RoomReservation.class);
        startActivity(room_reservation);

        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.show();
    }

}