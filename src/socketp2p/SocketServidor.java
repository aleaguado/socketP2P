/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketp2p;
import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author aleaguado
 */
public class SocketServidor implements Runnable{
    private int porta;
    public void run(){
        try {
            ServerSocket servidor = new ServerSocket(porta);
            Socket cliente = servidor.accept();
            String nomeCliente = cliente.getInetAddress().getHostAddress();
            System.out.println("Nova conexão com o cliente " +  nomeCliente);
            Scanner s = new Scanner(cliente.getInputStream());
            while (s.hasNextLine()) {
                System.out.println(nomeCliente + ": "+ s.nextLine());
            }
            s.close();
            servidor.close();
            cliente.close();
            /*
            String mensagem;
            ServerSocket welcomeSocket = new ServerSocket (porta);
            while(true){
                Socket connectionSbocket = welcomeSocket.accept();
                BufferedReader msgCliente = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream resposta = new DataOutputStream(connectionSocket.getOutputStream());
                mensagem = msgCliente.readLine();
                System.out.println("Mensagem: " + mensagem);
                resposta.writeBytes("OK");
 
            
            } */    
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }
    
    public void setPorta(int portaParam){
        porta = portaParam;
        
    }
}
