
package grupo7.rentacar.Cliente;

public class NodoCliente {
    private Cliente dato;
    private NodoCliente next;
    private NodoCliente back;

    public NodoCliente(Cliente dato) {
        this.dato = dato;
    }
//        @Override
//    public String toString(){
//        return "Nodo{"+"Nombre: "+dato.getNombre()+"\n "
//                + "cedula"+dato.getCedula()+ "\n"
//                + "categoria: " + dato.getCategoria();
//    }
    //Prueba
    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoCliente getNext() {
        return next;
    }

    public void setNext(NodoCliente next) {
        this.next = next;
    }

    public NodoCliente getBack() {
        return back;
    }

    public void setBack(NodoCliente back) {
        this.back = back;
    }
    
}
