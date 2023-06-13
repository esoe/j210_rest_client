package ru.molokoin.j210_rest_client;

import java.util.Collection;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class RestAddress {
    private final Client client = ClientBuilder.newClient();
    private String URL = "http://molokoin.ru:8080/j210_rest_service/api";

    public RestAddress(){
        //
    }
    public Collection<ModelAddress> getAllAddresses(){
        String msg = client.target(URL + "/addresses").request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("---------- MSG ----------");
        System.out.println(msg);
        System.out.println("---------- MSG ----------");

        Collection<ModelAddress> cmc = client.target(URL + "/addresses").request(MediaType.APPLICATION_XML).get(new GenericType<Collection<ModelAddress>>(){});
        return cmc;
    }

}
