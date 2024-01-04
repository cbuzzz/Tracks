package com.example.tracks;

import android.os.StrictMode;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Singleton class for managing Retrofit client instance and API interface.
 */
public class Client {
    // Replace with your actual base URL
    public static final String BASE_URL = "http://10.0.2.2:8080/dsaApp/";

    // Singleton instance
    private static Client instance = null;

    // Retrofit API interface
    private API myApi;

    // Private constructor to enforce singleton pattern
    private Client() {
        // StrictMode usage is discouraged. Use AsyncTask or other alternatives for network operations in Android.

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myApi = retrofit.create(API.class);
    }

    /**
     * Get the singleton instance of RetrofitClient.
     *
     * @return The singleton instance.
     */
    public static synchronized Client getInstance() {
        if (instance == null) {
            instance = new Client();
        }
        return instance;
    }

    /**
     * Get the Retrofit API interface.
     *
     * @return The Retrofit API interface.
     */
    public API getMyApi() {
        return myApi;
    }
}
