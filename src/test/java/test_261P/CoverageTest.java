package test_261P;

import org.jfree.chart.plot.CompassPlot;
import org.jfree.data.general.DefaultValueDataset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoverageTest {
    @Test
    public void testCoverageCompassPlotSetSeriesNeedle(){

        boolean pass = false;
        CompassPlot p1 = new CompassPlot(new DefaultValueDataset(15.0));
        CompassPlot p2 = new CompassPlot(new DefaultValueDataset(15.0));
        p1.setSeriesNeedle(0,0);
        p2.setSeriesNeedle(0,0);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,1);
        p2.setSeriesNeedle(0,1);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,2);
        p2.setSeriesNeedle(0,2);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,3);
        p2.setSeriesNeedle(0,3);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,4);
        p2.setSeriesNeedle(0,4);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,5);
        p2.setSeriesNeedle(0,5);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,6);
        p2.setSeriesNeedle(0,6);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,7);
        p2.setSeriesNeedle(0,7);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,8);
        p2.setSeriesNeedle(0,8);
        assertTrue(p1.equals(p2));

        p1.setSeriesNeedle(0,9);
        p2.setSeriesNeedle(0,9);
        assertTrue(p1.equals(p2));

        try{
            p1.setSeriesNeedle(0,100);
       }catch (IllegalArgumentException ex) {
        pass = true;
       }
        assertTrue(pass);
    }
}
