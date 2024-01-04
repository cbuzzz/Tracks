package com.example.tracks;

/**
 * Represents a music track with an ID, title, and singer.
 */
public class Track {
    // Private fields to encapsulate the internal state of the Track
    private String id;
    private String title;
    private String singer;

    // Default constructor
    public Track() {}

    /**
     * Parameterized constructor to create a Track with specified details.
     *
     * @param id     The unique identifier of the track.
     * @param title  The title of the track.
     * @param singer The singer or artist of the track.
     **/

    public Track(String id, String title, String singer) {
        this.id = id;
        this.title = title;
        this.singer = singer;
    }

    // Getter for the track ID
    public String getId() {
        return id;
    }

    // Setter for the track ID
    public void setId(String id) {
        this.id = id;
    }

    // Getter for the track title
    public String getTitle() {
        return title;
    }

    // Setter for the track title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the track singer
    public String getSinger() {
        return singer;
    }

    // Setter for the track singer
    public void setSinger(String singer) {
        this.singer = singer;
    }

    /**
     * Overrides the default toString method to provide a formatted string representation of the Track.
     *
     * @return A string containing the ID, title, and singer of the track.
     */
    @Override
    public String toString() {
        return "Track [id=" + id + ", title=" + title + ", singer=" + singer + "]";
    }
}
