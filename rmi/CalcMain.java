package rmi;

public class CalcMain extends java.rmi.server.UnicastRemoteObject implements ICalculadora { 
    public CalcMain() 
        throws java.rmi.RemoteException { 
        super(); 
    } 
 
    public int add(int a, int b) 
        throws java.rmi.RemoteException { 
        return a + b; 
    } 
 
    public int sub(int a, int b) 
        throws java.rmi.RemoteException { 
        return a - b; 
    } 
 
    public int mul(int a, int b) 
        throws java.rmi.RemoteException { 
        return a * b; 
    } 
 
    public int div(int a, int b) 
        throws java.rmi.RemoteException { 
        return a / b; 
    } 
} 

