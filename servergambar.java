/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas;

import static Tugas.Server.SERVICE_PORT;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ozora
 */
public class servergambar 
{
    
      public static final int SERVICE_PORT=12;
    String status;
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
     void server2()
    {
    try
        {
            ServerSocket server=new ServerSocket(SERVICE_PORT);
            System.out.println("Ini adalah hasil dari server :");
            for(;;){
            Socket nextClient=server.accept();
            
            
            BufferedReader reader=new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
            Image image = null;
           
            File sourceimage=new File(String.valueOf(reader));
            image =ImageIO.read(sourceimage);
            InputStream is = new BufferedInputStream(new FileInputStream(String.valueOf(reader)));
            
            JFrame frame=new JFrame();
            JLabel label=new JLabel(new ImageIcon(image));
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
            nextClient.close();
            }
        }
    catch(IOException ioe)
        {
            System.out.println("Error"+ioe.getMessage());
        }
    }
     public static void main(String[] args) {
        servergambar s=new servergambar();
        s.server2();
    }
}
