package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.booking.api.RetrofitApi;
import com.example.booking.classes.ApiResponse;
import com.example.booking.classes.SignUpRequest;
import com.example.booking.client.RetrofitClient;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.booking.UserProfile.PICKFILE_RESULT_CODE;

public class SignUp extends AppCompatActivity {

//    String base64photo;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//
//        final EditText signup_username, signup_password, signup_firstname, signup_lastname, signup_email, signup_phone, signup_role;
//        Button signup_avatar;
//        Button signup_Btn = (Button) findViewById(R.id.signup_Btn);
//
//        signup_username = (EditText) findViewById(R.id.signup_username);
//        signup_password = (EditText) findViewById(R.id.signup_password);
//        signup_firstname = (EditText) findViewById(R.id.signup_firstname);
//        signup_lastname = (EditText) findViewById(R.id.signup_lastname);
//        signup_email = (EditText) findViewById(R.id.signup_email);
//        signup_phone = (EditText) findViewById(R.id.signup_phone);
//        signup_role = (EditText) findViewById(R.id.signup_role);
//        signup_avatar = (Button) findViewById(R.id.signup_avatar);
//
//        signup_avatar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
//                photoPickerIntent.setType("image/*");
//                startActivityForResult(photoPickerIntent, PICKFILE_RESULT_CODE);
//
//            }
//        });
//
//        signup_Btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String username, password, name, surname, email, mobileNumber, role;
//
//                username = signup_username.getText().toString();
//                password = signup_password.getText().toString();
//                name = signup_firstname.getText().toString();
//                surname = signup_lastname.getText().toString();
//                email = signup_email.getText().toString();
//                mobileNumber = signup_phone.getText().toString();
//                role = signup_role.getText().toString();
//
//
//
//
////                String urlString = "http://localhost:8085/api/auth/signup";
//                String urlString = "http://127.0.0.1:8085/api/auth/signup";
//                OutputStream out = null;
//
//                Toast.makeText(getApplicationContext(), "i am going to connect to the server....",Toast.LENGTH_LONG).show();
//
//                try {
//                    URL url = new URL(urlString);
//                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                    out = new BufferedOutputStream(urlConnection.getOutputStream());
//
//                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
//                    writer.write(username);
//                    writer.write(password);
//                    writer.write(name);
//                    writer.write(surname);
//                    writer.write(email);
//                    writer.write(mobileNumber);
//                    writer.write(role);
//                    writer.write(base64photo);
//                    writer.flush();
//                    writer.close();
//                    out.close();
//
//                    urlConnection.connect();
//                    Toast.makeText(getApplicationContext(), "successfully connected to the server....",Toast.LENGTH_LONG).show();
//                    Toast.makeText(getApplicationContext(), username+","+password+","+name+","+surname+","+email+","+mobileNumber+","+role+","+base64photo,Toast.LENGTH_LONG).show();
//
//                    Intent intent_login = new Intent(SignUp.this, LogIn.class);
//                    startActivity(intent_login);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                    Toast.makeText(getApplicationContext(), "Sign up failed",Toast.LENGTH_SHORT).show();
//                }
////                Toast.makeText(getApplicationContext(), username+","+password+","+firstname+","+lastname+","+email+","+phone+","+role+","+address+encodedImage,Toast.LENGTH_SHORT).show();
//
//                Intent intent_login = new Intent(SignUp.this, LogIn.class);
//                startActivity(intent_login);
//            }
//        });
//
//
//    }
//
//    @Override
//    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
//        super.onActivityResult(reqCode, resultCode, data);
//
//
//        if (resultCode == RESULT_OK) {
//            try {
//                final Uri imageUri = data.getData();
//                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
//                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
//                base64photo = encodeImage(selectedImage);
//
////                Toast.makeText(this, "Great!!! "+encodedImage, Toast.LENGTH_LONG).show();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
//            }
//
//        }else {
//            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
//        }
//    }
//
//    private String encodeImage(Bitmap bm)
//    {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
//        byte[] b = baos.toByteArray();
//        String encImage = Base64.encodeToString(b, Base64.DEFAULT);
//        return encImage;
//    }








    String base64photo;
    RetrofitApi apiInterface;


    String username, password, email, name, surname, role, mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        apiInterface = RetrofitClient.getClient().create(RetrofitApi.class);

        final EditText signup_username, signup_password, signup_firstname, signup_lastname, signup_email, signup_phone, signup_role;
        Button signup_avatar;
        Button signup_Btn = (Button) findViewById(R.id.signup_Btn);

        signup_username = (EditText) findViewById(R.id.signup_username);
        signup_password = (EditText) findViewById(R.id.signup_password);
        signup_firstname = (EditText) findViewById(R.id.signup_firstname);
        signup_lastname = (EditText) findViewById(R.id.signup_lastname);
        signup_email = (EditText) findViewById(R.id.signup_email);
        signup_phone = (EditText) findViewById(R.id.signup_phone);
        signup_role = (EditText) findViewById(R.id.signup_role);
        signup_avatar = (Button) findViewById(R.id.signup_avatar);

        signup_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, PICKFILE_RESULT_CODE);
            }
        });


        signup_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Button signup_avatar;
//                Button signup_Btn = (Button) findViewById(R.id.signup_Btn);


                username = signup_username.getText().toString();
                password = signup_password.getText().toString();
                name = signup_firstname.getText().toString();
                surname = signup_lastname.getText().toString();
                email = signup_email.getText().toString();
                mobileNumber = signup_phone.getText().toString();
                role = signup_role.getText().toString();
                Button signup_avatar = (Button) findViewById(R.id.signup_avatar);

                signup_avatar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                        photoPickerIntent.setType("image/*");
                        startActivityForResult(photoPickerIntent, PICKFILE_RESULT_CODE);
                    }
                });


                SignUpRequest signUpRequest = new SignUpRequest();
                signUpRequest.setUsername(username);
                signUpRequest.setPassword(password);
                signUpRequest.setEmail(email);
                signUpRequest.setName(name);
                signUpRequest.setSurname(surname);
                signUpRequest.setMobileNumber(mobileNumber);
                signUpRequest.setBase64photo(base64photo);
                signUpRequest.setRole(role);

                System.out.println("************************");
                System.out.println(username);
                System.out.println(password);
                System.out.println(email);
                System.out.println(base64photo);


                Call<ApiResponse> call = apiInterface.registerUser(signUpRequest);
                call.enqueue(new Callback<ApiResponse>() {
                    @Override
                    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                        ApiResponse pojoclass = response.body();
                        Toast.makeText(getApplicationContext(),"On Response!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ApiResponse> call, Throwable t) {
                        call.cancel();
                        Toast.makeText(getApplicationContext(),"On Failure!", Toast.LENGTH_SHORT).show();
                    }
                });

                Toast.makeText(getApplicationContext(),"User registration completed successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), LogIn.class));
            }
        });
    }

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

        }else {
            Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }

    private String encodeImage(Bitmap bm)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.getEncoder().encodeToString(b);
        return encImage;
    }

}