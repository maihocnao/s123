package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Event;
import com.example.myapplication.R;

import java.util.List;

public class EventCurrentAdapter extends RecyclerView.Adapter<EventCurrentAdapter.EventViewHolder> {
    private Context mContext;
    private List<Event> eventList;

    public EventCurrentAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Event> list){
        this.eventList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_current_event, parent,false);

        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event e= eventList.get(position);
        if (e==null){
            return;
        }
        holder.event_img.setImageResource(e.getImgScr());
        holder.event_name.setText(e.getEventName());
        holder.current_event_time.setText(e.getTime());
        holder.current_event_loction.setText(e.getLocation());
        String checkedpeople = Integer.toString(e.getCheckedPeople());
        String quantity = Integer.toString(e.getAmountPeople());
        holder.current_checked_people.setText(checkedpeople);
        holder.current_people.setText("/"+quantity);

    }

    @Override
    public int getItemCount() {
        if(eventList !=null){
            return eventList.size();
        }
        return 0;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        private ImageView event_img;
        private TextView event_name, current_event_time, current_event_loction, current_checked_people, current_people;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            event_img = itemView.findViewById(R.id.img_event);
            event_name = itemView.findViewById(R.id.event_name);
            Shader shader = new LinearGradient(0,0,0,event_name .getLineHeight(),
                    Color.parseColor("#627AF7"), Color.parseColor("#EF566A"), Shader.TileMode.REPEAT);
            Shader shader1 = new LinearGradient(50, 0, event_name.getWidth(), 30, Color.parseColor("#EF566A"), Color.parseColor("#627AF7"), Shader.TileMode.CLAMP);

            event_name.getPaint().setShader(shader1);
            current_event_time = itemView.findViewById(R.id.current_time_text);
            current_event_loction = itemView.findViewById(R.id.current_location_text);
            current_checked_people = itemView.findViewById(R.id.current_people_checked_text);
            current_people = itemView.findViewById(R.id.current_people_text);
        }

//        public EventAdapter(@NonNull View itemView) {
//            super(itemView);
//

        }
}
