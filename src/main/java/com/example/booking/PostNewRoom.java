package com.example.booking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.api.RetrofitApi;
import com.example.booking.classes.ApiResponse;
import com.example.booking.classes.RoomRequest;
import com.example.booking.classes.RoomsRequest;
import com.example.booking.client.RetrofitClient;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.booking.UserProfile.PICKFILE_RESULT_CODE;

public class PostNewRoom extends AppCompatActivity {

    Button save_btn;
    String accessToken;
    int year, month, day;
    EditText dateViewFrom, dateViewTo;
    private String startDate, endDate;

    String base64photo;

    private Date dateBegin, dateEnd;


    private String name;
    private String country;
    private String city;
    private String address;
    private Date beginDate;
    private Integer peopleNumber;
    private Double price;
    private Double extraCostPerPerson;
    private String roomType;
    private String rules;
    private String description;
    private Integer numberOfBeds;
    private Integer numberOfBathrooms;
    private Integer numberOfBedrooms;
    private Boolean diningRoom;
    private Double squaredMeters;
    private List<String> base64photos;
    private Long userId;
    private Boolean aircondition;
    private Boolean balcony;
    private Boolean pool;
    private Boolean smoking;
    private Boolean tv;
    private Boolean wifi;

    int buttonFrom_flag = 0, buttonTo_flag = 0;

