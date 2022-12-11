/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.rentacar.Alquileres;

/**
 *
 * @author geova
 */
public class ColaAlquiler {
    private NodoAlquiler frente;
    private NodoAlquiler ultimo;
    
    public void encola(Alquiler alquiler){
        NodoAlquiler a = new NodoAlquiler(alquiler);
        if(frente == null){  // significa que la cola esta vacia
            frente = a;
            ultimo = a;
        } else{
            ultimo.setAtras(a);
            ultimo=a;
        }
    }
    
    public Alquiler atiende(){
        NodoAlquiler aux = frente;
        if(frente!=null){
            frente=frente.getAtras();
            aux.setAtras(null);
        }
        return aux.getDato();
    }
    
    @Override
    public String toString(){
        String s=" -= Cola de Clientes =- ";
        NodoAlquiler aux=frente;
        while(aux!=null){
            s+=aux;
            aux=aux.getAtras();
        }
        return s;
    }   
}
