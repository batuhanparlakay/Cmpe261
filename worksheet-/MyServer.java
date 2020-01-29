import java.net.*;
import java.io.*;


// my Server class staring  and A server socket waits for requests to come in over the network. It performs some operation based on that request, and then possibly returns a result to the requester.
public class MyServer {
    public static void main(String[] args) throws IOException {
        // server is port 5000 
        ServerSocket serverSocket1 = new ServerSocket(5000);

        // running client data output and input if socket1 
      
        while (true) {
            Socket Socket1 = null;

            try {
               
                Socket1 = serverSocket1.accept();
//A data input stream lets an application read primitive Java data types from an underlying input stream in a machine-independent way.
                //A data output stream lets an application write primitive Java data types to an output stream in a portable way. An application can then use a data input stream to read the data back in.
                
                DataInputStream ýnput1 = new DataInputStream(Socket1.getInputStream());
                DataOutputStream output1 = new DataOutputStream(Socket1.getOutputStream());

                // create a thread 
                Thread t1 = new ThreadClient(Socket1, ýnput1, output1);

                // start thread () method
                t1.start();

            } catch (Exception e) {
                Socket1.close();
                e.printStackTrace();
            }
        }
    }
}


