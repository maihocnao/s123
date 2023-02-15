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

public class EventIncomingAdapter extends RecyclerView.Adapter<EventIncomingAdapter.EventViewHolder>{
    private Context mContext;
    private List<Event> eventList;

    public EventIncomingAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Event> list){
        this.eventList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incoming_event, parent,false);

        return new  EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event e= eventList.get(position);
        if (e==null){
            return;
        }
        holder.event_img.setImageResource(e.getImgScr());
        holder.event_name.setText(e.getEventName());
        holder.event_daystart.setText(e.getDayStart());
        holder.event_day_end.setText(e.getDayEnd());
        holder.event_location.setText(e.getLocation());
        String quantity = Integer.toString(e.getAmountPeople());
        holder.event_amount_people.setText(quantity);

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
        private TextView event_name, event_daystart, event_day_end, event_location, event_amount_people;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            event_img = itemView.findViewById(R.id.icm_img_event);
            event_name = itemView.findViewById(R.id.icm_event_name);
            Shader shader = new LinearGradient(0,0,0,event_name .getLineHeight(),
                    Color.parseColor("#627AF7"), Color.parseColor("#EF566A"), Shader.TileMode.REPEAT);
            Shader shader1 = new LinearGradient(50, 0, event_name.getWidth(), 30, Color.parseColor("#EF566A"), Color.parseColor("#627AF7"), Shader.TileMode.CLAMP);

            event_name.getPaint().setShader(shader1);
            event_daystart = itemView.findViewById(R.id.icm_text_day_start);
            event_day_end = itemView.findViewById(R.id.icm_day_end);
            event_location = itemView.findViewById(R.id.icm_location_text);
          event_amount_people = itemView.findViewById(R.id.icm_amountpeople_text);

        }
    }
}
