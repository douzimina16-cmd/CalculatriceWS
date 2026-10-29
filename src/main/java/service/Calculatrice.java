package service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "CalculatriceService",
        portName = "CalculatricePort",
        endpointInterface = "service.ICalculatrice",
        targetNamespace = "http://service/")
public class Calculatrice implements ICalculatrice {

    @Override
    @WebMethod
    public double somme(@WebParam(name = "a") double a,
                        @WebParam(name = "b") double b) {
        return a + b;
    }

    @Override
    @WebMethod
    public double soustraction(@WebParam(name = "a") double a,
                               @WebParam(name = "b") double b) {
        return a - b;
    }

    @Override
    @WebMethod
    public double multiplication(@WebParam(name = "a") double a,
                                 @WebParam(name = "b") double b) {
        return a * b;
    }

    @Override
    @WebMethod
    public double division(@WebParam(name = "a") double a,
                           @WebParam(name = "b") double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division par zéro impossible");
        }
        return a / b;
    }
}