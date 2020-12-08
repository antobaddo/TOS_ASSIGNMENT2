////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////
    
package it.unipd.tos.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.Scontrino;
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
        
        if(itemsOrdered.size()>30){
            throw new TakeAwayBillException
                ("Errore! La lista non può contenere più di 30 elementi"); 
        }
        
        int numGelati=0;
        double gelatoMenoCaro=0.00;
        double gelatiBudini=0.00;
        
        
        for(MenuItem item : itemsOrdered) {
            if (item.getItemType() == MenuItem.item.Gelati) {
                
                // l'articolo è un gelato
                if (numGelati>0 && item.getPrice() < gelatoMenoCaro ) {
                    gelatoMenoCaro=item.getPrice();
                }
                else {
                    gelatoMenoCaro=item.getPrice();
                }
                numGelati++;
                gelatiBudini+=item.getPrice();
            }
            
            // l'articolo è un budino
            if (item.getItemType() == MenuItem.item.Budini) {
                gelatiBudini+=item.getPrice();
            }
            totalPrice += item.getPrice();
        }
        
        // commissione di 0.50 €
        if (totalPrice < 10.00) {
            totalPrice += 0.50;
        }
        
        // sconto più di 5 gelati
        if (numGelati > 5) {
            totalPrice -= gelatoMenoCaro*0.5;
        }
        
        // sconto spesa di budini+gelati > 50 €
        if (gelatiBudini > 50.00) {
            totalPrice *= 0.9;
        }
        
        return totalPrice;
    }
    
    public List<Scontrino> getScontriniGratis(List<Scontrino> scontrini){

        List<Scontrino> aux = new ArrayList<Scontrino>();

        for (int i = 0; i < scontrini.size(); i++) {
            if(scontrini.get(i).getUser().getAge()<18 &&
             !aux.contains(scontrini.get(i)) &&
             scontrini.get(i).getSecMezzanotte()> 64800 &&
             scontrini.get(i).getSecMezzanotte()< 68400)
            {
                aux.add(scontrini.get(i));
            }
        }
        List<Scontrino> scontriniGratis = new ArrayList<Scontrino>();
        
        if(aux.size()>10){
            Random rm = new Random();
            while (scontriniGratis.size()<10) {
                int index = rm.nextInt(aux.size());
                scontriniGratis.add(aux.get(index));
                aux.remove(index);
            }
            for (Scontrino i : scontriniGratis) {
                i.setPrice(0.0);
            }
        }
        return scontriniGratis;
    }
}