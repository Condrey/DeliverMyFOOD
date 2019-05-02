package com.example.delivermyfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

public class MainActivity extends AppCompatActivity {
    SliderLayout sliderLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout = findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :
      //setSliderViews();
    }

    //slider
    private void setSliderViews() {

        for (int i = 0; i <= 3; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.one);
                    sliderView.setDescription("Made for te bosses");

                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.two);
                    sliderView.setDescription("You dont follow us we follow you");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.three);
                    sliderView.setDescription("Simple secure and instant");
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.four);
                    sliderView.setDescription("Life made easier");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
           // sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}
