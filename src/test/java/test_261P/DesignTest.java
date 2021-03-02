package test_261P;

import org.jfree.chart.text.TextBlock;
import org.jfree.chart.text.TextBlockAnchor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DesignTest {

@Test
   public void testTextBlockcalculateOffsets(){
     TextBlock textBlock = new TextBlock();

     float[] resultTC = textBlock.calculateOffsetsModified(TextBlockAnchor.TOP_CENTER,5.0f,5.0f);
     assertNotNull(resultTC);
     Assertions.assertEquals(
             Arrays.toString(new float[] {-2.5f, 0.0f}),
             Arrays.toString(resultTC));

    float[] resultC = textBlock.calculateOffsetsModified(TextBlockAnchor.CENTER, 5.0, 5.0);
    assertNotNull(resultC);
    Assertions.assertEquals(
            Arrays.toString(new float[] {-2.5f, -2.5f}),
            Arrays.toString(resultC));

    float[] resultBC = textBlock.calculateOffsetsModified(TextBlockAnchor.BOTTOM_CENTER,5.0f,5.0f);
    assertNotNull(resultBC);
    Assertions.assertEquals(
            Arrays.toString(new float[] {-2.5f, -5.0f}),
            Arrays.toString(resultBC));

    float[] resultTR = textBlock.calculateOffsetsModified(TextBlockAnchor.TOP_RIGHT,5.0f,5.0f);
    assertNotNull(resultTR);
    Assertions.assertEquals(
            Arrays.toString(new float[] {-5.0f, 0.0f}),
            Arrays.toString(resultTR));

    float[] resultCR = textBlock.calculateOffsetsModified(TextBlockAnchor.CENTER_RIGHT,5.0f,5.0f);
    assertNotNull(resultCR);
    Assertions.assertEquals(
            Arrays.toString(new float[] {-5.0f, -2.5f}),
            Arrays.toString(resultCR));

    float[] resultBR = textBlock.calculateOffsetsModified(TextBlockAnchor.BOTTOM_RIGHT,5.0f,5.0f);
    assertNotNull(resultBR);
    Assertions.assertEquals(
            Arrays.toString(new float[] {-5.0f, -5.0f}),
            Arrays.toString(resultBR));

    float[] resultTL = textBlock.calculateOffsetsModified(TextBlockAnchor.TOP_LEFT,5.0f,5.0f);
    assertNotNull(resultTL);
    Assertions.assertEquals(
            Arrays.toString(new float[] {0.0f, 0.0f}),
            Arrays.toString(resultTL));

    float[] resultCL= textBlock.calculateOffsetsModified(TextBlockAnchor.CENTER_LEFT, 5.0, 5.0);
    assertNotNull(resultCL);
    Assertions.assertEquals(
            Arrays.toString(new float[] {0.0f, -2.5f}),
            Arrays.toString(resultCL));

    float[] resultBL= textBlock.calculateOffsetsModified(TextBlockAnchor.BOTTOM_LEFT, 5.0, 5.0);
    assertNotNull(resultBL);
    Assertions.assertEquals(
            Arrays.toString(new float[] {0.0f, -5.0f}),
            Arrays.toString(resultBL));

    float[] resultNull= textBlock.calculateOffsetsModified(null, 5.0, 5.0);
    assertNotNull(resultNull);
    Assertions.assertEquals(
            Arrays.toString(new float[] {0.0f, 0.0f}),
            Arrays.toString(resultNull));

    float[] resultMaxTL = textBlock.calculateOffsetsModified(TextBlockAnchor.TOP_LEFT, Float.MAX_VALUE,Float.MAX_VALUE);
    assertNotNull(resultMaxTL);
    Assertions.assertEquals(
            Arrays.toString(new float[] {0.0f, 0.0f}),
            Arrays.toString(resultMaxTL));

    float[] resultMinTL = textBlock.calculateOffsetsModified(TextBlockAnchor.TOP_LEFT, Float.MIN_VALUE,Float.MIN_VALUE);
    assertNotNull(resultMinTL);
    Assertions.assertEquals(
            Arrays.toString(new float[] {0.0f, 0.0f}),
            Arrays.toString(resultMinTL));
   }
}
