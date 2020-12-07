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
    public void sommaPrezzoTotaleTest() throws TakeAwayBillException{
        List<MenuItem> lista = new ArrayList<MenuItem>();

        lista.add(new MenuItem(MenuItem.item.Bevande, "Aranciata", 3.00));
        lista.add(new MenuItem(MenuItem.item.Budini, "Cioccolato", 3.50));
        lista.add(new MenuItem(MenuItem.item.Gelati, "Stracciatella", 2.00));

        totalPrice = gelateria.getOrderPrice(lista,user);

        assertEquals(8.50,totalPrice,0.01);
    }
     
    @Test
     public void scontoPiuDi5Gelati() throws TakeAwayBillException{
    	 List<MenuItem> lista = new ArrayList<MenuItem>();
         
    	 lista.add(new MenuItem(MenuItem.item.Gelati, "Stracciatella", 2.00));
    	 lista.add(new MenuItem(MenuItem.item.Gelati, "Amarena", 2.00));
    	 lista.add(new MenuItem(MenuItem.item.Gelati, "Crema veneziana", 2.00));
    	 lista.add(new MenuItem(MenuItem.item.Gelati, "Fior di latte", 2.00));
    	 lista.add(new MenuItem(MenuItem.item.Gelati, "Fragola", 1.00));
    	 lista.add(new MenuItem(MenuItem.item.Gelati, "Limone", 1.00));

         totalPrice = gelateria.getOrderPrice(lista,user);

         assertEquals(9.50,totalPrice,0.01);
     }
    
     @Test
     public void scontoGelatiPiuBudiniPiuDi50Euro() throws TakeAwayBillException{
   	 List<MenuItem> lista = new ArrayList<MenuItem>();
        
   	 lista.add(new MenuItem(MenuItem.item.Gelati, "Coppa deluxe", 33.00));
   	 lista.add(new MenuItem(MenuItem.item.Budini, "Budino deluxe", 33.00));
   	 
   	 totalPrice = gelateria.getOrderPrice(lista,user);

        assertEquals(59.4,totalPrice,0.01);
    }
     
     @Test
     public void erroreOrdinazionePiu30ElementiTest() throws TakeAwayBillException{
         List<MenuItem> lista = new ArrayList<MenuItem>();

         for (int i = 0; i < 31; i++) {
             lista.add(new MenuItem(MenuItem.item.Bevande, "Coca-cola", 1.50));
         }
         try{
             totalPrice = gelateria.getOrderPrice(lista,user);
         }catch(TakeAwayBillException e){
             assertEquals("Errore! La lista non può contenere più di 30 elementi", e.getMessage());
         }

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
