package ru.molokoin.j210_rest_client;

import java.util.Collection;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;

public class RestClient {
    private final Client client = ClientBuilder.newClient();
    //private Client client;
    private String URL = "http://molokoin.ru:8080/j210_rest_service/api";

    public RestClient(){
        //client = ClientBuilder.newBuilder().build();
        // WebTarget target = client.target("http://foo.com/resource");
        // Response response = target.request().get();
        // String value = response.readEntity(String.class);
        // response.close();  // You should close connections!

    }

    public Collection<ModelClient> getAllClients(){
        WebTarget target = client.target(URL + "/clients");
        Response response = target.request().get();
        //Request request = target.request();
        String value = response.readEntity(String.class);
        // Collection<ModelClient> value = response.readEntity(new GenericType<Collection<ModelClient>>(){});

        //System.out.println("value: " + value);
        //response.close();  // You should close connections!


        String msg = client.target(URL + "/clients").request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("---------- MSG ----------");
        System.out.println(msg);
        System.out.println("---------- MSG ----------");

        Collection<ModelClient> cmc = client.target(URL + "/clients").request(MediaType.APPLICATION_XML).get(new GenericType<Collection<ModelClient>>(){});
        return cmc;
    }

    public ModelClient getClientById(Integer id) {
        String msg = client.target(URL + "/clients" + "/" + id).request().get(String.class);
        System.out.println("---------- MSG ----------");
        System.out.println(msg);
        System.out.println("---------- MSG ----------");


        ModelClient mc = client.target(URL + "/clients" + "/" + id).request(MediaType.APPLICATION_XML).get(ModelClient.class);

        return mc;
    }
    
}
