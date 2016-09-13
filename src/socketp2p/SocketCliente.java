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
public class SocketCliente implements Runnable{
    private String endereco; //O endereço do servidor
    private int porta; //O ip onde acontecerá a comunicação
    private String nome;
    
    public void run(){
        try {
            String mensagem, retorno;  //Vai guardar as mensagens enviadas para o outro lado
            Scanner lerTeclado = new Scanner(System.in);
            Socket cliente = new Socket(endereco, porta);
            System.out.println("O cliente se conectou ao servidor!");
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            while (lerTeclado.hasNextLine()) {
                saida.println(nome + ": " + lerTeclado.nextLine());
            }
            saida.close();
            lerTeclado.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println("Erro!");
        } 
    }
    
    public void setEndereco(int portap, String ip, String n){
        endereco = ip;
        porta = portap;
        nome = n; 
    }
    
    
}
