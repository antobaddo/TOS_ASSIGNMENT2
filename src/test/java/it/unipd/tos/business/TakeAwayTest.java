////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TakeAwayTest {

    TakeAwayGelateria gelateria;
    double totalPrice;
    List<MenuItem> lista;
    User user;

    @Before
    public void setup() {
        gelateria = new TakeAwayGelateria();
        totalPrice = 0.0;
        lista = new ArrayList<MenuItem>();
        user = new User("Mario", "Rossi", 42);
    }


     @Test
    public void simpleSumTest() throws TakeAwayBillException{
        List<MenuItem> lista = new ArrayList<MenuItem>();

        lista.add(new MenuItem(MenuItem.item.Bevande, "Aranciata", 3.00));
        lista.add(new MenuItem(MenuItem.item.Budini, "Cioccolato", 3.50));
        lista.add(new MenuItem(MenuItem.item.Gelati, "Stracciatella", 2.00));

        totalPrice = gelateria.getOrderPrice(lista,user);

        assertEquals(8.50,totalPrice,0.01);
    }

    @Test(expected = TakeAwayBillException.class) 
    public void nullListTest() throws TakeAwayBillException{
        List<MenuItem> lista = null;

        totalPrice = gelateria.getOrderPrice(lista,user);
    }

    @Test(expected = TakeAwayBillException.class) 
    public void nullItemInListTest() throws TakeAwayBillException{
        List<MenuItem> lista = new ArrayList<MenuItem>();

        lista.add(null);
        lista.add(new MenuItem(MenuItem.item.Gelati, "Stracciatella", 2.00));

        totalPrice = gelateria.getOrderPrice(lista,user);
    }

}
