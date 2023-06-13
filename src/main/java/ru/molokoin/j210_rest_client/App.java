package ru.molokoin.j210_rest_client;

import java.util.Collection;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("... Clients ...");
        RestClient rc = new RestClient();
        Collection<ModelClient> clients = rc.getAllClients();
        for (ModelClient client : clients) {
            System.out.println(client.toString());
        }
        // ModelClient c = rest.getClientById(3);
        // System.out.println(c.toString());

        System.out.println("... Addresses ...");
        RestAddress ra = new RestAddress();
        Collection<ModelAddress> addresses = ra.getAllAddresses();
        for (ModelAddress address : addresses) {
            System.out.println(address.toString());
        }

    }
}
