/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo7.rentacar;

import grupo7.rentacar.Cliente.Categoria;
import grupo7.rentacar.Cliente.ListaCliente;
import grupo7.rentacar.Cliente.Cliente;
import grupo7.rentacar.Extras.ListaExtras;
import grupo7.rentacar.JFrameInterfaz.JFrameInterfaz;
import javax.swing.JOptionPane;
public class Grupo7RentACar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrameInterfaz.main(args);
        /*String s = "s";
        int contador=0;
        while(s != ""){
            s=JOptionPane.showInputDialog("Categoria");
            Cliente client = new Cliente("Jose",String.valueOf(contador),1424,"@.com","99/9",Categoria.valueOf(s));
            contador++;
            ListaExtras extras = new ListaExtras(); 
            Funciones.solicitarAlquiler(client, 0, 0, "nissan", 2000, extras);
            System.out.print(Funciones.alquileres);
        }*/
    }
    
}
