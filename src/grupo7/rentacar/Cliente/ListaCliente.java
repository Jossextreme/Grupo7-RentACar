
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
        }else if(d.getCedula() < cabeza.getDato().getCedula()){
            // Si lo que se va a insertar debe estar a la izquierda de la cabeza 
            NodoCliente aux = new NodoCliente(d);
            aux.setNext(cabeza);
            cabeza=aux;
            cabeza.setBack(ultimo); //Se enlaza la cabeza con el ultimo
            ultimo.setNext(cabeza);
        }else if(ultimo.getDato().getCedula() <= d.getCedula()){
            //Si la lista ya tiene un cliente lo sigue insertando al final 
            ultimo.setNext(new NodoCliente(d)); 
            ultimo = ultimo.getNext(); 
            //El ultimo pasa a ser el nodo que acabamos de agregar
            ultimo.setNext(cabeza);
            cabeza.setBack(ultimo);
        }else{
           //Por si hay que insertar en el medio de la lista
           NodoCliente aux = cabeza; //Un auxiliar para recorrer la lista
           while (aux.getNext().getDato().getCedula() < d.getCedula()){
               aux=aux.getNext();
           }
           NodoCliente temp = new NodoCliente(d);
           temp.setNext(aux.getNext()); 
           temp.setBack(aux); 
           aux.setNext(temp); 
           temp.getNext().setBack(temp); 
        }
        ultimo.setNext(cabeza);
        cabeza.setBack(ultimo);
    }
    public void Eliminar(int cedula){

        if (cabeza != null) { //Si hay algo en la lista buscaré
        if (cedula >= cabeza.getDato().getCedula()
            && cedula <= ultimo.getDato().getCedula()) {
                
                if (cabeza.getDato().getCedula() == cedula) {
                cabeza = cabeza.getNext(); 
      //Actualizo la cabeza, la paso al siguiente porque se va eliminar ese nodo
                ultimo.setNext(cabeza);
            }else{
                NodoCliente aux = cabeza; //utilizo aux como indice
                //Mientras no se acabe la lista y el elemento
                //de la lista sea menor que el buscado
                while (aux.getNext() != cabeza 
                        && aux.getDato().getCedula() < cedula) {
                    aux = aux.getNext();//avanzo en la lista
                }
                // si es el de adelante lo borro
                if (aux.getNext().getDato().getCedula() == cedula) {
                    //Por si hay que eliminar el utlimo
                    if (aux.getNext() == ultimo) { 
                        ultimo = aux; //Se actualiza el utlimo
                    }
                    //cambio las referencias
                    aux. setNext (aux.getNext () .getNext ()); 
                }
              }
           }
        }
    }
}
