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

import com.example.movie.Moive;
import com.example.movie.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentChild_Coming extends Fragment {

    private View view;

    private RecyclerView movieRecyclerView;

    private List<Moive> moives = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (view == null) {
            view = inflater.inflate(R.layout.home_fragment_hot, container, false);
            initData();
            //1.初始化控件
            movieRecyclerView = view.findViewById(R.id.recycler_hot);
            //2.设置RecycleView布局管理器
            movieRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            //3.初始化数据适配器
            MovierecyclerviewAdapter moiverAdapter = new MovierecyclerviewAdapter(moives, HomeFragmentChild_Coming.this.getActivity());
            //4.设置动画，采用默认动画
            movieRecyclerView.setItemAnimator(new DefaultItemAnimator());
            //5.设置适配器到view中
            movieRecyclerView.setAdapter(moiverAdapter);
        }

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
        Moive moive = new Moive(R.mipmap.movie3,"2","六月的秘密","六月的秘密","剧情 / 悬疑 / 音乐",
                "王暘",
                ": 郭富城 / 苗苗 / 吴建飞/");
        moives.add(moive);
        moives.add(new Moive(R.mipmap.movie4,"2","大红包 ","大红包 ","喜剧 / 爱情",
                "李克龙",
                "包贝尔 / 李成敏 / 贾冰 / 张一鸣 / 许君聪 /"));
        moives.add(moive);
        moives.add(new Moive(R.mipmap.moive2,"2","1917","1917 ","剧情 / 战争",
                "萨姆·门德斯",
                "乔治·麦凯 / 迪恩·查尔斯·查普曼 / 科林·费尔斯 / 本尼迪克特·康伯巴奇 / 马克·斯特朗 / "));
    }
}
