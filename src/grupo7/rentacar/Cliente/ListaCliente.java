
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
                    aux.setNext (aux.getNext().getNext()); 
                }
              }
           }
        }
    }
    
    public void Modificar(Cliente c){
        
    }
    /* El método consultar recibe como parámetro un número entero que 
     * corresponde a la cédula del cliente que se desea consultar, así que 
     * recorre la lista buscando cuál nodo tiene un cliente con esa cédula y
     * al encontrarlo devuelve un String con la información del cliente. En 
     * caso de no encontrarlo devuelve un String con el mensaje "El cliente no 
     * se ha encontrado"
    */
    public String Consultar(int cedula){
        String respuesta = "";
        boolean esta = false;
        if(cabeza != null){//Se verifica que la lista tenga nodos
            NodoCliente aux = cabeza;//Se crea un nodo para índice
            if(aux.getDato().getCedula()!=cedula){
                aux = aux.getNext();
            }else{
                respuesta += "El nombre del cliente es: "+aux.getDato().getNombre()+" "+aux.getDato().getApellidos()+"\n"+"Su fecha de naciemiento es: "+aux.getDato().getFechaNaci()+"\n"+"Su correo es: "+aux.getDato().getCorreoElec()+"\n"+"Su categoría es: "+aux.getDato().getCategoria();
            }
            while(aux != cabeza){
                if(aux.getDato().getCedula()==cedula){
                    respuesta += "El nombre del cliente es: "+aux.getDato().getNombre()+" "+aux.getDato().getApellidos()+"\n"+"Su fecha de naciemiento es: "+aux.getDato().getFechaNaci()+"\n"+"Su correo es: "+aux.getDato().getCorreoElec()+"\n"+"Su categoría es: "+aux.getDato().getCategoria();
                    esta = true;
                    aux = cabeza;
                }else{
                    aux = aux.getNext();
                }
            }
            if(esta == false){
                respuesta = "El cliente no se ha encontrado";
            }
        }
        return respuesta;
    }
}
