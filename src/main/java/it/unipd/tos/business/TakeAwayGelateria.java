////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////
    
package it.unipd.tos.business;

import java.util.List;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.User;
import it.unipd.tos.business.exception.TakeAwayBillException;

public class TakeAwayGelateria implements TakeAwayBill{
    public double getOrderPrice(List<MenuItem> itemsOrdered, User user)
     throws TakeAwayBillException{
        Double totalPrice = 0.0;

        if(itemsOrdered == null) {
            throw new TakeAwayBillException("La lista non esiste"); 
        }

        if(itemsOrdered.contains(null)) {
            throw new TakeAwayBillException
                ("La lista contiene un elemento nullo"); 
        }
        
        int numGelati=0;
        double gelatoMenoCaro=0.00;
        
        for(MenuItem item : itemsOrdered) {
        	if (item.getItemType() == MenuItem.item.Gelati) {
        		if (numGelati>0 && item.getPrice() < gelatoMenoCaro )
        			gelatoMenoCaro=item.getPrice();
        		else
        			gelatoMenoCaro=item.getPrice();
        		numGelati++;
        	}
            totalPrice += item.getPrice();
            if (numGelati > 5)
            	totalPrice -= gelatoMenoCaro*0.5;
        }

        return totalPrice;
    }
}