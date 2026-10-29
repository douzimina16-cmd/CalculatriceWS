package serveur;


import service.Calculatrice;

import javax.xml.ws.Endpoint;

import static com.sun.xml.ws.assembler.MetroTubelineAssembler.Side.Endpoint;

public class ServeurJWS {
    public static void main(String[] args) {
        String url = "http://localhost:8080/calculatrice";
        Endpoint.publish(url, new Calculatrice());
        System.out.println("Service publié sur : " + url);
        System.out.println("WSDL : " + url + "?wsdl");
    }
}