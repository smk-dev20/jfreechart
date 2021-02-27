package test_261P;

import org.jfree.chart.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class MockingTest {
    private ChartFactory chartFactory;
    private ChartFrame chartFrame;
    private Plot plot;

    @Before
    public void setup() {
        //  Mocks are being created.
        chartFactory = mock(ChartFactory.class);
        chartFrame = mock(ChartFrame.class);
        plot = mock(Plot.class);

        MockitoAnnotations.initMocks(this);
    }
//    @Test
//    public void test1() {
//        DefaultPieDataset<String> data = new DefaultPieDataset<>();
//        data.setValue("Java", 43);
//        data.setValue("Visual Basic", 12);
//        data.setValue("C/C++", 17);
//        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
//        when(chartFrame.getChartPanel()).thenReturn(new ChartFrame("Pie Chart",pieChart).getChartPanel());
//        verify(chartFrame, times(1)).getChartPanel();
//    }

    @Test
    public void test2() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
        when(chartFrame.getChartPanel()).thenReturn(new ChartPanel(pieChart));
        boolean correctDataset = ((PiePlot)(chartFrame.getChartPanel().getChart().getPlot())).getDataset().equals(data);
        //chartFrame.getChartPanel().getChart().setTitle("New Title");
        verify(chartFrame, times(1)).getChartPanel();
        verify(chartFrame, times(1)).getChartPanel();
    }

    @Test
    public void testJFreeChartPlotInteraction(){
        DefaultPieDataset<String> mockDataSet = mock(DefaultPieDataset.class);
        String [] keys = {"first", "second", "third"};
        int [] values = {10, 20, 30};
        when(mockDataSet.getKeys()).thenReturn(Arrays.asList(keys));
        when(mockDataSet.getValue(0)).thenReturn(values[0]);

        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", mockDataSet);
        ((PiePlot)(pieChart.getPlot())).getDataset().getKey(0);
// verify data set was changed once
    }
}
