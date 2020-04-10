package com.example.movie.ui.home;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.movie.R;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {


    private HomeViewModel homeViewModel;
    private TabLayout tanNavHome;
    private ViewPager homeViewpager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tanNavHome = view.findViewById(R.id.tan_nav_home);
        homeViewpager = view.findViewById(R.id.home_viewpager);
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(this.getChildFragmentManager(),0);
        homeViewpager.setAdapter(homePagerAdapter);
        tanNavHome.setupWithViewPager(homeViewpager);
    }

    String[] title = {"Hot","Coming"};
    class HomePagerAdapter extends FragmentPagerAdapter{

        private HomeFragmentChild_Hot homeFragmentChild_hot;
        private HomeFragmentChild_Coming homeFragmentChild_coming;
        private HomeFragmentChild_Cinema homeFragmentChild_cinema;

        public HomePagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
            homeFragmentChild_cinema = new HomeFragmentChild_Cinema();
            homeFragmentChild_coming = new HomeFragmentChild_Coming();
            homeFragmentChild_hot = new HomeFragmentChild_Hot();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position == 0) {
                return homeFragmentChild_hot;
            }
            else if(position ==1) {
                return homeFragmentChild_coming;
            }
            else if(position ==2) {
                return homeFragmentChild_cinema;
            }
            return homeFragmentChild_hot;
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
