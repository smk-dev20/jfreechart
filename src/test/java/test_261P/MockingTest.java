package test_261P;

import org.jfree.chart.*;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class MockingTest {
    private ChartFactory chartFactory;
    private ChartFrame chartFrame;

    @Before
    public void setup() {
        //  Mocks are being created.
        chartFactory = mock(ChartFactory.class);
        chartFrame = mock(ChartFrame.class);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() {
        DefaultPieDataset<String> data = new DefaultPieDataset<>();
        data.setValue("Java", 43);
        data.setValue("Visual Basic", 12);
        data.setValue("C/C++", 17);
        JFreeChart pieChart = ChartFactory.createPieChart("Pie Chart", data);
        when(chartFrame.getChartPanel()).thenReturn(new ChartFrame("Pie Chart",pieChart).getChartPanel());
        verify(chartFrame, times(1)).getChartPanel();
    }
}
