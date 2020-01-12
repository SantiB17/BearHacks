package com.santi.bearhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);



        GraphView graph = (GraphView) findViewById(R.id.graph);
       // LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{

                //need to get Y to be the values in our potential array. Only accepts int values.
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 13),
                new DataPoint(3, 2),
                new DataPoint(4, 6),
                new DataPoint(5, 9),
                new DataPoint(6, 10)

        });
        graph.addSeries(series);
    }

}
