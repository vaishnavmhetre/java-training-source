/**
 * AnimalTypeServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.categories.service;

public class AnimalTypeServiceServiceLocator extends org.apache.axis.client.Service implements com.categories.service.AnimalTypeServiceService {

    public AnimalTypeServiceServiceLocator() {
    }


    public AnimalTypeServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AnimalTypeServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AnimalTypeService
    private java.lang.String AnimalTypeService_address = "http://localhost:7070/FindCategory/services/AnimalTypeService";

    public java.lang.String getAnimalTypeServiceAddress() {
        return AnimalTypeService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AnimalTypeServiceWSDDServiceName = "AnimalTypeService";

    public java.lang.String getAnimalTypeServiceWSDDServiceName() {
        return AnimalTypeServiceWSDDServiceName;
    }

    public void setAnimalTypeServiceWSDDServiceName(java.lang.String name) {
        AnimalTypeServiceWSDDServiceName = name;
    }

    public com.categories.service.AnimalTypeService getAnimalTypeService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AnimalTypeService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAnimalTypeService(endpoint);
    }

    public com.categories.service.AnimalTypeService getAnimalTypeService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.categories.service.AnimalTypeServiceSoapBindingStub _stub = new com.categories.service.AnimalTypeServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAnimalTypeServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAnimalTypeServiceEndpointAddress(java.lang.String address) {
        AnimalTypeService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.categories.service.AnimalTypeService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.categories.service.AnimalTypeServiceSoapBindingStub _stub = new com.categories.service.AnimalTypeServiceSoapBindingStub(new java.net.URL(AnimalTypeService_address), this);
                _stub.setPortName(getAnimalTypeServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("AnimalTypeService".equals(inputPortName)) {
            return getAnimalTypeService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.categories.com", "AnimalTypeServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.categories.com", "AnimalTypeService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AnimalTypeService".equals(portName)) {
            setAnimalTypeServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
