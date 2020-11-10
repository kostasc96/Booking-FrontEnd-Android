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

public class UserEntrance extends Activity implements
        AdapterView.OnItemClickListener {

    String accessToken;

    DatePicker datePicker;
    Calendar calendar;
    EditText dateViewFrom, dateViewTo ;
    Button buttonFrom, buttonTo, submit;
    int year, month, day;
    int buttonFrom_flag = 0,buttonTo_flag = 0;

    private String filteredPlace, startDate, endDate;

    Button user_profile, entrance_as_host;
    SearchView etSearch;

    public static final String[] price = new String[] { "30$",
            "43$", "55$","21$", "19$","40$", "20$","32$", "44$","55$" };
    public static final String[] place = new String[] {
            "New York",
            "Athene", "Roma","Paris", "London",
            "Sydney", "Berlin", "Barcelona", "Madrid", "Otawa" };
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
        setContentView(R.layout.activity_user_entrance);

        Intent intent = getIntent();
        accessToken = intent.getStringExtra("accessToken");

        dateViewFrom = (EditText) findViewById(R.id.dateViewFrom);
        dateViewTo = (EditText) findViewById(R.id.dateViewTo);

        buttonFrom = (Button)findViewById(R.id.buttonFrom);
        buttonTo = (Button)findViewById(R.id.buttonTo);

        etSearch = (SearchView) findViewById((R.id.simpleSearchView));
        submit = (Button)findViewById(R.id.submit);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        showDateFrom( year, month+1, day);
        showDateTo( year, month+1, day);

        user_profile = (Button) findViewById(R.id.user_profile);
        entrance_as_host = (Button) findViewById(R.id.entrance_as_host);

        filteredPlace = etSearch.getQuery().toString();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent available_rooms = new Intent(UserEntrance.this, AvailableRooms.class);
                available_rooms.putExtra("place",filteredPlace);
                available_rooms.putExtra("startDate",startDate);
                available_rooms.putExtra("endDate",endDate);
                startActivity(available_rooms);

                Toast.makeText(getApplicationContext(), "To Available rooms---"+filteredPlace+startDate+endDate,Toast.LENGTH_SHORT).show();
            }
        });
        user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent user_profile = new Intent(UserEntrance.this, UserProfile.class);
                user_profile.putExtra("flag","user");
                startActivity(user_profile);

                Toast.makeText(getApplicationContext(), "To UserProfile",Toast.LENGTH_SHORT).show();
            }
        });

        entrance_as_host.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent host_entrance = new Intent(UserEntrance.this, HostEntrance.class);
                host_entrance.putExtra("accessToken", accessToken);
                startActivity(host_entrance);

                Toast.makeText(getApplicationContext(), "To Host Entrance",Toast.LENGTH_SHORT).show();
            }
        });

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < price.length; i++) {
            RowItem item = new RowItem(images[i], price[i], place[i],rating[i], rating_img);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.user_entrance_list);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(UserEntrance.this);
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        switch(view.getId())
        {
            case R.id.buttonFrom:
                buttonFrom_flag = 1;
                showDialog(999);
                break;
            case R.id.buttonTo:
                buttonTo_flag = 1;
                showDialog(999);
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    if(buttonFrom_flag == 1){
                        showDateFrom(arg1, arg2+1, arg3);
                        buttonFrom_flag = 0;
                    }
                    if(buttonTo_flag == 1){
                        showDateTo(arg1, arg2+1, arg3);
                    }

                }
            };

    private void showDateFrom(int year, int month, int day) {
        dateViewFrom.setText(new StringBuilder().append(year).append(" - ").append(month).append(" - ").append(day));
        startDate = dateViewFrom.getText().toString();
    }
    private void showDateTo(int year, int month, int day) {
        dateViewTo.setText(new StringBuilder().append(year).append(" - ").append(month).append(" - ").append(day));
        endDate = dateViewTo.getText().toString();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
//        Intent room_reservation = new Intent(UserEntrance.this, RoomReservation.class);
//        startActivity(room_reservation);

        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.show();
    }

}