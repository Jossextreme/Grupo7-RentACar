
package grupo7.rentacar.Extras;

/**
 *
 * @author geova
 */
public class ListaExtras {
    
    /*
arranque sin llave, 
conectividad con cargador inalámbrico 
navegador con tráfico en tiempo real
sensores 
cámara de visión trasera
    
    */
    private NodoExtras cabeza;
    
    public void inserta(Extra e){
        if(cabeza==null){
            cabeza = new NodoExtras(e);
        }else if(e.getId()<cabeza.getDato().getId()){
            NodoExtras aux = new NodoExtras(e);
            aux.setNext(cabeza);
            cabeza=aux;
        }else if(cabeza.getNext()==null){
            cabeza.setNext(new NodoExtras(e));
        }else{
           NodoExtras aux = cabeza;
           while (aux.getNext() != null &&
                   aux.getNext().getDato().getId()
                   <e.getId()){
               aux=aux.getNext();
           }
           NodoExtras temp = new NodoExtras(e);
           temp.setNext(aux.getNext());
           aux.setNext(temp);
        } 
    }
    
    public boolean existe (int id){
        boolean esta = false;
        if (cabeza != null){
            NodoExtras aux = cabeza;
            while (aux != null && aux.getDato().getId() < id){
                aux = aux.getNext () ;
            }
            esta = (aux != null && aux.getDato().getId()== id);
        }

        return esta;
    }
    
    public void elimina (int id) {
        if (cabeza != null) { 
            if (cabeza.getDato().getId() == id) 
            {
                cabeza = cabeza.getNext();
            } 
            else {
                NodoExtras aux = cabeza; 
                while (aux. getNext () != null &&
                    aux.getNext () .getDato () .getId() < id) {
                    aux = aux.getNext () ;
                }
                if (aux.getNext () != null &&
                aux.getNext () .getDato () .getId () == id) {
                    aux. setNext (aux.getNext () .getNext ()); //cambio las referencias
                }
            }
        }
    }
    
    public String Listar(){
        String respuesta = "Las extras son las siguientes: "+"\n";
        NodoExtras aux = cabeza;
        while(aux != null){
            respuesta += "- "+aux.getDato().getNombre()+"\n";
            aux = aux.getNext();
        }
        return respuesta;
    }
    
    @Override
    public String toString(){
        return "EXTRAS";
    }   
}
