package grupo7.rentacar.Vehiculos;

import grupo7.rentacar.Cliente.Cliente;
import grupo7.rentacar.Cliente.NodoCliente;
import grupo7.rentacar.Enumeraciones.Combustibles;
import javax.swing.JOptionPane;


/**
 *
 * @author geova
 */
public class ListaVehiculo {
    private NodoVehiculo cabeza;
    private NodoVehiculo ultimo;
    
    public void registrar(Vehiculo vehiculo){
        
        NodoVehiculo temp = new NodoVehiculo(vehiculo);
                
        if(cabeza==null){ 
            cabeza = new NodoVehiculo(vehiculo);
            ultimo = cabeza;
            ultimo.setNext(cabeza);
            cabeza.setBack(ultimo);
        }else if(vehiculo.getAnno() > cabeza.getDato().getAnno()){
            temp.setNext(cabeza);
            temp.setBack(ultimo);
            cabeza.setBack(temp);
            ultimo.setNext(temp);
            cabeza = temp;
        }else if(ultimo.getDato().getAnno() >=vehiculo.getAnno()){
            temp.setNext(cabeza);
            temp.setBack(ultimo);
            ultimo.setNext(temp);
            cabeza.setBack(temp);
            ultimo = temp;
        }
        else{
           NodoVehiculo aux = cabeza; 
           while (aux.getNext().getDato().getAnno() >= vehiculo.getAnno()){
               aux=aux.getNext();
           }
           temp.setNext(aux.getNext()); 
           temp.setBack(aux); 
           aux.setNext(temp); 
           temp.getNext().setBack(temp); 
        }
        ultimo.setNext(cabeza);
        cabeza.setBack(ultimo);
    }
    
