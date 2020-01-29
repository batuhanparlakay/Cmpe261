
import java.util.Random;
import java.io.*;
import java.net.*;



// my Client class
public class MyClient
{
    public static void main(String[] args) {
        int x = 5;
        Random y = new Random();//Random object and lines
        String[] dialog = {"I want potion.","I want dragon eggs.","I want daggers","I want forks.","Ops.","Thanks."};
        try
        {

            // starting localhost and I have a Java server that opens up a socket using ServerSocket 
            InetAddress localhost = InetAddress.getByName("localhost");

            //  port 5000
            Socket socket2 = new Socket(localhost, 5000);

            // running client data output and input if socket1 
            DataInputStream ýnput1 = new DataInputStream(socket2.getInputStream());
            DataOutputStream output1 = new DataOutputStream(socket2.getOutputStream());

          
            // The client handler sits on server side and handles the communication between server and clients
            while (x > 0)
            {   Thread.sleep(200);
                System.out.println(ýnput1.readUTF());
                String submit = dialog[y.nextInt(5)];
                System.out.println(submit);
                output1.writeUTF(submit);
                String b1 = ýnput1.readUTF();
                System.out.println(b1);
                x--;
            }

            // ending resources
            ýnput1.close();
            output1.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


