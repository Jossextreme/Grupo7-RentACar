
package grupo7.rentacar.Cliente;

public class ListaCliente {
    private NodoCliente cabeza;
    private NodoCliente ultimo;
    
    public void Insertar(Cliente d){
        if(cabeza==null){ //Si la cabeza es null, la lista esta vacia
            cabeza = new NodoCliente(d);
            ultimo = cabeza;
            ultimo.setNext(cabeza); //Se enlaza el ultimo a la cabeza
            cabeza.setBack(ultimo); //Se enlaza la cabeza al ultimo
        }else{
            //Si la lista ya tiene un cliente lo sigue insertando al final 
            ultimo.setNext(new NodoCliente(d)); 
            ultimo = ultimo.getNext(); 
            //El ultimo pasa a ser el nodo que acabamos de agregar
            ultimo.setNext(cabeza);
            cabeza.setBack(ultimo);
        }
    }
    public void Eliminar(int cedula){
        
    }
}
