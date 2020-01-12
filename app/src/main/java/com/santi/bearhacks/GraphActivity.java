package com.santi.bearhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.Serializable;

public class GraphActivity extends AppCompatActivity {

Users Joe;
    private Serializable person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        person =  getIntent().getSerializableExtra("Joe");
        Joe = (Users) person;


        GraphView graph = (GraphView) findViewById(R.id.graph);
       // LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{

                // for(int i = 0; i < 7; i++) {
                //  new DataPoint(i, Joe.log[i])}



                //need to get Y to be the values in our potential array. Only accepts int values.
               new DataPoint(0, Joe.log[0]),
                new DataPoint(1, Joe.log[1]),
                new DataPoint(2, Joe.log[2]),
                new DataPoint(3, Joe.log[3]),
                new DataPoint(4, Joe.log[4]),
                new DataPoint(5, Joe.log[5]),
                new DataPoint(6, Joe.log[6])


        });
        graph.addSeries(series);
    }

}
