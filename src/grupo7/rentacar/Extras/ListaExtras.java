
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
    
    
    public int numIDExtras(){
        String s="";
        
        // Arranque sin llave
        if(existe(1)){
            s+="1";
        }else{
            s+="0";
        }
        
        //Navegador
        if(existe(2)){
            s+="1";
        }else{
            s+="0";
        }
        if(existe(3)){
            s+="1";
        }else{
            s+="0";
        }
        if(existe(4)){
            s+="1";
        }else{
            s+="0";
        }
        if(existe(5)){
            s+="1";
        }else{
            s+="0";
        }
        
        return Integer.parseInt(s);
    }
    
    @Override
    public String toString(){
        String s= "";
        if (cabeza != null){
            NodoExtras aux = cabeza;
            while (aux != null){
                s+=aux.getDato()+", ";
                aux = aux.getNext ();
            }
            s = s.substring(0,s.length()-3);
        }else{
            s= "No hay extras";
        }
        return s;
    }   
}
