package junit;

/* doležité je importovat použitie junit a aj knkrétný assert, ktorým používame (u viac typov použiť *) */
import static org.junit.Assert.assertEquals;
import org.junit.*;

/**
 * JUnit test pre triedu Accountant,
 * test kontroluje všetky metódy implementované triedov.
 *
 * @author  Michal Gabonay
 * @version 1.0
 * @since   2018-12-20
 */
public class AccountantTest {

    /* Testy fungujú tak, že sa vytvorí objekt,
       zavolá sa funkciu na výpočet
       porovná sa vrátený výsledok s očakávaným výsledkom */


    /* test funkcie getTaxFromIncome */
    @Test
    public void testGetTaxFromIncome () throws Throwable {

        Accountant underTest = new Accountant(1000);

        double result = underTest.getTaxFromIncome();

        assertEquals(210.0d, result, 0.0);
    }

    /* test funkcie countNewIncome */
    @Test
    public void testCountNewIncome () throws Throwable {

        Accountant underTest = new Accountant(1000);

        double rise_ratio = 1.1;
        int rating = 3;
        int worked_years = 11;

        double result = underTest.countNewIncome(rise_ratio, rating, worked_years);

        assertEquals(1580.0d, result, 0.0);
    }

    /* test funkcie getBonus */
    @Test
    public void testGetBonus () throws Throwable {

        Accountant underTest = new Accountant(1000);

        double result = underTest.getBonus(1.1);

        assertEquals(1100.0d, result, 0.0);
    }
}
