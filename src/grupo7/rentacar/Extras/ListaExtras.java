
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
                   <p.getId()){
               aux=aux.getNext();
           }
           NodoExtras temp = new NodoExtras(e);
           temp.setNext(aux.getNext());
           aux.setNext(temp);
        } 
    }
    @Override
    public String toString(){
        return "EXTRAS";
    }   
}
