
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.io.DataOutputStream;
import java.io.DataInputStream;

//creating class Client extends thread
class ThreadClient extends Thread
{
// creating input output objects and socket to connect to server
   
	final Socket mysocket;
	final DataInputStream ýnput;
    final DataOutputStream output;
    
    // using an arraylist adding diagonal list
     ArrayList <String> dialoglist = new ArrayList<String>(){
         {
             add("I have products if you have fares.");
             add("You can have it.");
             add( "Potions are for losers.");
             add("Dragon eggs are for losers.");
             add("Have a nice day.");
         }
     };

    //  client handler provides socket, input and output
    public ThreadClient(Socket mysocket, DataInputStream ýnput, DataOutputStream output)
    {
        this.mysocket = mysocket;
        this.ýnput = ýnput;
        this.output = output;
    }

    @Override // thread run method
    public void run()
    {
        String E1; //String  input and output
        String E2;

        int starting = 5;
        while (starting>0)// run the loop five times and method writes a string to the underlying output stream using modified
        {
            try {
                if(starting == 5) {
                    output.writeUTF(dialoglist.get(0));// provides dialog
                    dialoglist.remove(0);
                    starting --;
                    sleep(200);

                }


                //  client asnwer for dialog method reads in a string that has been encoded using a modified
                E1 = ýnput.readUTF();  // provides message 

                    sleep(200);

                    switch (E1) {//and answer for client sleep is waiting respectively other thread and so other case provides consecutive

                            case "  I want potion  " :
                                E2 = dialoglist.get(1);
                                output.writeUTF(E2);
                                sleep(200);


                            case "  I want dragon eggs  " :
                                E2 = dialoglist.get(2);
                                output.writeUTF(E2);
                                sleep(200);


                            case "  I want forks  " :
                            case "  I want daggers  " :
                                E2 = dialoglist.get(0);
                                output.writeUTF(E2);
                                sleep(200);


                            case " Ops   " :
                            case "  Thanks  " :
                                E2 = dialoglist.get(3);
                                output.writeUTF(E2);
                                sleep(200);


                            default:
                        }


            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        try
        {
            // closing resources
            this.ýnput.close();
            this.output.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