    RetrofitApi apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_new_room);

        Intent intent = getIntent();
        accessToken = intent.getStringExtra("accessToken");

        apiInterface = RetrofitClient.getClient().create(RetrofitApi.class);

        final EditText addressTXT, cityTXT, countryTXT, nameTXT, priceTXT, squaredMetersTXT, numberOfPeopleTXT,
                descriptionTXT, beginDateTXT, endDateTXT, extraCostPerPersonTXT, bathsroomsNumberTXT, bedRoomsNumberTXT,
                bedsNumberTXT, roomTypeTXT, rulesTXT;

        final CheckBox wifiCheck, poolCheck, balconyCheck, tvCheck, airconditionCheck, smokingCheck, diningRoomCheck;

        Button postNewRoomPhotos = findViewById(R.id.post_new_room_btn_photo);
        postNewRoomPhotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, PICKFILE_RESULT_CODE);
            }
        });


        addressTXT = (EditText) findViewById(R.id.room_address);
        cityTXT = (EditText) findViewById(R.id.room_city);
        countryTXT = (EditText) findViewById(R.id.room_country);
        nameTXT = (EditText) findViewById(R.id.room_name);
        priceTXT = (EditText) findViewById(R.id.room_price);
        squaredMetersTXT = (EditText) findViewById(R.id.room_squared_meters);
        numberOfPeopleTXT = (EditText) findViewById(R.id.room_people_number);
        descriptionTXT = (EditText) findViewById(R.id.room_description);
        beginDateTXT = (EditText) findViewById(R.id.room_date_from);
        endDateTXT = (EditText) findViewById(R.id.room_date_to);
        extraCostPerPersonTXT = (EditText) findViewById(R.id.room_extra_cost);
        bathsroomsNumberTXT = (EditText) findViewById(R.id.room_bathrooms_number);
        bedsNumberTXT = (EditText) findViewById(R.id.room_beds_number);
        bedRoomsNumberTXT = (EditText) findViewById(R.id.room_bedrooms_number);
        roomTypeTXT = (EditText) findViewById(R.id.room_type);
        rulesTXT = (EditText) findViewById(R.id.room_rules);

        wifiCheck = (CheckBox) findViewById(R.id.wifi);
        poolCheck = (CheckBox) findViewById(R.id.pool);
        balconyCheck = (CheckBox) findViewById(R.id.balcony);
        tvCheck = (CheckBox) findViewById(R.id.tv);
        airconditionCheck = (CheckBox) findViewById(R.id.aircondition);
        smokingCheck = (CheckBox) findViewById(R.id.smoking);
        diningRoomCheck = (CheckBox) findViewById(R.id.diningRoom);


        save_btn = (Button) findViewById(R.id.saveRoom);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SimpleDateFormat")
            @Override
            public void onClick(View v) {
                address = addressTXT.getText().toString();
                city = cityTXT.getText().toString();
                country = countryTXT.getText().toString();
                name = nameTXT.getText().toString();
                price = Double.valueOf(priceTXT.getText().toString());
                squaredMeters = Double.valueOf(squaredMetersTXT.getText().toString());
                peopleNumber = Integer.valueOf(numberOfPeopleTXT.getText().toString());
                try {
                    dateBegin = new SimpleDateFormat("yyyy-mm-dd").parse(beginDateTXT.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                try {
                    dateEnd = new SimpleDateFormat("yyyy-mm-dd").parse(endDateTXT.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                description = descriptionTXT.getText().toString();

                wifi = wifiCheck.isChecked();
                pool = poolCheck.isChecked();
                balcony = balconyCheck.isChecked();
                tv = tvCheck.isChecked();
                aircondition = airconditionCheck.isChecked();
                smoking = smokingCheck.isChecked();
                diningRoom = diningRoomCheck.isChecked();
                extraCostPerPerson = Double.valueOf(extraCostPerPersonTXT.getText().toString());
                numberOfBathrooms = Integer.valueOf(bathsroomsNumberTXT.getText().toString());
                numberOfBedrooms = Integer.valueOf(bedRoomsNumberTXT.getText().toString());
                numberOfBeds = Integer.valueOf(bedsNumberTXT.getText().toString());
                roomType = roomTypeTXT.getText().toString();
                rules = rulesTXT.getText().toString();

                RoomRequest roomRequest = new RoomRequest();
                roomRequest.setAddress(address);
                roomRequest.setCity(city);
                roomRequest.setCountry(country);
                roomRequest.setName(name);
                roomRequest.setPrice(price);
                roomRequest.setSquaredMeters(squaredMeters);
                roomRequest.setPeopleNumber(peopleNumber);
                roomRequest.setEndDate(dateEnd);
                roomRequest.setBeginDate(dateBegin);
                roomRequest.setDescription(description);
                roomRequest.setExtraCostPerPerson(extraCostPerPerson);
                roomRequest.setNumberOfBathrooms(numberOfBathrooms);
                roomRequest.setNumberOfBedrooms(numberOfBedrooms);
                roomRequest.setNumberOfBeds(numberOfBeds);
                roomRequest.setRoomType(roomType);
                roomRequest.setRules(rules);
                roomRequest.setWifi(wifi);
                roomRequest.setPool(pool);
                roomRequest.setTv(tv);
                roomRequest.setDiningRoom(diningRoom);
                roomRequest.setBalcony(balcony);
                roomRequest.setAircondition(aircondition);


                Call<RoomRequest> call = apiInterface.createRoom(roomRequest, "Bearer " +accessToken);
                call.enqueue(new Callback<RoomRequest>() {
                    @Override
                    public void onResponse(Call<RoomRequest> call, Response<RoomRequest> response) {

                        RoomRequest pojoclass = response.body();
                        Toast.makeText(getApplicationContext(), "On Response!", Toast.LENGTH_SHORT).show();
                        Intent host_entrance = new Intent(PostNewRoom.this, HostEntrance.class);
                        host_entrance.putExtra("accessToken", accessToken);
                        startActivity(host_entrance);
                    }

                    @Override
                    public void onFailure(Call<RoomRequest> call, Throwable t) {
                        call.cancel();
                        System.err.println(t.getMessage());
                        Toast.makeText(getApplicationContext(), "On Failure!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                base64photo = encodeImage(selectedImage);

//                Toast.makeText(this, "Great!!! "+encodedImage, Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.getEncoder().encodeToString(b);
        return encImage;
    }

}