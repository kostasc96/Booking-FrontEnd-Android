package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.booking.api.RetrofitApi;
import com.example.booking.classes.ApiResponse;
import com.example.booking.classes.JwtAuthenticationResponse;
import com.example.booking.classes.LoginRequest;
import com.example.booking.client.RetrofitClient;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogIn extends AppCompatActivity {
    String usernameOrEmail, password;
    RetrofitApi apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        apiInterface = RetrofitClient.getClient().create(RetrofitApi.class);

        final EditText login_username, login_password;
        Button login_Btn = (Button) findViewById(R.id.login_Btn);;

        login_username = (EditText) findViewById(R.id.login_username);
        login_password = (EditText) findViewById(R.id.login_password);


        login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                usernameOrEmail = login_username.getText().toString();
                password = login_password.getText().toString();

                LoginRequest loginReq = new LoginRequest();

                loginReq.setUsernameOrEmail(usernameOrEmail);
                loginReq.setPassword(password);

//                AsyncTaskRunner postReq = new AsyncTaskRunner();
//                postReq.execute();
//                try{
//                    URL url = new URL ("http://localhost:8085/api/auth/signin");
//                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
//                    con.setRequestMethod("POST");
//                    con.setRequestProperty("Content-Type", "application/json; utf-8");
//                    con.setRequestProperty("Accept", "application/json");
//                    con.setDoOutput(true);
//                    String jsonInputString = "{'usernameOrEmail': 'test', 'password': 'test'}";
//
//                } catch (Exception e) {
//
//                }


                Call<JwtAuthenticationResponse> call = apiInterface.authenticateUser(loginReq);
                call.enqueue(new Callback<JwtAuthenticationResponse>() {
                    @Override
                    public void onResponse(Call<JwtAuthenticationResponse> call, Response<JwtAuthenticationResponse> response) {

                        JwtAuthenticationResponse pojoclass = response.body();
                        Toast.makeText(getApplicationContext(),"On Response!", Toast.LENGTH_SHORT).show();
                        Intent intent_userEntrance = new Intent(LogIn.this, UserEntrance.class);
                        intent_userEntrance.putExtra("accessToken",pojoclass.getAccessToken());
                        startActivity(intent_userEntrance);
                    }

                    @Override
                    public void onFailure(Call<JwtAuthenticationResponse> call, Throwable t) {
                        call.cancel();
                        Toast.makeText(getApplicationContext(),"On Failure!", Toast.LENGTH_SHORT).show();
                    }
                });


                Toast.makeText(getApplicationContext(), "Successfully logged in !!! ",Toast.LENGTH_SHORT).show();
//                Intent intent_userEntrance = new Intent(LogIn.this, UserEntrance.class);
//                startActivity(intent_userEntrance);
            }

        });


    }
//    private class AsyncTaskRunner extends AsyncTask<String,String,String> {
//        @Override
//        protected String doInBackground(String... params) {
//            try {
//                String url = "http://127.0.0.1:8085/api/auth/signin";
////                String url = "http://10.0.2.2:8085/api/auth/signin";
//                URL object = new URL(url);
//
//
//                HttpURLConnection con = (HttpURLConnection) object.openConnection();
//                con.setDoOutput(true);
//                con.setDoInput(true);
//                con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//                con.setRequestMethod("POST");
//
//                JSONObject cred = new JSONObject();
//                cred.put("usernameOrEmail", usernameOrEmail);
//                cred.put("password", password);
//
//                DataOutputStream localDataOutputStream = new DataOutputStream(con.getOutputStream());
//                localDataOutputStream.writeBytes(cred.toString());
//                localDataOutputStream.flush();
//                localDataOutputStream.close();
//
//
//            } catch (Exception e) {
//                Log.v("ErrorAPP", e.toString());
//            }
//            return "";
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            Toast.makeText(getApplicationContext(), "Post Executing !!! ",Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            Toast.makeText(getApplicationContext(), "PreExecuting !!! ",Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        protected void onProgressUpdate(String... values) {
//            super.onProgressUpdate(values);
//            Toast.makeText(getApplicationContext(), "Progress Updating !!! ",Toast.LENGTH_SHORT).show();
//        }
//    }

}