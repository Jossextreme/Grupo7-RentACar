
package grupo7.rentacar.Vehiculos;


/**
 *
 * @author geova
 */
public class NodoVehiculo {
    private Vehiculo dato;
    private NodoVehiculo next;
    private NodoVehiculo back;

    public NodoVehiculo(Vehiculo dato) {
        this.dato = dato;
    }

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public NodoVehiculo getNext() {
        return next;
    }

    public void setNext(NodoVehiculo next) {
        this.next = next;
    }

    public NodoVehiculo getBack() {
        return back;
    }

    public void setBack(NodoVehiculo back) {
        this.back = back;
    }
    
    @Override
    public String toString() {
        return dato+"";
    }
    
}
