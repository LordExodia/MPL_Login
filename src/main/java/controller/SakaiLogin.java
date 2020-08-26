package controller;

// Código generado para manejo de servicios wdsl
public interface SakaiLogin extends java.rmi.Remote {
    public java.lang.String loginToServerGET(java.lang.String id, java.lang.String pw) throws java.rmi.RemoteException;
    public java.lang.String loginToServer(java.lang.String id, java.lang.String pw) throws java.rmi.RemoteException;
    public boolean logout(java.lang.String sessionid) throws java.rmi.RemoteException;
    public java.lang.String login(java.lang.String id, java.lang.String pw) throws java.rmi.RemoteException;
    public java.lang.String loginGET(java.lang.String id, java.lang.String pw) throws java.rmi.RemoteException;
    public boolean logoutGET(java.lang.String sessionid) throws java.rmi.RemoteException;
}
