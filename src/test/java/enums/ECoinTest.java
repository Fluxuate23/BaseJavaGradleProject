package enums;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ECoinTest {

    @Test
    public void pennyHasWeightInGramsOfTwoPointFiveAndDiameterInMillimetersOfNineteenPointZeroFiveAndThicknessInMillimetersOfOnePointFiveTwo() {
        assertThat(ECoin.PENNY.getWeightInGrams(), is(2.5));
        assertThat(ECoin.PENNY.getDiameterInMillimeters(), is(19.05));
        assertThat(ECoin.PENNY.getThicknessInMillimeters(), is(1.52));
    }

    @Test
    public void nickleHasWeightInGramsOfFiveAndDiameterInMillimetersOfTwentyOnePointTwoOneAndThicknessInMillimetersOfOnePointNineFive() {
        assertThat(ECoin.NICKLE.getWeightInGrams(), is(5.0));
        assertThat(ECoin.NICKLE.getDiameterInMillimeters(), is(21.21));
        assertThat(ECoin.NICKLE.getThicknessInMillimeters(), is(1.95));
    }
}