package com.company;

// ketabkhane ha
import javax.naming.directory.SearchControls;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

/**
 * @author MMNazari1380
 * @version 1.0
 */
public class Handler implements Runnable
{
    // field
    private final Socket socket;
    private int doctorSahr ;
    private int ravanshenas;
    private int zarfiatMafia = 3;
    private int zarfiatShahrvand= 7 ;
    // shab = 0
    // rooz = 1
    // raygiri = 2
    private int vaziat = 0;

    // costructor
    public Handler(Socket socket)
    {

        this.socket=socket;

    }


    /**
     * baraye ejraye har client
     */
    @Override
    public void run()
    {

        try {

            // baraye dadane naghshha be afrad ba code
            HashMap<Integer, String> users1 = new HashMap<>();
            // baraye neveshtane list afrade bazi
            HashMap<Integer, String> users2 = new HashMap<>();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

           // sharte payane bazi
            while (zarfiatMafia<zarfiatShahrvand)
            {

                String str = dataInputStream.readUTF();

                // check kardane username tekrari
                for (Map.Entry<Integer, String> entry : users1.entrySet())
                {

                    if (entry.getValue().equals(str))
                    {

                        dataOutputStream.writeUTF(" username tekrari ast yek username digar vared konid");
                         str = dataInputStream.readUTF();

                    }

                }

                Random random = new Random();
                int code = random.nextInt(10);
                users1.put(code,str);
                int code1 = random.nextInt(10);
                users2.put(code1,str);
                System.out.println(" kole bazikonane vared shode");

                // chape hame bazikona
                for (Map.Entry<Integer, String> entry : users2.entrySet())
                {

                        System.out.println(entry.getKey() + ":" + entry.getValue());

                }

                if(code == 0)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi pedarkhande ast");
                    dataOutputStream.writeUTF(" hamtimi haye shoma be sharhe zir ast");

                    // moarefi kardane naghsh haye digaree mafia
                    for (Map.Entry<Integer, String> entry : users1.entrySet())
                    {

                        if(entry.getKey()==1 || entry.getKey()==2)
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                    }

                    if ( vaziat == 0)
                    {

                        // gozashtane time limit
                        SearchControls ctls = new SearchControls();
                        // chat
                        while (true)
                        {

                            ctls.setTimeLimit(5*60*1000);
                            dataOutputStream.writeUTF(" payame khod ra vared konid");
                            String voroody = dataInputStream.readUTF();
                            System.out.println(str + " : " + voroody);
                            break;

                        }

                        // ray giri
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" raye khod ra benevisid");
                        String voroody2 = dataInputStream.readUTF();
                        System.out.println(str + " : " + voroody2);
                        // nazare nahaee godfather
                        dataOutputStream.writeUTF("  raye nahaee khod ra benevisid");
                        String voroody3 = dataInputStream.readUTF();
                        System.out.println(" ray nahaee gofather ");
                        System.out.println(str + " : " + voroody3);

                        // hazfe ray godfather az users2
                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(voroody3))
                            {

                                if(!users2.get(doctorSahr).equals(voroody3))
                                {

                                    System.out.println(" bazikone zir az bazi hazf shod");
                                    System.out.println(entry.getKey() + " : " + entry.getValue());
                                    users2.remove(entry.getKey(),entry.getValue());

                                }

                            }

                        }

                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;

                    }

