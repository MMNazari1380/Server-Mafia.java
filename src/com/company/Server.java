package com.company;

// ketabkhane ha
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author MMNazari1380
 * @version 1.0
 */
public class Server
{



    /**
     * baraye ejraye barname
     */
    public void run()
    {

        try
        {

            ServerSocket server =new ServerSocket(8888);

            // baraye handle kardane darkhaste client haye mokhtalef
            while(true)
            {

                Socket socket = server.accept();
                Thread thread = new Thread(new Handler(socket), " my thread");
                thread.start();

            }

        }

        // residegi be exception
        catch ( IOException e)
        {

            e.printStackTrace();

        }

    }

}
