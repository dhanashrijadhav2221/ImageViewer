package com.app.dhanashri.imageviewer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity{

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager=(ViewPager)findViewById(R.id.vpMain);

        ViewPagerAdapter viewPagerAdapter =new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

    }

    public class ViewPagerAdapter extends PagerAdapter{

        private Context context;
        private LayoutInflater layoutInflater;
        private Integer[] images={R.drawable.automobile,R.drawable.civil2,R.drawable.entc2};
        private ImageView imageView;

        public ViewPagerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.intent,container,false);
            imageView=(ImageView)view.findViewById(R.id.ivEvent);

            imageView.setImageResource(images[position]);
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.invalidate();
        }
    }
}
