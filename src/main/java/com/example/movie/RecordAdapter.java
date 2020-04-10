package com.example.movie;

import android.content.Context;
import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordAdapter extends BaseAdapter {

    private List<MovieRecord> movieRecords = new ArrayList<>();

    private Context context;

    public RecordAdapter(Context context,List<MovieRecord> movieRecords) {
        this.movieRecords = movieRecords;
        this.context = context;
    }

    @Override
    public int getCount() {
        return movieRecords.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        public TextView cinemaName;
        public TextView cinemaDistance;
        public TextView movieDateM;
        public TextView movieDateH;
        public TextView moviePrice;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.movie_record,parent,false);
            viewHolder.cinemaName = (TextView) convertView.findViewById(R.id.cinema_name);
            viewHolder.cinemaDistance = (TextView) convertView.findViewById(R.id.cinema_distance);
            viewHolder.movieDateM  = (TextView) convertView.findViewById(R.id.movie_dateM );
            viewHolder.movieDateH = (TextView) convertView.findViewById(R.id.movie_dateH);
            viewHolder.moviePrice = (TextView) convertView.findViewById(R.id.movie_price);
            convertView.setTag(viewHolder);
        }
        else {
           viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.cinemaName.setText(movieRecords.get(position).getCinema().getName());
        viewHolder.cinemaDistance.setText("distance: " + movieRecords.get(position).getCinema().getDistance() + "m");
        viewHolder.moviePrice.setText("$" + String.valueOf(movieRecords.get(position).getPrice()));
        Date showDate = movieRecords.get(position).getShowDate();
        System.out.println(showDate);
        SimpleDateFormat msdf = new SimpleDateFormat("MM-dd");
        SimpleDateFormat hsdf = new SimpleDateFormat("HH:mm");
        viewHolder.movieDateM.setText(msdf.format(showDate));
        viewHolder.movieDateH.setText(hsdf.format(showDate));
        return convertView;
    }


}
