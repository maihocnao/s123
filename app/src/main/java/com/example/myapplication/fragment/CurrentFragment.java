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
import com.example.myapplication.adapter.EventCurrentAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CurrentFragment extends Fragment {
    private EventCurrentAdapter eventCurrentAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =LayoutInflater.from(getContext()).inflate(R.layout.fragment_current, container,false);
        RecyclerView recyclerView = view.findViewById(R.id.rcv_current_event);
        eventCurrentAdapter = new EventCurrentAdapter(this.getContext());
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        eventCurrentAdapter.setData(getListEvent());
        recyclerView.setAdapter(eventCurrentAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                RearrangeItems();
            }
        });
        return  view;
    }
    private List<Event> getListEvent() {
        List<Event> list = new ArrayList<>();
        list.add(new Event("FPT Korean Festival  (F-Festival)",R.drawable.img_2,"6:00 - 8:00", "AL - 407",120,200));
        list.add(new Event("FPT Korean Festival  (F-Festival)",R.drawable.img_2,"6:00 - 8:00", "AL - 407",130,200));
        list.add(new Event("FPT Korean Festival  ",R.drawable.img_2,"6:00 - 8:00", "AL - 417",123,400));
        list.add(new Event("FPT Korean Festival  (F-Festival)",R.drawable.img_2,"6:00 - 8:00", "AL - 407",110,200));
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
