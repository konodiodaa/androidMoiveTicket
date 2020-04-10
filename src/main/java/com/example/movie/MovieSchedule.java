package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.movie.ui.home.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MovieSchedule extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<MovieRecord> records = new ArrayList<>();
    private Button sortDistance;
    private Button sortTime;
    private Button sortPrice;

    private ListView movieRecord;
    private RecordAdapter recordAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_schedule);

        sortDistance = (Button)findViewById(R.id.sort_by_distance);
        sortTime = (Button)findViewById(R.id.sort_by_time);
        sortPrice = (Button)findViewById(R.id.sort_by_price);

        initData();
        filterMovie();

        movieRecord = (ListView)findViewById(R.id.list_record);
        recordAdapter = new RecordAdapter(this,records);
        movieRecord.setOnItemClickListener(this);
        movieRecord.setAdapter(recordAdapter);
        sortButtonClicked();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MovieRecord movieRecord = records.get(position);
        Intent intent = new Intent(MovieSchedule.this,SeatSelection.class);
        startActivity(intent);
    }

    //deal with sort button click event
    private void sortButtonClicked(){
        sortDistance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortOnDistance();
                Toast.makeText(MovieSchedule.this,"Sort all movies on distance",Toast.LENGTH_SHORT).show();
                recordAdapter.notifyDataSetChanged();
            }
        });

        sortTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortOnTime();
                Toast.makeText(MovieSchedule.this,"Sort all movies on time",Toast.LENGTH_SHORT).show();
                recordAdapter.notifyDataSetChanged();
            }
        });

        sortPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSortPrice();
                Toast.makeText(MovieSchedule.this,"Sort all movies on price",Toast.LENGTH_SHORT).show();
                recordAdapter.notifyDataSetChanged();
            }
        });
    }

    //sort all movies upon distance
    private void sortOnDistance() {
        Collections.sort(records, new Comparator<MovieRecord>() {
            @Override
            public int compare(MovieRecord o1, MovieRecord o2) {
                int dif = o1.getCinema().getDistance() - o2.getCinema().getDistance();
                if(dif > 0 )
                    return 1;
                else if(dif < 0)
                    return -1;
                else return 0;
            }
        });
    }

    //sort all movies upon show time
    private void sortOnTime() {
        Collections.sort(records, new Comparator<MovieRecord>() {
            @Override
            public int compare(MovieRecord o1, MovieRecord o2) {
                Date o1Date = o1.getShowDate();
                Date o2Date = o2.getShowDate();
                if(o1Date.before(o2Date)){
                    return -1;
                }
                else if(o1Date.after(o2Date)){
                    return 1;
                }
                else return 0;
            }
        });
    }

    //sort all movies upon price
    private void setSortPrice(){
        Collections.sort(records, new Comparator<MovieRecord>() {
            @Override
            public int compare(MovieRecord o1, MovieRecord o2) {
                int dif = o1.getPrice() - o2.getPrice();
                if(dif > 0 )
                    return 1;
                else if(dif < 0)
                    return -1;
                else return 0;
            }
        });
    }

    //add the movie has the same title as the detail one
    private void filterMovie(){
        Intent intent = getIntent();
        String movieTitle = intent.getStringExtra("movie name");

        for(int i=0; i < records.size(); i++) {
            if(!records.get(i).getMovieTitle().toString().equals(movieTitle) )
                records.remove(i);
        }

    }

    private void initData(){
        Cinema cinema1 = new Cinema("f@影院", "chouDD省/xsn市/XX大街/XX号", 188);
        Cinema cinema2 = new Cinema("ck影院", "sYY省/YY市/bbsm大街/smdx号", 788);
        Cinema cinema3 = new Cinema("uu影院", "rzbn省/wfl市/cmns大街/ntet号", 89);
        records.add(new MovieRecord("饥饿站台",31,new Date(2020, 4-1, 1,9,30),cinema3));
        records.add(new MovieRecord("1917",34,new Date(2020, 4-1, 2,14,30),cinema2));
        records.add(new MovieRecord("饥饿站台",29,new Date(2020, 4-1, 5,13,0),cinema2));
        records.add(new MovieRecord("1917",36,new Date(2020, 4-1, 6,15,30),cinema1));
        records.add(new MovieRecord("饥饿站台",50,new Date(2020, 4-1, 11,18,0),cinema3));
        records.add(new MovieRecord("1917",40,new Date(2020, 4-1, 2,19,30),cinema1));
        records.add(new MovieRecord("饥饿站台",22,new Date(2020, 4-1, 15,22,40),cinema2));
        records.add(new MovieRecord("1917",25,new Date(2020, 4-1, 20,21,50),cinema3));
    }

}
