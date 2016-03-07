package rmiserver;

import java.rmi.Naming;


public class RMIClient {

    /**
     * @param args the command line arguments
     */
    
    private RMIClient() {}
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        String host="localhost";
        //String host = (args.length < 1) ? null : args[0];
        
        //if(System.getSecurityManager()==null){
        //    System.setSecurityManager(new SecurityManager());
        //}
        
        try {
            Hello stub=(Hello) Naming.lookup("rmi://localhost/Hello");
            //Registry registry = LocateRegistry.getRegistry(host, 1099);
            //Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
        
        
    }
}