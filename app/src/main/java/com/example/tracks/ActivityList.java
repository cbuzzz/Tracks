package com.example.tracks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.LinkedList;


import com.example.tracks.API;

import com.example.tracks.Client;
import com.example.tracks.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityList extends AppCompatActivity implements ClickListener {
    private API apiService;
    private RecyclerView recyclerViewTracks;
    private Adapter adapterTracks;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        // Use meaningful names for variables and initialize them
        recyclerViewTracks = findViewById(R.id.recyclerTrack);
        recyclerViewTracks.setLayoutManager(new LinearLayoutManager(this));

        apiService = Client.getInstance().getMyApi();

        // Initialize the adapter with an empty list, data will be loaded asynchronously
        adapterTracks = new Adapter(new LinkedList<>(), this);
        recyclerViewTracks.setAdapter(adapterTracks);
    }

    public void deleteTrack(View view) {
        Call<Void> call = apiService.deleteTrack(view.getTag().toString());

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {}

            @Override
            public void onFailure(Call<Void> call, Throwable t) {}
        });

        adapterTracks.deleteTrack(view.getTag().toString());
    }

    @Override
    public void ListClicked(int position) {
        Track track = adapterTracks.tracks.get(position);
        Intent intentTrack = new Intent(ActivityList.this, ActivityTrack.class);
        Bundle adapterInfo = new Bundle();
        adapterInfo.putString("id", track.getId());
        adapterInfo.putString("title", track.getTitle());
        adapterInfo.putString("singer", track.getSinger());
        intentTrack.putExtras(adapterInfo);
        ActivityList.this.startActivity(intentTrack);
    }

    public void returnMain(View view){
        Intent intentMain = new Intent(ActivityList.this, MainActivity.class);
        ActivityList.this.startActivity(intentMain);
    }

    public void addTrack(View view) {
        Intent intentAddTrack = new Intent(ActivityList.this, AddTrack.class);
        ActivityList.this.startActivity(intentAddTrack);
    }
}
