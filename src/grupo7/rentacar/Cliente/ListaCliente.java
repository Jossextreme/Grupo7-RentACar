
package grupo7.rentacar.Cliente;
import javax.swing.JOptionPane;

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
        } else if (ultimo.getDato().getCedula() <= d.getCedula()) {
            //Si la lista ya tiene un cliente lo sigue insertando al final 
            ultimo.setNext(new NodoCliente(d));
            ultimo = ultimo.getNext();
            //El ultimo pasa a ser el nodo que acabamos de agregar
            ultimo.setNext(cabeza);
            cabeza.setBack(ultimo);
        } else {
            //Por si hay que insertar en el medio de la lista
            NodoCliente aux = cabeza; //Un auxiliar para recorrer la lista
            while (aux.getNext().getDato().getCedula() < d.getCedula()) {
                aux = aux.getNext();
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

    public void Eliminar(int cedula) {
        if (cabeza != null) { //Si hay algo en la lista buscarĂ©
            if (cedula >= cabeza.getDato().getCedula()
                    && cedula <= ultimo.getDato().getCedula()) {
                if (cabeza.getDato().getCedula() == cedula) {
                    if (cabeza == ultimo) {
                        cabeza = null;
                        ultimo = null;
                    } else {
                        cabeza = cabeza.getNext();
                        // Actualizo la cabeza, siguiente porque se va eliminar 
                        // ese nodo
                        ultimo.setNext(cabeza);
                    }
                    JOptionPane.showMessageDialog(
                            null,
                            "Â¡Cliente eliminado satisfatoriamente!",
                            "Cliente: ",
                            1
                    );
                } else {
                    NodoCliente aux = cabeza; //utilizo aux como indice
                    //Mientras no se acabe la lista y el elemento
                    //de la lista sea menor que el buscado
                    while (aux.getNext() != cabeza
                            && aux.getNext().getDato().getCedula() < cedula) {
                        aux = aux.getNext();//avanzo en la lista
                    }
                    // si es el de adelante lo borro
                    if (aux.getNext().getDato().getCedula() == cedula) {
                        //Por si hay que eliminar el utlimo
                        if (aux.getNext() == ultimo) {
                            ultimo = aux; //Se actualiza el utlimo
                        }
                        //cambio las referencias
                        aux.setNext(aux.getNext().getNext());
                        JOptionPane.showMessageDialog(
                                null,
                                "Â¡Cliente eliminado satisfatoriamente!",
                                "Cliente: ",
                                1
                        );
                    }
                }
            }
        }
        else{
        JOptionPane.showMessageDialog(
                    null, 
                    "Error: No hay clientes por eliminar", 
                    "Error: No hay clientes por eliminar", 
                    0
            );
        }
    }

    public String Modificar(Cliente c) {
        String respuesta = "";
        boolean esta = false;
        if (cabeza != null) {//Se verifica que la lista tenga nodos
            NodoCliente aux = cabeza;//Se crea un nodo para Ă­ndice
            if (aux.getDato().getCedula() != c.getCedula()) {
                aux = aux.getNext();
            } else {
                NodoCliente temp = new NodoCliente(c);
                cabeza.setDato(c);
                esta = true;
            }
            while (aux != cabeza) {
                if (aux.getDato().getCedula() == c.getCedula()) {
                    NodoCliente temp = aux;
                    temp.setDato(c);
                    esta = true;
                    aux = cabeza;
                } else {
                    aux = aux.getNext();
                }
            }
            if (esta == false) {
                respuesta = "El cliente no se ha encontrado";
            } else {
                respuesta = "El cliente fue correctamente modificado";
            }
        }
        return respuesta;
    }

    /* El mĂ©todo consultar recibe como parĂ¡metro un nĂºmero entero que 
     * corresponde a la cĂ©dula del cliente que se desea consultar, asĂ­ que 
     * recorre la lista buscando cuĂ¡l nodo tiene un cliente con esa cĂ©dula y
     * al encontrarlo devuelve un String con la informaciĂ³n del cliente. En 
     * caso de no encontrarlo devuelve un String con el mensaje "El cliente no 
     * se ha encontrado"
     */
    public Cliente Consultar(int cedula) {
        Cliente respuesta = null;
        boolean esta = false;
        if (cabeza != null) {//Se verifica que la lista tenga nodos
            NodoCliente aux = cabeza;//Se crea un nodo para Ă­ndice
            if (aux.getDato().getCedula() != cedula) {
                aux = aux.getNext();
            } else {
                respuesta = aux.getDato();
                esta = true;
            }
            while (aux != cabeza && !esta) {
                if (aux.getDato().getCedula() == cedula) {
                    respuesta = aux.getDato();
                    esta = true;
                    break;
                } else {
                    aux = aux.getNext();
                }
            }
            if (esta == false) {
                respuesta = null;
            }
        }
        return respuesta;
    }

    @Override
    public String toString() {
        NodoCliente aux = cabeza;
        String s = "   -=Lista Clientes=- \n";
        if (aux != null) {
            s += aux + ", \n";
            aux = aux.getNext();
            while (aux != cabeza) { //se debe detener la cabeza por ser cirucular
                s += aux + ", \n";
                aux = aux.getNext();
            }
        } else {
            s += "No hay clientes";
        }
        return s;
    }
}
