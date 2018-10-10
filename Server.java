/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
      public static final int SERVICE_PORT=12;
      SerializationDemo s=new SerializationDemo();

//    public static final int SERVICE_PORT = 7,
//            BUFSIZE = 4096;
//    private DatagramSocket ds;
    String status;
//    
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
//
//    public Server() {
//        try {
//            ds = new DatagramSocket(SERVICE_PORT);
//            System.out.println("Server active on port " + ds.getLocalPort());
//        } catch (IOException ex) {
//            System.err.println("Error " + ex.getMessage());
//        }
//    }

//    public void serviceClients() {
//        byte[] buffer = new byte[BUFSIZE];
//        for (;;) {
//            try {
//                DatagramPacket dp = new DatagramPacket(buffer, BUFSIZE);
//
//                ds.receive(dp);
//                System.out.println("Packet received from "
//                        + dp.getAddress() + " \t : "
//                        + dp.getPort() + " "
//                        + "of Length " + dp.getLength());
//                System.out.println("Status \t : " +getStatus() +"\n");
//                ds.send(dp);
//            } catch (IOException ex) {
//                System.err.println("Error " + ex.getMessage());
//            }
//        }
//    }
    
    void server2()
    {
    try
        {
            ServerSocket server=new ServerSocket(SERVICE_PORT);
            System.out.println("Ini adalah hasil dari server :");
            for(;;){
            Socket nextClient=server.accept();
            
            
            BufferedReader reader=new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
            System.out.println("Result :"+reader.readLine());
            System.out.println("Received Request from : "+nextClient.getInetAddress()+""+nextClient.getPort());
            nextClient.close();
            }
        }
    catch(IOException ioe)
        {
            System.out.println("Error"+ioe.getMessage());
        }
    }

    public static void main(String[] args) 
    {
 Server es=new Server();
      es.server2();
//              
    }
}
