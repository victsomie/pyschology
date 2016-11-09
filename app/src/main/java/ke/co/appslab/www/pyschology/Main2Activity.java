package ke.co.appslab.www.pyschology;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.LimitLine;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        final int rate = 16;

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4, 0));
        entries.add(new BarEntry(rate, 1));
        entries.add(new BarEntry(6, 2));
        entries.add(new BarEntry(12, 3));
        entries.add(new BarEntry(30, 4));


        BarDataSet dataset = new BarDataSet(entries, "Your Emotions rate");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Happy");
        labels.add("Worried");
        labels.add("Sad");
        labels.add("Fearful");
        labels.add("Angry");

        BarChart chart = new BarChart(this);
        setContentView(chart);
        BarData data = new BarData(labels, dataset);
        chart.setData(data);
        chart.setDescription("Your emotions rate");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.animateY(5000);
        LimitLine line = new LimitLine(15);
        data.addLimitLine(line);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
