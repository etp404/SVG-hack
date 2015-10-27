package com.example.mouldm02.svgexample;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image_view);

        final List<Integer> listOfChanges = new ArrayList() {{
            add(R.drawable.ticktocross);
            add(R.drawable.crosstoquestion);
            add(R.drawable.questiontotick);
        }};

        View button = findViewById(R.id.button);
        button.setOnClickListener(new MyOnClickListener(listOfChanges));
    }

    private class MyOnClickListener implements View.OnClickListener {
        private Iterator<Integer> iterator;
        private List<Integer> listOfChanges;

        public MyOnClickListener(List<Integer> listOfChanges) {
            this.listOfChanges = listOfChanges;
            iterator = listOfChanges.iterator();
        }

        @Override
        public void onClick(View v) {
            if (!iterator.hasNext()) {
                iterator = listOfChanges.iterator();
            }
            final AnimatedVectorDrawable tickToCross = (AnimatedVectorDrawable) getDrawable(iterator.next());
            imageView.setImageDrawable(tickToCross);
            tickToCross.start();

            ImageView imageView2 = (ImageView) findViewById(R.id.image_view2);
            final AnimatedVectorDrawable tickDraw = (AnimatedVectorDrawable) getDrawable(R.drawable.tick_draw);
            imageView2.setImageDrawable(tickDraw);
            tickDraw.start();

            ImageView redCross = (ImageView) findViewById(R.id.red_cross);
            final AnimatedVectorDrawable crossDraw = (AnimatedVectorDrawable) getDrawable(R.drawable.cross_draw);
            redCross.setImageDrawable(crossDraw);
            crossDraw.start();


        }
    }
}