                    if ( vaziat == 2)
                    {

                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                     int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;

                    }

                }

                if(code == 1)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi doctor lekter ast");
                    dataOutputStream.writeUTF(" hamtimi haye shoma be sharhe zir ast");
                    for (Map.Entry<Integer, String> entry : users1.entrySet()) {
                        if(entry.getKey()==0 || entry.getKey()==2)
                            System.out.println(entry.getKey() + ":" + entry.getValue());
                    }

                    if ( vaziat == 0)
                    {
                        // gozashtane time limit
                        SearchControls ctls = new SearchControls();
                        // chat
                        while (true)
                        {

                            ctls.setTimeLimit(5*60*1000);
                            dataOutputStream.writeUTF(" payame khod ra vared konid");
                            String voroody = dataInputStream.readUTF();
                            System.out.println(str + " : " + voroody);
                            break;

                        }

                        // ray giri
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" raye khod ra benevisid");
                        String voroody2 = dataInputStream.readUTF();
                        System.out.println(str + " : " + voroody2);
                        dataOutputStream.writeUTF(" che kasi rqa mikhahi nejat dahi ?");
                        String voroody3 = dataInputStream.readUTF();
                        System.out.println(str + " : " + voroody3);
                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;
                    }

                    if ( vaziat == 2)
                    {

                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        System.out.println(" bazikone zir az bazi hazf shod");
                        System.out.println(r + " : " + users2.get(r));
                        users2.remove(r);
                        vaziat =0 ;
                        break ;

                    }


                }

                if(code == 2)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi mafaia sade ast");
                    dataOutputStream.writeUTF(" hamtimi haye shoma be sharhe zir ast");

                    for (Map.Entry<Integer, String> entry : users1.entrySet()) {
                        if(entry.getKey()==1 || entry.getKey()==0)
                            System.out.println(entry.getKey() + ":" + entry.getValue());
                    }

                    if ( vaziat == 0)
                    {

                        // gozashtane time limit
                        SearchControls ctls = new SearchControls();
                        // chat
                        while (true)
                        {

                            ctls.setTimeLimit(5*60*1000);
                            dataOutputStream.writeUTF(" payame khod ra vared konid");
                            String voroody = dataInputStream.readUTF();
                            System.out.println(str + " : " + voroody);
                            break;

                        }

                        // ray giri
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" raye khod ra benevisid");
                        String voroody2 = dataInputStream.readUTF();
                        System.out.println(str + " : " + voroody2);
                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;

                    }

                    if ( vaziat == 2)
                    {

                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;
                    }

                }

                if(code == 3)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi doctor shahr ast");
                    dataOutputStream.writeUTF(" hamtimi haye shoma be sharhe zir ast");

                    for (Map.Entry<Integer, String> entry : users1.entrySet())
                    {

                        if(entry.getKey()==7 )
                            System.out.println(entry.getKey() + ":" + entry.getValue());

                    }

                    if ( vaziat == 0)
                    {

                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi nejat dahi ?");
                        String voroody = dataInputStream.readUTF();
                        System.out.println(str + " : " + voroody);
                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if( entry.getValue().equals(voroody))
                            doctorSahr = entry.getKey();

                        }


                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;


                    }

                    if ( vaziat == 2)
                    {

                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;

                    }

                }

                if(code == 4)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi karagah ast");

                    if ( vaziat == 0)
                    {

                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi estelam begiri ?");
                        String voroody = dataInputStream.readUTF();
                        System.out.println(str + " : " + voroody);

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if( entry.getValue().equals(voroody) && (entry.getKey()==1 || entry.getKey()==2))
                                dataOutputStream.writeUTF(" estelam mosbat");
                            else
                                dataOutputStream.writeUTF(" estelam manfi");

                        }


                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;


                    }

                    if ( vaziat == 2)
                    {

                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;
                    }

                }

                if(code == 5)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi herfe ey ast");

                    if ( vaziat == 0)
                    {

                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi bokoshi ?");
                        dataOutputStream.writeUTF(" agar mikhay rad koni benevis ' hichkas ' ");
                        String voroody = dataInputStream.readUTF();
                        System.out.println(str + " : " + voroody);

                        if(voroody.equals(" hichkas"))
                            break;

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if( entry.getValue().equals(voroody) && (entry.getKey()==1 || entry.getKey()==2 || entry.getKey()==0))
                                users2.remove(entry.getKey());
                            else
                                users2.remove(5);

                            break;

                        }

                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;

                    }

                    if ( vaziat == 2)
                    {
                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;
                    }

                }

                if(code == 6)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi shahrvande sade ast");

                    if ( vaziat == 0)
                    {

                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;

                    }

                    if ( vaziat == 2)
                    {
                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;

                    }

                }

                if(code == 7)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi shahrdar ast");
                    dataOutputStream.writeUTF(" hamtimi haye shoma be sharhe zir ast");
                    for (Map.Entry<Integer, String> entry : users1.entrySet()) {
                        if(entry.getKey()==3)
                            System.out.println(entry.getKey() + ":" + entry.getValue());
                    }

                    if ( vaziat == 0)
                    {

                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;

                    }

                    if ( vaziat == 2)
                    {

                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            SearchControls ctls = new SearchControls();
                            ctls.setTimeLimit(30*1000);
                            dataOutputStream.writeUTF(" aya mikhahi ray giri ra lahgv koni ?");
                            dataOutputStream.writeUTF("  ' yes ' or ' no ' ?");
                            String voroody = dataInputStream.readUTF();
                            System.out.println(str + " : " + voroody);
                            if(voroody.equals(" yes "))
                                break;
                            if(voroody.equals(" no "))
                                continue;
                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;

                    }

                }

                if(code == 8)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi ravanshenas ast");

                    if ( vaziat == 0)
                    {

                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi saket koni ?");
                        String voroody = dataInputStream.readUTF();
                        System.out.println(str + " : " + voroody);
                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(voroody))
                            {

                                ravanshenas = entry.getKey();

                            }

                        }


                    }
                    if ( vaziat == 1)
                    {
                        while (true)
                        {

                            SearchControls ctls = new SearchControls();
                            ctls.setTimeLimit(10*60*1000);
                            dataOutputStream.writeUTF(" payame khod ra vared konid");
                            String voroody = dataInputStream.readUTF();
                            System.out.println(str + " : " + voroody);
                            break;

                        }

                        vaziat =2;
                        break;
                    }
                    if ( vaziat == 2)
                    {
                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;
                    }

                }

                if(code == 9)
                {

                    dataOutputStream.writeUTF(" naghshe shoma dar bazi jan sakht ast");

                    if ( vaziat == 0)
                    {

                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi estelam begiri (afrade hazf shode) ?");
                        String voroody = dataInputStream.readUTF();
                        System.out.println(str + " : ");
                        System.out.println(voroody);

                    }
                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users2.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                System.out.println(str + " : " + voroody);

                            }

                            // baraye inke faghat yek rooz saket bashad
                            ravanshenas = 10;
                            break;

                        }

                        vaziat =2;
                        break ;

                    }
                    
                    if ( vaziat == 2)
                    {
                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users2.entrySet())
                        {

                            if(entry.getValue().equals(ray))
                            {

                                ara[entry.getKey()]++;

                            }

                        }

                        int max = ara[0];
                        int r = 0 ;

                        for(int i =0 ; i< 10 ; i++)
                        {

                            if(ara[i] >= max)
                            {

                                max = ara[i];
                                r = i ;

                            }

                        }

                        if(r != doctorSahr)
                        {

                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users2.get(r));
                            users2.remove(r);

                        }

                        vaziat =0 ;
                        break ;
                    }

                }





            }

        //dataOutputStream.writeUTF(sss);
            // bastan socket va stream ha
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

        }

        // residegi be estesna
        catch ( IOException e)
        {
            e.printStackTrace();
        }

    }

}
