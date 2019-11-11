/**
 * MetaMessengerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public interface MetaMessengerService extends java.rmi.Remote {
    public boolean register(java.lang.String name, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
    public com.data.model.Message[] getAllMessages(java.lang.String token) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
    public java.lang.String login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
    public java.lang.String getRandomUser() throws java.rmi.RemoteException;
    public com.data.model.Message[] getUnreadMessages(java.lang.String token) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
    public boolean sendMessage(java.lang.String token, int userId, java.lang.String content) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter;
}
