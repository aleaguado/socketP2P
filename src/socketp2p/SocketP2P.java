/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketp2p;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author aleaguado
 */
public class SocketP2P {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try { 
            Scanner lerTeclado = new Scanner(System.in);
            Scanner lerTecladoInt = new Scanner(System.in);
            String ipServer;
            int portaServer;
            String nome;
            
            // TODO code application logic here
            SocketCliente sc = new SocketCliente(); // Instanciando a parte cliente
            SocketServidor sv = new SocketServidor(); // Instanciando a parte servidora

            Thread processoSC = new Thread(sc); //Instanciamos o processo cliente
            Thread processoSV = new Thread(sv); //Instanciamos o processo servidor

            System.out.println("Em qual porta seu servidor deverá escutar? ");
            sv.setPorta(lerTecladoInt.nextInt());    
            processoSV.start();
            System.out.println("Qual IP do servidor em que você quer se conectar? ");
            ipServer = lerTeclado.nextLine();
            System.out.println("Qual porta do servidor em que você quer se conectar? ");
            portaServer = lerTecladoInt.nextInt();
            System.out.println("Qual seu nome: ");
            nome = lerTeclado.nextLine();
            sc.setEndereco(portaServer, ipServer, nome);
            processoSC.start();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    
    }
    
}
