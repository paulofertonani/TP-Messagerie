/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathancozzo
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*; // Hashtable

public class Messagerie extends UnicastRemoteObject implements Serveur {

    private ArrayList<String> listeUsers;
    private Map<Integer, String> tableauId;
    private Map<Integer, String> tableauMessages;

    // Implémentation du constructeur
    public Messagerie() throws java.rmi.RemoteException {
        this.listeUsers = new ArrayList<String>() ;
        this.tableauId = new HashMap<Integer, String>();
        this.tableauMessages =new HashMap<Integer, String>();
    }
    
    // Implémentation des méthodes distantes

    public void connect(String id) throws java.rmi.RemoteException {
        this.listeUsers.add(id);
    }
    
    public void send(String message, String id) throws java.rmi.RemoteException {
    	this.tableauId.put(this.tableauId.size(), id);
    	this.tableauMessages.put(this.tableauMessages.size(), message);
    }
    
    public void bye(String id) throws java.rmi.RemoteException {
    	this.listeUsers.remove(id);
    }
    
    public ArrayList<String> who() throws java.rmi.RemoteException {
    	return this.listeUsers;
    }
    
    public ArrayList<Map<Integer, String>> getMessages(int nbMessages)throws java.rmi.RemoteException  {
       	ArrayList<Map<Integer, String>> messages = new ArrayList<Map<Integer, String>>();
    	int i;
    	Map<Integer, String> tabId = this.tableauId;
    	Map<Integer, String> tabMessages = this.tableauMessages;
    	for(i=0; i<nbMessages;i++){
    		tabId.remove(i);
    		tabMessages.remove(i);
    	}
       	messages.add(0,tabId);
    	messages.add(1,tabMessages);
    	return messages;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
