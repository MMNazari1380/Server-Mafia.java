package com.company;
// ta code =2 time limit haro gozashti badan dorostesh kon
// baraye hame SHAB SOBH RAYGIRI nazashti
//  barname dorost run nemishe
// tooye emtizi ha is typing va zabane farsi hast

// ketabkhane ha
import javax.naming.directory.SearchControls;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
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
    private int estelamJanSakht =0 ;
    private int janeJanSakht =0 ;
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
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

           // sharte payane bazi
            while (zarfiatMafia<zarfiatShahrvand)
            {

                if( zarfiatMafia==0)
                {

                System.out.println("  shahrvandan barande shodand");
                    //dataOutputStream.writeUTF(sss);
                    // bastan socket va stream ha
                    dataInputStream.close();
                    dataOutputStream.close();
                    socket.close();

                }

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
                System.out.println(" kole bazikonane vared shode");

                // chape hame bazikona
                for (Map.Entry<Integer, String> entry : users1.entrySet())
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

                        System.out.println("        ***************       SHAB     ****************      " );
                        // gozashtane time limit
                        //SearchControls ctls = new SearchControls();
                        // chat
                        while (true)
                        {

                            //ctls.setTimeLimit(5*60*1000);
                            long startTime = System.currentTimeMillis();
                            long endTime = startTime+( 5* 60 * 1000);
                            while(System.currentTimeMillis()<endTime)
                            {

                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                System.out.println(str + " : " + voroody);

                            }

                            break;

                        }

                        // ray giri
                       // ctls.setTimeLimit(30*1000);
                        long startTime = System.currentTimeMillis();
                        long endTime = startTime+( 30 * 1000);

                        while(System.currentTimeMillis()<endTime)
                        {

                            dataOutputStream.writeUTF(" raye khod ra benevisid");
                            String voroody2 = dataInputStream.readUTF();
                            voroody2 = new String(voroody2.getBytes(StandardCharsets.UTF_8),"UTF-8");
                            System.out.println(str + " : " + voroody2);

                        }

                        // nazare nahaee godfather
                         startTime = System.currentTimeMillis();
                         endTime = startTime+( 30 * 1000);

                        while(System.currentTimeMillis()<endTime)
                        {

                            dataOutputStream.writeUTF("  raye nahaee khod ra benevisid");
                            String voroody3 = dataInputStream.readUTF();
                            voroody3 = new String(voroody3.getBytes(StandardCharsets.UTF_8),"UTF-8");
                            System.out.println(" ray nahaee gofather ");
                            System.out.println(str + " : " + voroody3);
                            // hazfe ray godfather az users2
                            for (Map.Entry<Integer, String> entry : users1.entrySet())
                            {

                                if(entry.getValue().equals(voroody3))
                                {

                                    if(!users1.get(doctorSahr).equals(voroody3))
                                    {

                                        if(users1.get(9).equals(voroody3))
                                        {

                                            if(janeJanSakht==0)
                                            {

                                                janeJanSakht++;
                                                break;

                                            }

                                        }

                                        else
                                        {

                                            System.out.println(" bazikone zir az bazi hazf shod");
                                            System.out.println(entry.getKey() + " : " + entry.getValue());
                                            users1.remove(entry.getKey(),entry.getValue());
                                            zarfiatShahrvand--;

                                        }

                                    }

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
                            if(!users1.get(ravanshenas).equals(str))
                            {

                              //  SearchControls ctls = new SearchControls();
                                //ctls.setTimeLimit(5*60*1000);
                                long startTime = System.currentTimeMillis();
                                long endTime = startTime+( 5 * 60 * 1000);

                                while(System.currentTimeMillis()<endTime)
                                {

                                    dataOutputStream.writeUTF(" payame khod ra vared konid");
                                    String voroody = dataInputStream.readUTF();
                                    voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                    String text = str +" is typing ...";
                                    for(char c : text.toCharArray()) {
                                        System.out.print(c);
                                        Thread.sleep(500);
                                    }
                                    System.out.println();
                                    System.out.println(str + " : " + voroody);

                                }

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

                        long startTime = System.currentTimeMillis();
                        long endTime = startTime+( 30 * 1000);

                        while(System.currentTimeMillis()<endTime)
                        {

                            dataOutputStream.writeUTF(" raye khod ra vared konid");
                            dataOutputStream.writeUTF(" kole bazikonane vared shode");

                            for (Map.Entry<Integer, String> entry : users1.entrySet())
                            {

                                System.out.println(entry.getKey() + ":" + entry.getValue());

                            }

                            String ray = dataInputStream.readUTF();
                            int ara[] = {0,0,0,0,0,0,0,0,0,0};

                            for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                                System.out.println(r + " : " + users1.get(r));
                                users1.remove(r);
                                if( r==0 || r==1 || r==2)
                                    zarfiatMafia--;
                                if( r!=0 && r!=1  && r!=2)
                                    zarfiatShahrvand--;

                            }

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

                        System.out.println("        ***************       SHAB     ****************      " );
                        // gozashtane time limit
                      //  SearchControls ctls = new SearchControls();
                        // chat
                        while (true)
                        {

                           // ctls.setTimeLimit(5*60*1000);
                            long startTime = System.currentTimeMillis();
                            long endTime = startTime+( 5 *60 * 1000);

                            while(System.currentTimeMillis()<endTime)
                            {
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                System.out.println(str + " : " + voroody);

                            }

                            break;

                        }

                        // ray giri
                       // ctls.setTimeLimit(30*1000);
                        long startTime = System.currentTimeMillis();
                        long endTime = startTime+( 30 * 1000);

                        while(System.currentTimeMillis()<endTime)
                        {
                            dataOutputStream.writeUTF(" raye khod ra benevisid");
                            String voroody2 = dataInputStream.readUTF();
                            voroody2 = new String(voroody2.getBytes(StandardCharsets.UTF_8),"UTF-8");
                            System.out.println(str + " : " + voroody2);
                        }
                         startTime = System.currentTimeMillis();
                         endTime = startTime+( 30 * 1000);

                        while(System.currentTimeMillis()<endTime)
                        {
                            dataOutputStream.writeUTF(" che kasi rqa mikhahi nejat dahi ?");
                            String voroody3 = dataInputStream.readUTF();
                            voroody3 = new String(voroody3.getBytes(StandardCharsets.UTF_8),"UTF-8");
                            System.out.println(str + " : " + voroody3);
                        }

                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users1.get(ravanshenas).equals(str))
                            {

                                long startTime = System.currentTimeMillis();
                                long endTime = startTime+( 5* 60 * 1000);

                                while(System.currentTimeMillis()<endTime)
                                {
                                    dataOutputStream.writeUTF(" payame khod ra vared konid");
                                    String voroody = dataInputStream.readUTF();
                                    voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                    String text = str +" is typing ...";
                                    for(char c : text.toCharArray()) {
                                        System.out.print(c);
                                        Thread.sleep(500);
                                    }
                                    System.out.println();
                                    System.out.println(str + " : " + voroody);
                                }
                                //SearchControls ctls = new SearchControls();
                                //ctls.setTimeLimit(5*60*1000);
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

                        long startTime = System.currentTimeMillis();
                        long endTime = startTime+( 30 * 1000);

                        while(System.currentTimeMillis()<endTime)
                        {

                            dataOutputStream.writeUTF(" raye khod ra vared konid");
                            dataOutputStream.writeUTF(" kole bazikonane vared shode");

                            for (Map.Entry<Integer, String> entry : users1.entrySet())
                            {

                                System.out.println(entry.getKey() + ":" + entry.getValue());

                            }

                            String ray = dataInputStream.readUTF();
                            int ara[] = {0,0,0,0,0,0,0,0,0,0};



                            for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            System.out.println(r + " : " + users1.get(r));
                            users1.remove(r);
                        }

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

                        System.out.println("        ***************       SHAB     ****************      " );
                        // gozashtane time limit
                        //SearchControls ctls = new SearchControls();
                        // chat
                        while (true)
                        {

                            long startTime = System.currentTimeMillis();
                            long endTime = startTime+( 5 * 60 * 1000);

                            while(System.currentTimeMillis()<endTime)
                            {

                                // ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                System.out.println(str + " : " + voroody);

                            }

                            break;

                        }

                        // ray giri
                        //ctls.setTimeLimit(30*1000);
                        long startTime = System.currentTimeMillis();
                        long endTime = startTime+( 30 * 1000);

                        while(System.currentTimeMillis()<endTime)
                        {
                            dataOutputStream.writeUTF(" raye khod ra benevisid");
                            String voroody2 = dataInputStream.readUTF();
                            voroody2 = new String(voroody2.getBytes(StandardCharsets.UTF_8),"UTF-8");
                            System.out.println(str + " : " + voroody2);

                        }

                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users1.get(ravanshenas).equals(str))
                            {
                                long startTime = System.currentTimeMillis();
                                long endTime = startTime+( 5* 60 * 1000);

                                while(System.currentTimeMillis()<endTime)
                                {

                                    //SearchControls ctls = new SearchControls();
                                   // ctls.setTimeLimit(5*60*1000);
                                    dataOutputStream.writeUTF(" payame khod ra vared konid");
                                    String voroody = dataInputStream.readUTF();
                                    voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                    String text = str +" is typing ...";
                                    for(char c : text.toCharArray()) {
                                        System.out.print(c);
                                        Thread.sleep(500);
                                    }
                                    System.out.println();
                                    System.out.println(str + " : " + voroody);
                                }

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

                        long startTime = System.currentTimeMillis();
                        long endTime = startTime+( 30 * 1000);

                        while(System.currentTimeMillis()<endTime)
                        {
                            dataOutputStream.writeUTF(" kole bazikonane vared shode");

                            for (Map.Entry<Integer, String> entry : users1.entrySet())
                            {

                                System.out.println(entry.getKey() + ":" + entry.getValue());

                            }

                            String ray = dataInputStream.readUTF();
                            int ara[] = {0,0,0,0,0,0,0,0,0,0};



                            for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                                System.out.println(r + " : " + users1.get(r));
                                users1.remove(r);
                                if( r==0 || r==1 || r==2)
                                    zarfiatMafia--;
                                if( r!=0 && r!=1  && r!=2)
                                    zarfiatShahrvand--;


                            }


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

                        System.out.println("        ***************       SHAB     ****************      " );
                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi nejat dahi ?");
                        String voroody = dataInputStream.readUTF();
                        voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                        System.out.println(str + " : " + voroody);
                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            if( entry.getValue().equals(voroody))
                            doctorSahr = entry.getKey();

                        }


                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users1.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                String text = str +" is typing ...";
                                for(char c : text.toCharArray()) {
                                    System.out.print(c);
                                    Thread.sleep(500);
                                }
                                System.out.println();
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

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            System.out.println(r + " : " + users1.get(r));
                            users1.remove(r);
                            if( r==0 || r==1 || r==2)
                                zarfiatMafia--;
                            if( r!=0 && r!=1  && r!=2)
                                zarfiatShahrvand--;


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

                        System.out.println("        ***************       SHAB     ****************      " );
                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi estelam begiri ?");
                        String voroody = dataInputStream.readUTF();
                        voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                        System.out.println(str + " : " + voroody);

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            if(!users1.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                String text = str +" is typing ...";
                                for(char c : text.toCharArray()) {
                                    System.out.print(c);
                                    Thread.sleep(500);
                                }
                                System.out.println();
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

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            System.out.println(r + " : " + users1.get(r));
                            users1.remove(r);
                            if( r==0 || r==1 || r==2)
                                zarfiatMafia--;
                            if( r!=0 && r!=1  && r!=2)
                                zarfiatShahrvand--;


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

                        System.out.println("        ***************       SHAB     ****************      " );
                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi bokoshi ?");
                        dataOutputStream.writeUTF(" agar mikhay rad koni benevis ' hichkas ' ");
                        String voroody = dataInputStream.readUTF();
                        voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                        System.out.println(str + " : " + voroody);

                        if(voroody.equals(" hichkas"))
                            break;

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            if( entry.getValue().equals(voroody) && (entry.getKey()==1 || entry.getKey()==2 || entry.getKey()==0))
                            {

                                users1.remove(entry.getKey());
                                zarfiatMafia--;

                            }

                            else
                                {

                                    users1.remove(5);
                                    zarfiatShahrvand--;

                                }

                            break;

                        }

                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        while (true)
                        {
                            if(!users1.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                String text = str +" is typing ...";
                                for(char c : text.toCharArray()) {
                                    System.out.print(c);
                                    Thread.sleep(500);
                                }
                                System.out.println();
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

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            System.out.println(r + " : " + users1.get(r));
                            users1.remove(r);
                            if( r==0 || r==1 || r==2)
                                zarfiatMafia--;
                            if( r!= 0 && r!=1 && r!=2 )
                                zarfiatShahrvand--;

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

                        System.out.println("        ***************       SHAB     ****************      " );
                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        System.out.println("        ***************       SOBH    ****************      " );
                        while (true)
                        {
                            if(!users1.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                String text = str +" is typing ...";
                                for(char c : text.toCharArray()) {
                                    System.out.print(c);
                                    Thread.sleep(500);
                                }
                                System.out.println();
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

                        System.out.println("        ***************       RAYGIRI    ****************      " );
                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            System.out.println(r + " : " + users1.get(r));
                            users1.remove(r);
                            if( r==0 || r==1 || r==2)
                                zarfiatMafia--;
                            if( r!= 0 && r!=1 && r!=2 )
                                zarfiatShahrvand--;

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

                        System.out.println("        ***************       SHAB     ****************      " );
                        vaziat=1;
                        break;

                    }

                    if ( vaziat == 1)
                    {

                        System.out.println("        ***************       SOBH     ****************      " );
                        while (true)
                        {
                            if(!users1.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                String text = str +" is typing ...";
                                for(char c : text.toCharArray()) {
                                    System.out.print(c);
                                    Thread.sleep(500);
                                }
                                System.out.println();
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

                        System.out.println("        ***************       RAYGIRI    ****************      " );
                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                            System.out.println(str + " : " + voroody);
                            if(voroody.equals(" yes "))
                                break;
                            if(voroody.equals(" no "))
                                continue;
                            System.out.println(" bazikone zir az bazi hazf shod");
                            System.out.println(r + " : " + users1.get(r));
                            users1.remove(r);
                            if( r==0 || r==1 || r==2)
                                zarfiatMafia--;
                            if( r!= 0 && r!=1 && r!=2 )
                                zarfiatShahrvand--;

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

                        System.out.println("        ***************       SHAB     ****************      " );
                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi saket koni ?");
                        String voroody = dataInputStream.readUTF();
                        voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                        System.out.println(str + " : " + voroody);
                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            if(entry.getValue().equals(voroody))
                            {

                                ravanshenas = entry.getKey();

                            }

                        }


                    }
                    if ( vaziat == 1)
                    {

                        System.out.println("        ***************       SOBH     ****************      " );
                        while (true)
                        {

                            SearchControls ctls = new SearchControls();
                            ctls.setTimeLimit(10*60*1000);
                            dataOutputStream.writeUTF(" payame khod ra vared konid");
                            String voroody = dataInputStream.readUTF();
                            voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                            String text = str +" is typing ...";
                            for(char c : text.toCharArray()) {
                                System.out.print(c);
                                Thread.sleep(500);
                            }
                            System.out.println();
                            System.out.println(str + " : " + voroody);
                            break;

                        }

                        vaziat =2;
                        break;
                    }
                    if ( vaziat == 2)
                    {

                        System.out.println("        ***************       RAYGIRI    ****************      " );
                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            System.out.println(r + " : " + users1.get(r));
                            users1.remove(r);
                            if( r==0 || r==1 || r==2)
                                zarfiatMafia--;
                            if( r!= 0 && r!=1 && r!=2 )
                                zarfiatShahrvand--;

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

                        System.out.println("        ***************       SHAB     ****************      " );
                        SearchControls ctls = new SearchControls();
                        ctls.setTimeLimit(30*1000);
                        dataOutputStream.writeUTF(" che kasi ra mikhahi estelam begiri (afrade hazf shode) ?");
                        dataOutputStream.writeUTF(" agar kasi ra nemikhay ' hichkas ' benevis ");
                        String voroody = dataInputStream.readUTF();
                        voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                        System.out.println(str + " : " + voroody);

                        if( voroody.equals(" hichkas ") )
                            break;

                        while( estelamJanSakht <=1)
                        {

                            for ( int i =0 ; i<=9 ; i++)
                            {

                                if( !users1.containsKey(i))
                                {
                                    if(i==0)
                                        System.out.println(" godfather hazf shode ast");
                                    if(i==1)
                                        System.out.println(" doctor lekter hazf shode ast");
                                    if(i==2)
                                        System.out.println(" mafia sade hazf shode ast");
                                    if(i==3)
                                        System.out.println(" doctor shahr hazf shode ast");
                                    if(i==4)
                                        System.out.println(" karagah hazf shode ast");
                                    if(i==5)
                                        System.out.println(" herfe ey hazf shode ast");
                                    if(i==6)
                                        System.out.println(" shahrvand hazf shode ast");
                                    if(i==7)
                                        System.out.println(" shahrdar hazf shode ast");
                                    if(i==8)
                                        System.out.println(" ravanshenas hazf shode ast");

                                }

                                estelamJanSakht++;
                                break;

                            }


                        }

                    }

                    if ( vaziat == 1)
                    {

                        System.out.println("        ***************       SOBH     ****************      " );
                        while (true)
                        {
                            if(!users1.get(ravanshenas).equals(str))
                            {

                                SearchControls ctls = new SearchControls();
                                ctls.setTimeLimit(5*60*1000);
                                dataOutputStream.writeUTF(" payame khod ra vared konid");
                                String voroody = dataInputStream.readUTF();
                                voroody = new String(voroody.getBytes(StandardCharsets.UTF_8),"UTF-8");
                                String text = str +" is typing ...";
                                for(char c : text.toCharArray()) {
                                    System.out.print(c);
                                    Thread.sleep(500);
                                }
                                System.out.println();
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

                        System.out.println("        ***************       RAYGIRI    ****************      " );
                        dataOutputStream.writeUTF(" raye khod ra vared konid");
                        dataOutputStream.writeUTF(" kole bazikonane vared shode");

                        for (Map.Entry<Integer, String> entry : users1.entrySet())
                        {

                            System.out.println(entry.getKey() + ":" + entry.getValue());

                        }

                        String ray = dataInputStream.readUTF();
                        int ara[] = {0,0,0,0,0,0,0,0,0,0};



                        for (Map.Entry<Integer, String> entry : users1.entrySet())
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
                            System.out.println(r + " : " + users1.get(r));
                            users1.remove(r);
                            if( r==0 || r==1 || r==2)
                                zarfiatMafia--;
                            if( r!= 0 && r!=1 && r!=2 )
                                zarfiatShahrvand--;

                        }

                        vaziat =0 ;
                        break ;
                    }

                }

            }

            if( zarfiatMafia >= zarfiatShahrvand)
            {

                System.out.println(" mafia barande shodand");
                //dataOutputStream.writeUTF(sss);
                // bastan socket va stream ha
                dataInputStream.close();
                dataOutputStream.close();
                socket.close();

            }


        }

        // residegi be estesna
        catch (IOException | InterruptedException e )
        {

            e.printStackTrace();

        }

    }

}
