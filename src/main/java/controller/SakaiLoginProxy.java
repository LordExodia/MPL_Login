package controller;

// Código generado para manejo de servicios wdsl
public class SakaiLoginProxy implements SakaiLogin {
	  private String _endpoint = null;
	  private SakaiLogin sakaiLogin = null;
	  
	  public SakaiLoginProxy() {
	    _initSakaiLoginProxy();
	  }
	  
	  public SakaiLoginProxy(String endpoint) {
	    _endpoint = endpoint;
	    _initSakaiLoginProxy();
	  }
	  
	  private void _initSakaiLoginProxy() {
	    try {
	      sakaiLogin = (new SakaiLoginServiceLocator()).getSakaiLoginPort();
	      if (sakaiLogin != null) {
	        if (_endpoint != null)
	          ((javax.xml.rpc.Stub)sakaiLogin)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	        else
	          _endpoint = (String)((javax.xml.rpc.Stub)sakaiLogin)._getProperty("javax.xml.rpc.service.endpoint.address");
	      }
	      
	    }
	    catch (javax.xml.rpc.ServiceException serviceException) {}
	  }
	  
	  public String getEndpoint() {
	    return _endpoint;
	  }
	  
	  public void setEndpoint(String endpoint) {
	    _endpoint = endpoint;
	    if (sakaiLogin != null)
	      ((javax.xml.rpc.Stub)sakaiLogin)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
	    
	  }
	  
	  public SakaiLogin getSakaiLogin() {
	    if (sakaiLogin == null)
	      _initSakaiLoginProxy();
	    return sakaiLogin;
	  }
	  
	  public java.lang.String loginToServerGET(java.lang.String id, java.lang.String pw) throws java.rmi.RemoteException{
	    if (sakaiLogin == null)
	      _initSakaiLoginProxy();
	    return sakaiLogin.loginToServerGET(id, pw);
	  }
	  
	  public java.lang.String loginToServer(java.lang.String id, java.lang.String pw) throws java.rmi.RemoteException{
	    if (sakaiLogin == null)
	      _initSakaiLoginProxy();
	    return sakaiLogin.loginToServer(id, pw);
	  }
	  
	  public boolean logout(java.lang.String sessionid) throws java.rmi.RemoteException{
	    if (sakaiLogin == null)
	      _initSakaiLoginProxy();
	    return sakaiLogin.logout(sessionid);
	  }
	  
	  public java.lang.String login(java.lang.String id, java.lang.String pw) throws java.rmi.RemoteException{
	    if (sakaiLogin == null)
	      _initSakaiLoginProxy();
	    return sakaiLogin.login(id, pw);
	  }
	  
	  public java.lang.String loginGET(java.lang.String id, java.lang.String pw) throws java.rmi.RemoteException{
	    if (sakaiLogin == null)
	      _initSakaiLoginProxy();
	    return sakaiLogin.loginGET(id, pw);
	  }
	  
	  public boolean logoutGET(java.lang.String sessionid) throws java.rmi.RemoteException{
	    if (sakaiLogin == null)
	      _initSakaiLoginProxy();
	    return sakaiLogin.logoutGET(sessionid);
	  }
	  
	  
	}