package test_261P;

import org.jfree.chart.text.TextBlock;
import org.jfree.chart.text.TextBlockAnchor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DesignTest {

@Test
   public void testTextBlockcalculateOffsets(){
    TextBlock textBlock = new TextBlock();

    float[] resultCR = textBlock.calculateOffsetsModified(TextBlockAnchor.CENTER_RIGHT,5.0f,5.0f);
    assertNotNull(resultCR);
    Assert.assertEquals(
            Arrays.toString(resultCR),
            Arrays.toString(new float[] {-5.0f, -2.5f}));

    float[] resultTL = textBlock.calculateOffsetsModified(TextBlockAnchor.TOP_LEFT,5.0f,5.0f);
    assertNotNull(resultTL);
    Assert.assertEquals(
            Arrays.toString(resultTL),
            Arrays.toString(new float[] {0.0f, 0.0f}));


}
}
