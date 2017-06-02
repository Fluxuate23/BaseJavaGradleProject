package constants;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoinConstantsTest {

    @Test
    public void coinConstantsHasCorrectDollarValueForNickleDimeAndQuarter() {
        assertThat(CoinConstants.DOLLAR_VALUE_OF_NICKLE, is(0.05));
        assertThat(CoinConstants.DOLLAR_VALUE_OF_DIME, is(0.1));
        assertThat(CoinConstants.DOLLAR_VALUE_OF_QUARTER, is(0.25));
    }

}