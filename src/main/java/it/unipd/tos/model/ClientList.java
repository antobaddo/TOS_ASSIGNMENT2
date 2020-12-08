////////////////////////////////////////////////////////////////////
// [ANTONIO] [BADAN] [1201209]
////////////////////////////////////////////////////////////////////


package it.unipd.tos.model;

import java.util.List;

import it.unipd.tos.model.User;
import java.time.LocalDate;

public class ClientList {
	private int limite;
    private LocalDate data;
    private List<User> clients;
    
    public ClientList(int limite, LocalDate data, List<User> clients) {
        this.limite=limite;
    	this.data = data;
        this.clients = clients;
    }    
}
