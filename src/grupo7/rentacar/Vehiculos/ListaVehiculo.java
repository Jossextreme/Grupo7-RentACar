package grupo7.rentacar.Vehiculos;

import grupo7.rentacar.Alquileres.Alquiler;
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
                if (cabeza == ultimo) {
                    cabeza = null;
                    ultimo = null;
                }else{
                    cabeza = cabeza.getNext(); 
                    ultimo.setNext(cabeza);
                }
                JOptionPane.showMessageDialog(null, 
                        "Vehiculo eliminado con exito"
                        , "Vehiculo: "
                        , 1
                );
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
        }else{
            JOptionPane.showMessageDialog(
                    null, 
                    "Error: No hay vehiculos por eliminar", 
                    "Error: No hay vehiculos por eliminar", 
                    0
            );
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
            if(!aux.getDato().getPlaca().equals(v.getPlaca())){
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
    public Vehiculo Consultar(String placa){
        Vehiculo respuesta = null;
        boolean esta = false;
        if (cabeza != null) {//Se verifica que la lista tenga nodos
            NodoVehiculo aux = cabeza;//Se crea un nodo para índice
            if (!aux.getDato().getPlaca().equals(placa)) {
                aux = aux.getNext();
            } else {
                respuesta = aux.getDato();
                esta = true;
            }
            while (aux != cabeza) {
                if (aux.getDato().getPlaca().equals(placa)) {
                    respuesta = aux.getDato();
                    esta = true;
                    break;
                } else {
                    aux = aux.getNext();
                }
            }
            if (!esta) {
                respuesta = null;
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
                    aux.getDato().getAnno()+"\n"+"Cilindraje: "+
                    aux.getDato().getCilindrada()+"\n"+"Pasajeros: "+
                    aux.getDato().getPasajeros()+"\n"+"Estado: "+
                    aux.getDato().getEstado()+
                    "---------------------------------------------------------";
            aux=aux.getNext();
           }
        } else{
            s+="vacia";
        }
        return s;
    }
    public Vehiculo consultarGustos(Alquiler alquiler){
       NodoVehiculo aux = cabeza;
       boolean esta= false;
       Vehiculo vehiculoReturn= null;
        if (aux != null){
            if(!validarGustos(alquiler, aux.getDato())){
                aux=aux.getNext();
            }else{
                vehiculoReturn= aux.getDato();
                esta= true;
            }
            while(aux != cabeza && !esta){ //detener la cabeza por ser cirucular
                if(validarGustos(alquiler,aux.getDato())){
                    vehiculoReturn= aux.getDato();
                    esta=true;
                    break;
                }else{
                    aux = aux.getNext();
                }
           }
           if(!esta){
                vehiculoReturn = null;
           }
        } else{
            vehiculoReturn = null;
        }
        return vehiculoReturn;
    }
    private boolean validarGustos(Alquiler alquiler, Vehiculo vehiculo){
        boolean fits = false;
        if(alquiler.getPreferenciaMarca().toLowerCase().equals(vehiculo.getMarca().toLowerCase())){
            if(alquiler.getPreferenciaModelo() == vehiculo.getModelo()){
                if(alquiler.getPreferenciaPasajeros() <= vehiculo.getPasajeros()){
                    if(vehiculo.getExtras().numIDExtras() == alquiler.getExtras().numIDExtras()){
                        fits = true;
                    }
                }
            }
        }
        return fits;
    }
   @Override
   public String toString(){
       NodoVehiculo aux = cabeza;
        String s = "-= Lista de Vehiculos=-";
        if (aux != null){
            s+="\n"+aux;
            aux=aux.getNext();
            while(aux != cabeza){
            s+=",\n"+aux;
                aux=aux.getNext();
            }
        } else {
            s += "No hay clientes";
        }
        return s;
   }
   
}
