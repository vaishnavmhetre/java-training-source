/**
 * MetaMessengerServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public interface MetaMessengerServiceService extends javax.xml.rpc.Service {
    public java.lang.String getMetaMessengerServiceAddress();

    public com.services.MetaMessengerService getMetaMessengerService() throws javax.xml.rpc.ServiceException;

    public com.services.MetaMessengerService getMetaMessengerService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
