package com.example.movie.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.Moive;
import com.example.movie.MoiveDetailActivity;
import com.example.movie.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentChild_Hot extends Fragment {

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
            MovierecyclerviewAdapter moiverAdapter = new MovierecyclerviewAdapter(moives, HomeFragmentChild_Hot.this.getActivity());
            //4.设置动画，采用默认动画
            movieRecyclerView.setItemAnimator(new DefaultItemAnimator());

            moiverAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View itemView, int position) {
                    Moive movie = moives.get(position);
                    JumpToDetail(movie);
                }
            });

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
        Moive moive = new Moive(R.mipmap.moive1,"2","饥饿站台","El hoyo","科幻 / 惊悚",
                "加尔德·加兹特鲁·乌鲁蒂亚",
                ": 伊万·马萨戈 / 佐里昂·伊圭里奥尔 / 安东尼亚·圣胡安 / 埃米利奥·布阿勒 / 亚历山德拉·玛桑凯 /");
        moives.add(moive);
        moives.add(new Moive(R.mipmap.moive2,"2","1917","1917 ","剧情 / 战争",
                "萨姆·门德斯",
                "乔治·麦凯 / 迪恩·查尔斯·查普曼 / 科林·费尔斯 / 本尼迪克特·康伯巴奇 / 马克·斯特朗 / "));
        moives.add(moive);
        moives.add(new Moive(R.mipmap.moive2,"2","1917","1917 ","剧情 / 战争",
                "萨姆·门德斯",
                "乔治·麦凯 / 迪恩·查尔斯·查普曼 / 科林·费尔斯 / 本尼迪克特·康伯巴奇 / 马克·斯特朗 / "));
    }

    public void JumpToDetail(Moive moive){
        Intent intent = new Intent(this.getActivity(), MoiveDetailActivity.class);
        Bundle movieBundle = new Bundle();
        movieBundle.putInt("img",moive.getPostImg());
        movieBundle.putString("title",moive.getTitle());
        movieBundle.putString("otitle",moive.getoTitle());
        movieBundle.putString("director",moive.getDirector());
        movieBundle.putString("cast",moive.getCast());
        movieBundle.putString("genre",moive.getGenres());
        intent.putExtra("bundle",movieBundle);
        startActivity(intent);
    }

}
