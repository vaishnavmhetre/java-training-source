/**
 * MetaMessengerServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public class MetaMessengerServiceServiceLocator extends org.apache.axis.client.Service implements com.services.MetaMessengerServiceService {

    public MetaMessengerServiceServiceLocator() {
    }


    public MetaMessengerServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MetaMessengerServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MetaMessengerService
    private java.lang.String MetaMessengerService_address = "http://localhost:7070/MetaMessenger/services/MetaMessengerService";

    public java.lang.String getMetaMessengerServiceAddress() {
        return MetaMessengerService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MetaMessengerServiceWSDDServiceName = "MetaMessengerService";

    public java.lang.String getMetaMessengerServiceWSDDServiceName() {
        return MetaMessengerServiceWSDDServiceName;
    }

    public void setMetaMessengerServiceWSDDServiceName(java.lang.String name) {
        MetaMessengerServiceWSDDServiceName = name;
    }

    public com.services.MetaMessengerService getMetaMessengerService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MetaMessengerService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMetaMessengerService(endpoint);
    }

    public com.services.MetaMessengerService getMetaMessengerService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.services.MetaMessengerServiceSoapBindingStub _stub = new com.services.MetaMessengerServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getMetaMessengerServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMetaMessengerServiceEndpointAddress(java.lang.String address) {
        MetaMessengerService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.services.MetaMessengerService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.services.MetaMessengerServiceSoapBindingStub _stub = new com.services.MetaMessengerServiceSoapBindingStub(new java.net.URL(MetaMessengerService_address), this);
                _stub.setPortName(getMetaMessengerServiceWSDDServiceName());
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
        if ("MetaMessengerService".equals(inputPortName)) {
            return getMetaMessengerService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.com", "MetaMessengerServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.com", "MetaMessengerService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MetaMessengerService".equals(portName)) {
            setMetaMessengerServiceEndpointAddress(address);
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
