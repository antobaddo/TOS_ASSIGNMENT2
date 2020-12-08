////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ScontrinoTest {

    private User user;
    private List<MenuItem> lista;
    private Scontrino scontrino;

    @Before
    public void setup(){
    	user = new User("MR1","Mario", "Rossi", 42);
        lista = new ArrayList<MenuItem>();
        scontrino = new Scontrino(lista, user, 1234, 3.00);
        lista.add(new MenuItem(MenuItem.item.Gelati, "Stracciatella", 3.00));
    }

    @Test
    public void getListaTest() {
        assertEquals(lista, scontrino.getLista());
    }

    @Test
    public void getUserTest() {
        assertEquals(user, scontrino.getUser());
    }

    @Test
    public void getTimeTest() {
        assertEquals(1234,scontrino.getSecMezzanotte());
    }

    @Test
    public void getPriceTest() {
        assertEquals(3.00,scontrino.getPrice(),0.01);
    }

}

