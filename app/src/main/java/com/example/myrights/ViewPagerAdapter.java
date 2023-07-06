package com.example.myrights;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapter extends PagerAdapter {



    Context context;

    int images[] = {
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
    };

    int images2[] = {
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
    };

    int headings[] = {

            R.string.heading_one,
            R.string.heading_two,
            R.string.heading_three,
    };

    int description[] = {

      R.string.lorem,
      R.string.lorem,
      R.string.lorem,
    };


    public ViewPagerAdapter(Context context){



        this.context = context;

    }

    @Override
    public int getCount() {
        return  headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        ImageView slidetitleimage2 = (ImageView) view.findViewById(R.id.next);
        TextView slideHeading = (TextView) view.findViewById(R.id.texttitle);
        TextView slideDesciption = (TextView) view.findViewById(R.id.textdeccription);

        slidetitleimage.setImageResource(images[position]);
        slidetitleimage2.setImageResource(images2[position]);
        slideHeading.setText(headings[position]);
        slideDesciption.setText(description[position]);

        slidetitleimage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextItem = position + 1;
                if (nextItem < getCount()) {
                    ViewPager viewPager = (ViewPager) container;
                    viewPager.setCurrentItem(nextItem);
                }
                else {
                    // Last slide clicked, open MainActivity
                    Intent intent = new Intent(context, MainScreenActivity.class);
                    context.startActivity(intent);
                }
            }
        });


        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}
