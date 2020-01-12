package com.santi.bearhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //   GraphView graphView = (GraphView)findViewById(R.id.graphview);
/*        LineGraphSeries<DataPoint>series = new LineGraphSeries<DataPoint>(new DataPoint[]{
        new DataPoint(0,1),
        new DataPoint(4,5),
        new DataPoint(7,6),
        new DataPoint(4, 8),
        });
      //  graphView.addSeries(series);
    }

} */
    }
}