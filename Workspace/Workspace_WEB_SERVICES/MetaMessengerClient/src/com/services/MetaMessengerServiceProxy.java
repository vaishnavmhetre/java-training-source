package com.services;

public class MetaMessengerServiceProxy implements com.services.MetaMessengerService {
  private String _endpoint = null;
  private com.services.MetaMessengerService metaMessengerService = null;
  
  public MetaMessengerServiceProxy() {
    _initMetaMessengerServiceProxy();
  }
  
  public MetaMessengerServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initMetaMessengerServiceProxy();
  }
  
  private void _initMetaMessengerServiceProxy() {
    try {
      metaMessengerService = (new com.services.MetaMessengerServiceServiceLocator()).getMetaMessengerService();
      if (metaMessengerService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)metaMessengerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)metaMessengerService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (metaMessengerService != null)
      ((javax.xml.rpc.Stub)metaMessengerService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.services.MetaMessengerService getMetaMessengerService() {
    if (metaMessengerService == null)
      _initMetaMessengerServiceProxy();
    return metaMessengerService;
  }
  
  public boolean register(java.lang.String name, java.lang.String username, java.lang.String password) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter{
    if (metaMessengerService == null)
      _initMetaMessengerServiceProxy();
    return metaMessengerService.register(name, username, password);
  }
  
  public java.lang.String login(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter{
    if (metaMessengerService == null)
      _initMetaMessengerServiceProxy();
    return metaMessengerService.login(username, password);
  }
  
  public java.lang.String[] getUnreadMessages(java.lang.String token) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter{
    if (metaMessengerService == null)
      _initMetaMessengerServiceProxy();
    return metaMessengerService.getUnreadMessages(token);
  }
  
  public java.lang.String[] getAllMessages(java.lang.String token) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter{
    if (metaMessengerService == null)
      _initMetaMessengerServiceProxy();
    return metaMessengerService.getAllMessages(token);
  }
  
  public java.lang.String getRandomUser() throws java.rmi.RemoteException{
    if (metaMessengerService == null)
      _initMetaMessengerServiceProxy();
    return metaMessengerService.getRandomUser();
  }
  
  public boolean sendMessage(java.lang.String token, int userId, java.lang.String content) throws java.rmi.RemoteException, com.support.database.querybuilder.exceptions.InvalidQueryBuilderParameter{
    if (metaMessengerService == null)
      _initMetaMessengerServiceProxy();
    return metaMessengerService.sendMessage(token, userId, content);
  }
  
  
}