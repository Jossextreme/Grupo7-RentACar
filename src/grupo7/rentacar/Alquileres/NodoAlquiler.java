/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.rentacar.Alquileres;

/**
 *
 * @author geova
 */
public class NodoAlquiler {
    private Alquiler dato;
    private NodoAlquiler atras;

    public Alquiler getDato() {
        return dato;
    }

    public void setDato(Alquiler dato) {
        this.dato = dato;
    }

    public NodoAlquiler getAtras() {
        return atras;
    }

    public void setAtras(NodoAlquiler atras) {
        this.atras = atras;
    }

    public NodoAlquiler(Alquiler dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return ""+dato;
    }
}
