package test_261P;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.PublicCloneable;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartPanel;
import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FiniteStateTest {

    /**
     * Test PieDataSet state - obj needs to have set values
     */
    @Test
    public void testPieDataSetState() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);

        assertEquals(43.0, data.getValue(0));
        assertEquals(12.0, data.getValue(1));
        assertEquals(17.0, data.getValue(2));
        assertEquals("Java", data.getKey(0));
        assertEquals("Visual Basic", data.getKey(1));
        assertEquals("C/C++", data.getKey(2));
    }

    /**
     * Test PiePlot state - plot obj has to have set values
     */
    @Test
    public void testPiePlotState() {

        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);

        PiePlot p = new PiePlot();
        p.setDataset(data);

        p.setShadowXOffset(5.0);
        p.setShadowYOffset(6.0);

        assertEquals(data, p.getDataset());
        assertEquals(5.0, p.getShadowXOffset());
        assertEquals(6.0, p.getShadowYOffset());

    }

    /**
     * Test JFreechart state - obj has to have set values
     */
    @Test
    public void testJFreeChartState() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
        TextTitle title = new TextTitle("Chart test");
        pieChart.setTitle(title);
        assertEquals(data, ((PiePlot) pieChart.getPlot()).getDataset());
        assertEquals(title, pieChart.getTitle());
    }

    /**
     * Test State PieChart output,object has to have values set
     */
    @Test
    public void testPieChartOutputState() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
        ChartPanel panel = new ChartPanel(pieChart);
        panel.setMaximumDrawWidth(13);
        panel.setMaximumDrawHeight(15);
        assertEquals(pieChart, panel.getChart());
        assertEquals(13, panel.getMaximumDrawWidth());
        assertEquals(15, panel.getMaximumDrawHeight());

    }

    /**
     * Test Transition Data -> Plot
     */
    @Test
    public void testTransitionDataToPlot() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);

        assertNotNull(pieChart.getPlot());
        assertEquals(((PiePlot) pieChart.getPlot()).getDataset(), data);
    }

    /**
     * Test Transition Plot to Chart
     * check if the new chart has the same data as plot
     */
    @Test
    public void testTransitionPlotToChart() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);

        PiePlot plot = new PiePlot();
        plot.setDataset(data);
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);

        assertEquals(((PiePlot) pieChart.getPlot()).getDataset(), plot.getDataset());
    }

    /**
     * Test Transition Plot -> Data
     * modify plot data
     */
    @Test
    public void testTransitionPlotToData() {
        DefaultPieDataset<String> oldData = new DefaultPieDataset<>();
        oldData.setValue("Java", 43);
        oldData.setValue("Visual Basic", 12);
        oldData.setValue("C/C++", 17);

        PiePlot plot = new PiePlot(oldData);

        DefaultPieDataset<String> newData = new DefaultPieDataset<>();
        newData.setValue("Wealth", 80);
        newData.setValue("Health", 35);
        newData.setValue("Happiness", 1);
        plot.setDataset(newData);

        assertNotEquals(oldData, plot.getDataset());
        assertEquals(newData, plot.getDataset());
    }

    /**
     * Test Transition Chart <-> Plot
     * update chart data
     */
    @Test
    public void testTransitionChartToPlot() {
        DefaultPieDataset<String> oldData = new DefaultPieDataset<>();
        oldData.setValue("Java", 43);
        oldData.setValue("Visual Basic", 12);
        oldData.setValue("C/C++", 17);

        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", oldData);

        DefaultPieDataset<String> newData = new DefaultPieDataset<>();
        newData.setValue("Wealth", 80);
        newData.setValue("Health", 35);
        newData.setValue("Happiness", 1);

        ((PiePlot) pieChart.getPlot()).setDataset(newData);
        assertNotEquals(oldData, (((PiePlot) pieChart.getPlot()).getDataset()));
        assertEquals(newData, (((PiePlot) pieChart.getPlot()).getDataset()));
    }

    /**
     * Test Transition Data -> Plot -> Chart
     */
    @Test
    public void testTransitionDataToPlotToChart() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);

        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
        assertEquals(data, (((PiePlot) pieChart.getPlot()).getDataset()));
    }

    /**
     * Test Transition Chart -> Chart (updateChart)
     */
    @Test
    public void testTransitionUpdateJFreeChart() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        PiePlot plot = new PiePlot();
        plot.setDataset(data);
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
        pieChart.setTitle("updated pie chart");
        assertTrue(pieChart.getTitle().getText().equals("updated pie chart"));
    }
    /**
     * Test Transition  Chart -> Output
     */
    @Test
    public void testTransitionChartToOutput() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);

        JFreeChart pieChart = ChartFactory.createPieChart("pieChart", data);
        try {
            ChartUtils.saveChartAsPNG(new File("src/test/java/test_261P/test_chart_output.png"), pieChart,300, 200);
        }catch(IOException e) {
            fail("Saving chart as PNG should not throw an exception");
        }
    }
    /**
     * Test Transition  Chart -> Plot -> Data
     */
    @Test
    public void testTransitionToChartToPlotToData(){
        DefaultPieDataset<String> oldData = new DefaultPieDataset<>();
        oldData.setValue("Java", 43);
        oldData.setValue("Visual Basic", 12);
        oldData.setValue("C/C++", 17);

        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", oldData);

        DefaultPieDataset<String> newData = new DefaultPieDataset<>();
        newData.setValue("Apple", 80);
        newData.setValue("Google", 35);
        newData.setValue("Facebook", 1);

        PiePlot plot = (PiePlot)pieChart.getPlot();
        ((PiePlot) pieChart.getPlot()).setDataset(newData);
        assertNotEquals(oldData, (((PiePlot) pieChart.getPlot()).getDataset()));
        assertEquals(newData, (((PiePlot) pieChart.getPlot()).getDataset()));
        assertEquals(newData, plot.getDataset());

        newData.setValue("Apple", 40);
        newData.setValue("Google", 25);
        newData.setValue("Facebook", 10);
        plot.setDataset(newData);
        assertEquals(newData, plot.getDataset());
    }
    /**
     * Test Transition Data -> Plot -> Chart -> Output
     */
    @Test
    public void testTransitionDataToPlotToChartToOutput(){
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);

        JFreeChart pieChart = ChartFactory.createPieChart("pieChart", data);
        assertEquals(data, (((PiePlot) pieChart.getPlot()).getDataset()));
        try{
          ChartUtils.saveChartAsPNG(new File("src/test/java/test_261P/test_chart.png"), pieChart,300, 200);
        }catch(IOException ex){
            fail("Saving chart as PNG should not throw an exception");
        }
    }
}