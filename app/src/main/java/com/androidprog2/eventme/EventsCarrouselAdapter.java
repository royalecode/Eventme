package com.androidprog2.eventme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidprog2.eventme.business.Event;

import java.net.ConnectException;
import java.util.List;

public class EventsCarrouselAdapter extends RecyclerView.Adapter<EventsCarrouselAdapter.EventsCarrouselViewHolder> {

    private List<Event> events;
    private Context context;

    public EventsCarrouselAdapter(List<Event> events, Context context) {
        this.events = events;
        this.context = context;
    }

    @NonNull
    @Override
    public EventsCarrouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_carrousel_event, parent, false);
        return new EventsCarrouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventsCarrouselViewHolder holder, int position) {
        holder.bind(events.get(position));
    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }

    public static class EventsCarrouselViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Event event;
        private TextView event_days;
        private TextView event_name;
        private TextView event_participants;
        private ImageView event_image;

        public EventsCarrouselViewHolder(@NonNull View itemView) {
            super(itemView);
            this.event_days = (TextView) itemView.findViewById(R.id.home_carrousel_event_days);
            this.event_name = (TextView) itemView.findViewById(R.id.home_carrousel_event_name);
            this.event_participants = (TextView) itemView.findViewById(R.id.home_carrousel_event_participations);
            this.event_image = (ImageView) itemView.findViewById(R.id.home_carrousel_event_img);
        }

        public void bind(Event _event){
            this.event = _event;
            this.event_days.setText(event.getPeriod());
            this.event_name.setText(event.getNameAndLocalization());
            this.event_participants.setText(event.getNumParticipants());
        }

        @Override
        public void onClick(View v) {
            //Open activity detail
        }
    }
}
