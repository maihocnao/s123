package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.myapplication.Event;
import com.example.myapplication.R;
import com.example.myapplication.adapter.EventCurrentAdapter;
import com.example.myapplication.adapter.EventIncomingAdapter;

import java.util.ArrayList;
import java.util.List;

public class InComingFragment extends Fragment {
    private EventIncomingAdapter eventIncomingAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =LayoutInflater.from(getContext()).inflate(R.layout.incoming_fragment, container,false);
        RecyclerView recyclerView = view.findViewById(R.id.rcv_incoming_event);
        swipeRefreshLayout = view.findViewById(R.id.icm_swipeRefreshLayout);
        eventIncomingAdapter = new EventIncomingAdapter(this.getContext()) ;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        eventIncomingAdapter.setData(getListEvent());
        recyclerView.setAdapter(eventIncomingAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                RearrangeItems();
            }
        });
        return view;
    }
    private List<Event> getListEvent() {
        List<Event> list = new ArrayList<>();
        //String eventName, int imgScr, String time, String dayStart, String dayEnd, String location, int checkedPeople, int amountPeople
        list.add(new Event("FPT Korean Festival  (F-Festival)",R.drawable.img_2,"6:00 - 8:00", "20/1/2023","21/1/2023","AL - 407",120,200));
        list.add(new Event("FPT Korean Festival  (F-Festival)",R.drawable.img_2,"6:00 - 8:00", "20/1/2023","21/1/2023", "AL - 407",130,200));
        list.add(new Event("FPT Korean Festival  ",R.drawable.img_2,"6:00 - 8:00", "2/2/2023","21/2/2023", "AL - 417",123,400));
        list.add(new Event("FPT Korean Festival  (F-Festival)",R.drawable.img_2,"6:00 - 8:00", "20/1/2023","21/1/2023", "AL - 407",110,200));
        return  list;

    }
    public void RearrangeItems() {
        // Shuffling the data of ArrayList using system time
//        Collections.shuffle(images, new Random(System.currentTimeMillis()));
//        Collections.shuffle(text, new Random(System.currentTimeMillis()));
//        Adapter adapter = new Adapter(MainActivity.this, images, text);
//        recyclerView.setAdapter(adapter);
    }
}
