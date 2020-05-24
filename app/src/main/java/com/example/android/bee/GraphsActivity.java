package com.example.android.bee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian3d;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.TooltipPositionMode;


import java.util.ArrayList;
import java.util.List;

public class GraphsActivity extends AppCompatActivity {
    User user = User.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphs_activity);

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        anyChartView.setProgressBar(findViewById(R.id.progress_bar));



        Cartesian3d bar3d = AnyChart.bar3d();

        bar3d.animation(true);

        bar3d.padding(10d, 40d, 5d, 20d);

        bar3d.title("Hormones Point History");

        bar3d.yScale().minimum(0d);

        bar3d.xAxis(0).labels()
            .rotation(-90d)
            .padding(0d, 0d, 20d, 0d);

        bar3d.yAxis(0).labels().format("{%Value}{groupsSeparator: }");

        bar3d.yAxis(0).title("Points");

        List<DataEntry> data = new ArrayList<>();
        //data.add(new CustomDataEntry("Nail polish", 6229, 4376, 4054, 2381));
        for(int i= 0; i < user.getDayCounter() && i < 31;i++){
            data.add(new CustomDataEntry("Day" + (i+1),user.getDopamine().get(i),user.getEndorphins().get(i),user.getSerotonin().get(i),user.getOxytocin().get(i)));
        }
        //data.add(new CustomDataEntry("Eyebrow pencil", 9332, 8987, 5067, 1401));
        //data.add(new CustomDataEntry("Lipstick", 9256, 7376, 5054, 981));

        Set set = Set.instantiate();
        set.data(data);
        Mapping bar1Data = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping bar2Data = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping bar3Data = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping bar4Data = set.mapAs("{ x: 'x', value: 'value4' }");

        bar3d.bar(bar1Data)
            .name("Dopamine");

        bar3d.bar(bar2Data)
            .name("Endorphin");

        bar3d.bar(bar3Data)
            .name("Serotonin");

        bar3d.bar(bar4Data)
            .name("Oxytocin");

        bar3d.legend().enabled(true);
        bar3d.legend().fontSize(13d);
        bar3d.legend().padding(0d, 0d, 20d, 0d);

        bar3d.interactivity().hoverMode(HoverMode.SINGLE);

        bar3d.tooltip()
            .positionMode(TooltipPositionMode.POINT)
            .position("right")
            .anchor(Anchor.LEFT_CENTER)
            .offsetX(5d)
            .offsetY(0d)
            .format("{%Value} points");

        bar3d.zAspect("10%")
            .zPadding(20d)
            .zAngle(45d)
            .zDistribution(true);

        anyChartView.setChart(bar3d);
    }

    private class CustomDataEntry extends ValueDataEntry {
        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
        }
    }
}
