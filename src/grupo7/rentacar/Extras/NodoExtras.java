/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.rentacar.Extras;

/**
 *
 * @author geova
 */
public class NodoExtras {

    private Extra dato;
    private NodoExtras next;

    public NodoExtras(Extra dato) {
        this.dato = dato;
    }

    public Extra getDato() {
        return dato;
    }

    public void setDato(Extra dato) {
        this.dato = dato;
    }

    public NodoExtras getNext() {
        return next;
    }

    public void setNext(NodoExtras next) {
        this.next = next;
    }

}
