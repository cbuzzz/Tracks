package com.example.tracks;

import java.util.List;

import com.example.tracks.Track;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Interface defining RESTful API endpoints for managing tracks.
 */
public interface API {
    /**
     * Retrieves a list of tracks from the server.
     *
     * @return A Call object representing the asynchronous request for a list of tracks.
     */
    @GET("tracks")
    Call<List<Track>> getTracks();

    /**
     * Creates a new track on the server.
     *
     * @param track The track object to be created.
     * @return A Call object representing the asynchronous request for creating a track.
     */
    @POST("tracks")
    Call<Track> createTrack(@Body Track track);

    /**
     * Updates an existing track on the server.
     *
     * @param track The updated track object.
     * @return A Call object representing the asynchronous request for updating a track.
     */
    @PUT("tracks")
    Call<Void> updateTrack(@Body Track track);

    /**
     * Deletes a track from the server based on its ID.
     *
     * @param id The ID of the track to be deleted.
     * @return A Call object representing the asynchronous request for deleting a track.
     */
    @DELETE("tracks/{id}")
    Call<Void> deleteTrack(@Path("id") String id);
}
