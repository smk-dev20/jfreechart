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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class MockingTest {
    private ChartFactory chartFactory;
    private ChartFrame chartFrame;
    private Plot plot;
    private ChartFrame frame;

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
    public void testSaveChartDataSetInteraction(){
        DefaultPieDataset<String> mockDataSet = mock(DefaultPieDataset.class);
        String [] keys = {"first", "second", "third"};
        int [] values = {10, 20, 30};
        when(mockDataSet.getKeys()).thenReturn(Arrays.asList(keys));
        for (int i=0; i<values.length; i++){
            when(mockDataSet.getValue(i)).thenReturn(values[i]);
        }
        for (int i=0; i<values.length; i++){
            when(mockDataSet.getKey(i)).thenReturn(keys[i]);
        }
        String str;
        when(mockDataSet.getItemCount()).thenReturn(keys.length);
        when(mockDataSet.getValue("first")).thenReturn(10);
        when(mockDataSet.getValue("second")).thenReturn(20);
        when(mockDataSet.getValue("third")).thenReturn(30);

        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", mockDataSet);
        ((PiePlot)(pieChart.getPlot())).getDataset().getKey(0);
        // safe here. we know how many times mockDataSet() methods are called
        verify(mockDataSet, times(1)).getKey(0);
        verify(mockDataSet, never()).getKey(1);
        verify(mockDataSet, never()).getKey(2);
        //frame = new ChartFrame("My Chart", pieChart);
        try {
            ChartUtils.saveChartAsPNG(new File("../test3.png"),pieChart, 900, 900);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
         //getValue gets called for an item index
        verify(mockDataSet, atMost(2)).getKey(0);
        verify(mockDataSet, atMost(1)).getKey(1);
        verify(mockDataSet, atMost(1)).getKey(1);

        //verify that mockDataSet calls getValue(key) at least 3times for 3keys.
        // Don't know how many times inner code is calling mockDataSet methods. Numbers are as high as12 to 36. So put atleast(1)
        verify(mockDataSet, atLeast(3)).getValue(anyString());
        verify(mockDataSet, atLeast(1)).getKeys();

// verify data set was changed once
    }

    public static void main(String[] args) {
        //example code to see a  chartFrame. Maybe can use in mocking in a test function.
        MockingTest M = new MockingTest();
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
        dataset.setValue("one", 1);
        dataset.setValue("two", 2);
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", dataset);

        M.frame = new ChartFrame("My Chart", pieChart);
        M.frame.pack();
        M.frame.setVisible(true);
    }
}
