////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import java.util.List;

public class Scontrino {
    private List<MenuItem> lista;
    private User user;
    private int secMezzanotte;
    private double price;

    public Scontrino(List<MenuItem> lista, User user, int secMezzanotte, double price) {
        this.lista = lista;
        this.user = user;
        this.secMezzanotte = secMezzanotte;
        this.price = price;
    }

    public List<MenuItem> getLista() {
        return lista;
    }

    public User getUser() {
        return user;
    }

    public int getSecMezzanotte() {
        return secMezzanotte;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p){
        price = p;
    }

}
