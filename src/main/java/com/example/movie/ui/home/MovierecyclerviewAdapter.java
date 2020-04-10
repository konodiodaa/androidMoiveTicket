package com.example.movie.ui.home;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.Moive;
import com.example.movie.R;

import java.util.ArrayList;
import java.util.List;

public class MovierecyclerviewAdapter extends RecyclerView.Adapter<MovierecyclerviewAdapter.MovieViewHolder>{

    private List<Moive> movieData = new ArrayList<>();
    private Context context;
    private LayoutInflater lf;
    private OnItemClickListener moiveOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.moiveOnItemClickListener = onItemClickListener;
    }


    public MovierecyclerviewAdapter(List<Moive> movieData, Context context) {
        this.movieData = movieData;
        this.context = context;
        this.lf = LayoutInflater.from(context);
    }

    @NonNull
    //创建或初始化并返回一个自定义的ViewHolder
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //填充布局，获取列表项布局
        View itemView = lf.inflate(R.layout.movie_item,parent,false);
        MovieViewHolder myViewHolder = new MovieViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    //绑定view和数据
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {
        //获取通信录数据
        holder.update();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moiveOnItemClickListener != null){
                    moiveOnItemClickListener.onItemClick(holder.itemView,position);
                }
            }
        });
    }

    @Override
    //返回当前列表中的数据项个数
    public int getItemCount() {
        return movieData.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivItemSimpleSubjectImage;
        private LinearLayout llItemSimpleSubjectRating;
        private RatingBar rbItemSimpleSubjectRating;
        private TextView tvItemSimpleSubjectRating;
        private TextView tvItemSimpleSubjectCount;
        private TextView tvItemSimpleSubjectTitle;
        private TextView tvItemSimpleSubjectOriginalTitle;
        private TextView tvItemSimpleSubjectGenres;
        private TextView tvItemSimpleSubjectDirector;
        private TextView tvItemSimpleSubjectCast;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            ivItemSimpleSubjectImage = (ImageView) itemView.findViewById(R.id.iv_item_simple_subject_image);
            llItemSimpleSubjectRating = (LinearLayout) itemView.findViewById(R.id.ll_item_simple_subject_rating);
            rbItemSimpleSubjectRating = (RatingBar) itemView.findViewById(R.id.rb_item_simple_subject_rating);
            tvItemSimpleSubjectRating = (TextView) itemView.findViewById(R.id.tv_item_simple_subject_rating);
            tvItemSimpleSubjectCount = (TextView) itemView.findViewById(R.id.tv_item_simple_subject_count);
            tvItemSimpleSubjectTitle = (TextView) itemView.findViewById(R.id.tv_item_simple_subject_title);
            tvItemSimpleSubjectOriginalTitle = (TextView) itemView.findViewById(R.id.tv_item_simple_subject_original_title);
            tvItemSimpleSubjectGenres = (TextView) itemView.findViewById(R.id.tv_item_simple_subject_genres);
            tvItemSimpleSubjectDirector = (TextView) itemView.findViewById(R.id.tv_item_simple_subject_director);
            tvItemSimpleSubjectCast = (TextView) itemView.findViewById(R.id.tv_item_simple_subject_cast);
        }

        public void update(){
           int position = this.getLayoutPosition();
           Moive moive = movieData.get(position);
           //llItemSimpleSubjectRating.setBaselineAlignedChildIndex(3);
           tvItemSimpleSubjectRating.setText("6");
           tvItemSimpleSubjectCount.setText("1");
           tvItemSimpleSubjectOriginalTitle.setText(moive.getoTitle());
           tvItemSimpleSubjectTitle.setText(moive.getTitle());
           ivItemSimpleSubjectImage.setImageResource(moive.getPostImg());
           tvItemSimpleSubjectGenres.setText(moive.getGenres());
           tvItemSimpleSubjectDirector.setText(moive.getDirector());
           tvItemSimpleSubjectCast.setText(moive.getCast());
        }
    }
}
