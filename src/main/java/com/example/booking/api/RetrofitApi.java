package com.example.booking.api;

import com.example.booking.classes.ApiResponse;
import com.example.booking.classes.AvailableRoomsRequest;
import com.example.booking.classes.HostRatingRequest;
import com.example.booking.classes.JwtAuthenticationResponse;
import com.example.booking.classes.LoginRequest;
import com.example.booking.classes.RatingRequest;
import com.example.booking.classes.ReservationRequest;
import com.example.booking.classes.RoomRequest;
import com.example.booking.classes.RoomsRequest;
import com.example.booking.classes.SignUpRequest;
import com.example.booking.classes.UserPastReservationsRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitApi {

    String BASE_URL = "http://localhost:8085/";

    @Headers({"Content-type: application/json"})
    @POST("/api/auth/signup")
    Call<ApiResponse> registerUser(@Body SignUpRequest signUpRequest);

    @Headers({"Content-type: application/json"})
    @POST("/api/auth/signin")
    Call<JwtAuthenticationResponse> authenticateUser(@Body LoginRequest loginRequest);

    @Headers({"Content-type: application/json"})
    @POST("/api/rooms")
    Call<RoomRequest> createRoom(@Body RoomRequest roomRequest,  @Header("Authorization") String authHeader);

    @Headers({"Content-type: application/json"})
    @GET("/api/rooms?")
    Call<RoomRequest> getRoom(@Query("id")  Long id);

    @Headers({"Content-type: application/json"})
    @PUT("/api/rooms")
    Call<RoomRequest> updateRoom(@Body RoomRequest roomRequest);

    @Headers({"Content-type: application/json"})
    @DELETE("/api/rooms?")
    Call<Boolean> deleteRoom(@Query("id")  Long id);

    @Headers({"Content-type: application/json"})
    @POST("/api/rating")
    Call<RatingRequest> createRoom(@Body RatingRequest ratingRequest);

    @Headers({"Content-type: application/json"})
    @POST("/api/reservation")
    Call<ReservationRequest> createRoom(@Body ReservationRequest reservationRequest);

    @Headers({"Content-type: application/json"})
    @GET("/api/reservation")
    Call<List<UserPastReservationsRequest>> getPastReservations();

    @Headers({"Content-type: application/json"})
    @GET("/api/host/rating?")
    Call<HostRatingRequest> getHostRating(@Query("id")  Long id);

    @Headers({"Content-type: application/json"})
    @GET("/api/host/rooms")
    Call<List<RoomsRequest>> getHostRooms();

    @Headers({"Content-type: application/json"})
    @GET("/api/rooms/available?")
    Call<List<AvailableRoomsRequest>> availableRooms(@Query("location") String location, @Query("dateFrom")  String dateFrom,
                                                     @Query("dateTo")  String dateTo, @Query("numOfPeople")  int numOfPeople);

}
