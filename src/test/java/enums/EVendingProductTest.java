package enums;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EVendingProductTest {

    @Test
    public void vendingProductColaChipsAndCandyEachWithMatchingName() {
        assertThat(EVendingProduct.COLA.getName(), is("Cola"));
        assertThat(EVendingProduct.CHIPS.getName(), is("Chips"));
        assertThat(EVendingProduct.CANDY.getName(), is("Candy"));
    }

}