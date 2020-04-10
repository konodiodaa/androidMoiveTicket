package com.example.movie.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.Cinema;
import com.example.movie.Moive;
import com.example.movie.R;

import java.util.ArrayList;
import java.util.List;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder>{
    private List<Cinema> cinemaData = new ArrayList<>();
    private Context context;
    private LayoutInflater lf;


    public CinemaAdapter(List<Cinema> cinemaData, Context context) {
        this.cinemaData = cinemaData;
        this.context = context;
        this.lf = LayoutInflater.from(context);
    }

    @NonNull
    //创建或初始化并返回一个自定义的ViewHolder
    @Override
    public CinemaAdapter.CinemaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //填充布局，获取列表项布局
        View itemView = lf.inflate(R.layout.cinema_item,parent,false);
        CinemaAdapter.CinemaViewHolder myViewHolder = new CinemaAdapter.CinemaViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaViewHolder holder, int position) {
        holder.update();
    }

    @Override
    //返回当前列表中的数据项个数
    public int getItemCount() {
        return cinemaData.size();
    }




    class CinemaViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView address;
        private TextView distance;

        public CinemaViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.cinema_name);
            address = (TextView)itemView.findViewById(R.id.cinema_address);
            distance = (TextView)itemView.findViewById(R.id.cinema_distance);
        }

        public void update(){
            int position = this.getLayoutPosition();
            Cinema cinema = cinemaData.get(position);
            name.setText(cinema.getName());
            address.setText(cinema.getAddress());
            distance.setText(cinema.getDistance());
        }
    }
}
