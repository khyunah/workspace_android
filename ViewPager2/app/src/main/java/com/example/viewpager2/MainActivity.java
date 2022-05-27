package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.viewpager2.adapter.ImageSliderAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    private ViewPager2 sliderImageViewPager;
    private ArrayList<String> images = new ArrayList<>();
    private LinearLayout layoutIndicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images.add("https://cdn.pixabay.com/photo/2022/04/26/13/04/sky-7158340__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2021/01/29/08/08/dog-5960092__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2020/07/10/19/07/she-5391770__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/12/13/04/fresh-strawberries-7191555__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/04/04/18/40/sunset-7112135__340.jpg");

        layoutIndicatorsContainer = findViewById(R.id.layoutIndicators);
        sliderImageViewPager = findViewById(R.id.sliderViewPager2);

        // 기본값은 1, 밑의 코드는 2개 올릴거야 하는것 ( 원래 스와이프 하는대로 로드 되는데 )
        sliderImageViewPager.setOffscreenPageLimit(2);
        sliderImageViewPager.setAdapter(new ImageSliderAdapter(this, images));

        sliderImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            // 페이지가 기준이 되었을때
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // 페이지가 기준이 되었을때 해당 사진 번호를 넘겨줘서 그번호에 해당하는 동그라미만 주황색 으로
                setCurrentIndicator(position);
            }
        });

        setupIndicators(images.size());

    } // end of onCreate

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];

        // 자바에서 코드로 속성 주기 LayoutParams
        // 뷰가 어떻게 배치될지 정의하는 속성
        // xml 파일에서 layout_ 이라는 이름을 가진 속성들을 말한다.
        // LayoutParams 객체를 통해서 다룰수 있다.

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);

            layoutIndicatorsContainer.addView(indicators[i]);
        }
    } // end of setupIndicators

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicatorsContainer.getChildCount(); // 몇개의 컴포넌트가 있는지 숫자로 알려줌

        for (int i = 0; i < childCount; i++) {

            ImageView imageView = (ImageView)layoutIndicatorsContainer.getChildAt(i);   // 리턴 타입이 View 라서 다운 캐스팅

            if(i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this,
                        R.drawable.bg_indicator_inactive));
            }
        }
    }
}