package com.example.tracks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Track> tracks;
    private static ClickListener itemListener;

    public Adapter(List<Track> tracks, ClickListener itemListener) {
        this.tracks = tracks;
        Adapter.itemListener = itemListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView id, title, singer;
        ImageView photoTrack;
        ImageView deleteImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idTrack);
            title = itemView.findViewById(R.id.titleTrack);
            singer = itemView.findViewById(R.id.singerTrack);
            photoTrack = itemView.findViewById(R.id.imgTrack);
            deleteImage = itemView.findViewById(R.id.delete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemListener.ListClicked(getLayoutPosition());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Track currentTrack = tracks.get(position);

        holder.id.setText(currentTrack.getId());
        holder.title.setText(currentTrack.getTitle());
        holder.singer.setText(currentTrack.getSinger());
        holder.photoTrack.setImageResource(R.drawable.song);
        holder.deleteImage.setTag(currentTrack.getId());
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void deleteTrack(String id) {
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getId().equals(id)) {
                tracks.remove(i);
                notifyItemRemoved(i);
                notifyItemRangeChanged(i, tracks.size());
                break; // Once the item is found and removed, exit the loop
            }
        }
    }
}
