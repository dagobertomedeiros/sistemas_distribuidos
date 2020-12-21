/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagoberto
 */

import java.io.IOException; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
         
        Scanner input = new Scanner(System.in);
        boolean chatAtivo = true;
        String nome = "nome";
        String msg = "";
        
        String txtIP = "127.0.0.1";
        int numPorta = 0;
        Socket socket;
        OutputStream ou ;
        Writer ouw;
        BufferedWriter bfw;
        System.out.println("Informe numero da porta:"); 
        numPorta = input.nextInt();
        socket = new Socket(txtIP,numPorta);
        ou = socket.getOutputStream();
        ouw = new OutputStreamWriter(ou);
        bfw = new BufferedWriter(ouw);
           
        InputStream in = socket.getInputStream();
        InputStreamReader inr = new InputStreamReader(in);
        BufferedReader bfr = new BufferedReader(inr);
        
        
        
        System.out.println("Para finalizar o chat digite -> sair"); 
        System.out.println("Informe seu nome:"); 
        nome = input.nextLine();
        
        while (chatAtivo){ 
            System.out.print(nome + "->>> \r\n"); 
            msg = input.nextLine();
            bfw.write(nome + " ->>> " + msg + "\r\n");
            bfw.flush();
            
            if(msg.equals("sair")){
                chatAtivo = false;
                bfw.close();
                ouw.close();
                ou.close();
                socket.close();
            }
            else if(bfr.ready()){
                
                msg = bfr.readLine();
                System.out.println(msg +"\r\n"); 
            }
            
        }
        System.out.println("chat encerrado"); 
    }
}
