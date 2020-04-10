package com.example.movie.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.Cinema;
import com.example.movie.Moive;
import com.example.movie.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentChild_Cinema extends Fragment {
    private View view;

    private RecyclerView cinemaRecyclerView;

    private List<Cinema> cinemas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.home_fragment_cinema,container,false);

        initData();

        //1.初始化控件
        cinemaRecyclerView = view.findViewById(R.id.recycler_cinema);
        //2.设置RecycleView布局管理器
        LinearLayoutManager ll =new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        cinemaRecyclerView.setLayoutManager(ll);
        //3.初始化数据适配器
        CinemaAdapter cinemaAdapter = new CinemaAdapter(cinemas,HomeFragmentChild_Cinema.this.getActivity());
        //4.设置动画，采用默认动画
        cinemaRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //5.设置适配器到view中
        cinemaRecyclerView.setAdapter(cinemaAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initData(){
        if(cinemas.size()>4)
            for(int i =0;i<cinemas.size();i++){
                cinemas.remove(cinemas.get(i));
            }
        else {
            cinemas.add(new Cinema("XX影院", "XX省/XX市/XX大街/XX号", "188m"));
            cinemas.add(new Cinema("XX影院", "YY省/YY市/YY大街/YY号", "788m"));
            cinemas.add(new Cinema("XX影院", "XX省/XX市/ASS大街/BIG号", "123m"));
            cinemas.add(new Cinema("XX影院", "XX省/XX市/FUCK大街/YOU号", "89m"));
        }
    }

}