    public void Eliminar(String placa){
        if (cabeza != null) {
            if (cabeza.getDato().getPlaca().equals(placa)) {
                cabeza = cabeza.getNext(); 
                ultimo.setNext(cabeza);
            }else{
                NodoVehiculo aux = cabeza;
                while (aux.getNext() != cabeza 
                        && !aux.getNext().getDato().getPlaca().equals(placa) 
                      ) 
                {
                    aux = aux.getNext();
                }
                if (aux.getNext().getDato().getPlaca().equals(placa)) {
                    if (aux.getNext() == ultimo) { 
                        ultimo = aux; //Se actualiza el utlimo
                    }    
                    aux.setNext(aux.getNext().getNext()); 
                }
            }
        }
    }
    /* El método consultar recibe como parámetro una placa que se desea consultar, así que 
     * recorre la lista buscando cuál nodo tiene la placa con ese vehiculo y
     * al encontrarlo va a modificar la informacion que fue agregada anteriormente
     * y devolvera un String que indicara que la informacion fue agregada correctamente. En 
     * caso de no encontrarlo devuelve un String con el mensaje "El cliente no 
     * se ha encontrado"
    */
        public String Modificar(Vehiculo v){
        /*String respuesta = "";
        boolean esta = false;
        if(cabeza != null){//Se verifica que la lista tenga nodos
            NodoVehiculo aux = cabeza;//Se crea un nodo para índice
            if(!aux.getDato().getPlaca().equals(v.getPlaca())){
                aux = aux.getNext();
            }else{
                NodoVehiculo temp = new NodoVehiculo(v);
                temp.setNext(aux.getNext());
                temp.setBack(aux.getBack());
                cabeza = temp;
                aux = cabeza;
                esta = true;
            }
            while(aux != cabeza){
                if((aux.getDato().getPlaca().equals(v.getPlaca()))&& aux != ultimo){
                    NodoVehiculo temp = new NodoVehiculo(v);
                    temp.setNext(aux.getNext());
                    temp.setBack(aux.getBack());
                    aux.setNext(null);
                    aux.setBack(null);
                    esta = true;
                    aux = cabeza;
                }else if((aux.getDato().getPlaca().equals(v.getPlaca()))&& aux == ultimo){
                    NodoVehiculo temp = new NodoVehiculo(v);
                    temp.setNext(aux.getNext());
                    temp.setBack(aux.getBack());
                    ultimo = temp;
                    aux.setNext(null);
                    aux.setBack(null);
                    esta = true;
                    aux = cabeza;
                }else{
                    aux = aux.getNext();
                }
            }
            if(esta == false){
                respuesta = "El cliente no se ha encontrado";
            }else{
                respuesta = "El cliente fue correctamente modificado";
            }
        }
        return respuesta;*/
        
        String respuesta = "";
        boolean esta = false;
        if(cabeza != null){//Se verifica que la lista tenga nodos
            NodoVehiculo aux = cabeza;//Se crea un nodo para índice
            if(aux.getDato().getPlaca()!=v.getPlaca()){
                aux = aux.getNext();
            }else{
                NodoVehiculo temp = new NodoVehiculo(v);
                cabeza.setDato(v);
                esta = true;
            }
            while(aux != cabeza){
                if(aux.getDato().getPlaca()==v.getPlaca()){
                    NodoVehiculo temp = aux;
                    temp.setDato(v);
                    esta = true;
                    aux = cabeza;
                }else {
                    aux = aux.getNext();
                }
            }
            if(esta == false){
                respuesta = "El cliente no se ha encontrado";
            }else{
                respuesta = "El cliente fue correctamente modificado";
            }
        }
        return respuesta;
    }
    /* El método consultar recibe como parámetro una placa que se desea consultar, así que 
     * recorre la lista buscando cuál nodo tiene la placa con ese vehiculo y
     * al encontrarlo devuelve un String con la información del cliente. En 
     * caso de no encontrarlo devuelve un String con el mensaje "El cliente no 
     * se ha encontrado"
    */
    public String Consultar(String placa){
        String respuesta = "";
        boolean esta = false;
        if(cabeza != null){//Se verifica que la lista tenga nodos
            NodoVehiculo aux = cabeza;//Se crea un nodo para índice
            if(!aux.getDato().getPlaca().equals(placa)){
                aux = aux.getNext();
            }else{
                respuesta += "El vehiculo es modelo: "+aux.getDato().getModelo()+
                        "del año: "+aux.getDato().getAnno()+
                        "\n"+"Con un cilindraje "+aux.getDato().getCilindrada()+
                        "\n"+"El combustible que utiliza es: "
                        +aux.getDato().getCombustible()+
                        "\n"+"Su estado es: "+aux.getDato().getEstado();
            }
            while(aux != cabeza){
                if(aux.getDato().getPlaca().equals(placa)){
                    respuesta += "El vehiculo es modelo: "+aux.getDato().getModelo()+
                            "del año: "+aux.getDato().getAnno()+
                            "\n"+"Con un cilindraje "+aux.getDato().getCilindrada()+
                            "\n"+"El combustible que utiliza es: "
                            +aux.getDato().getCombustible()+
                            "\n"+"Su estado es: "+aux.getDato().getEstado();
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
    public String Listar(){
       NodoVehiculo aux = cabeza;
        String s="Lista de vehículos: "+"\n";
        if (aux != null){
            s+= "Marca: "+aux.getDato().getMarca()+"\n"+"Modelo: "+
                    aux.getDato().getModelo()+"\n"+"Placa: "+
                    aux.getDato().getPlaca()+"\n"+"Año: "+
                    aux.getDato().getAnno()+"Cilindraje: "+
                    aux.getDato().getCilindrada()+"Pasajeros: "+
                    aux.getDato().getPasajeros()+"Estado: "+
                    aux.getDato().getEstado()+
                    "---------------------------------------------------------";
            aux=aux.getNext();
            while(aux != cabeza){ //se debe detener la cabeza por ser cirucular
                s+= "Marca: "+aux.getDato().getMarca()+"\n"+"Modelo: "+
                    aux.getDato().getModelo()+"\n"+"Placa: "+
                    aux.getDato().getPlaca()+"\n"+"Año: "+
                    aux.getDato().getAnno()+"Cilindraje: "+
                    aux.getDato().getCilindrada()+"Pasajeros: "+
                    aux.getDato().getPasajeros()+"Estado: "+
                    aux.getDato().getEstado()+
                    "---------------------------------------------------------";
            aux=aux.getNext();
           }
        } else{
            s+="vacia";
        }
        return s;
    }
   @Override
   public String toString(){
       NodoVehiculo aux = cabeza;
        String s = "\n -= Lista de Vehiculos=-";
        if (aux != null){
            s+="\n"+aux;
            aux=aux.getNext();
            while(aux != cabeza){
            s+=",\n"+aux;
                aux=aux.getNext();
            }
        } else{
            s+="vacia";
        }
        return s;
   }
   
}
