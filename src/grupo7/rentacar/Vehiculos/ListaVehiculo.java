package grupo7.rentacar.Vehiculos;

import grupo7.rentacar.Enumeraciones.Combustibles;
import javax.swing.JOptionPane;


/**
 *
 * @author geova
 */
public class ListaVehiculo {
    private NodoVehiculo cabeza;
    private NodoVehiculo ultimo;
    
    public void registrar(){
        
        //Parte de donde se solicita al usuario la info
        /*
        Combustibles[] combustibles = Combustibles.values(); 
        
        String placa = JOptionPane.showInputDialog(null, "Inserte la placa del vehículo", "Registrar: Placa", 1);
        String marca = JOptionPane.showInputDialog(null, "Inserte la marca del vehículo", "Registrar: Marca", 1);
        String modelo = JOptionPane.showInputDialog(null, "Inserte el modelo del vehículo", "Registrar: Model", 1);
        int anno = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el año del vehículo", "Registrar: Año", 1));
        String color = JOptionPane.showInputDialog(null, "Inserte el la marca del vehículo", "Registrar: Placa", 1);
        int cilindrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte la cantidad de cilindros del vehículo", "Registrar: Cilindrada", 1));
        Combustibles combustible = 
                (Combustibles) JOptionPane.showInputDialog(
                        null, 
                        "Selecciones el tipo de combustible del vehículo", 
                        "Registrar: Combustible", 
                        1, 
                        null, 
                        combustibles, 
                        combustibles[0] 
        );
        int pasajeros = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte la cantidad de pasajeros del vehículo", "Registrar: Pasajeros", 1));
        double precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el precio por día que tiene el vehículo", "Registrar: Precio", 1));
        
        Vehiculo vehiculo = new Vehiculo(combustible,placa,marca,modelo,anno,color,cilindrada,pasajeros,precio);
        */
                
        if(cabeza==null){ 
            cabeza = new NodoVehiculo(vehiculo);
            ultimo = cabeza;
            ultimo.setNext(cabeza);
            cabeza.setBack(ultimo);
        }else{
           NodoVehiculo aux = cabeza; 
           while (aux.getNext().getDato().getAnno() < vehiculo.getAnno()){
               aux=aux.getNext();
           }
           NodoVehiculo temp = new NodoVehiculo(vehiculo);
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
                if (aux.getNext().getDato().getPlaca() == placa) {
                    if (aux.getNext() == ultimo) { 
                        ultimo = aux; //Se actualiza el utlimo
                    }    
                    aux.setNext(aux.getNext().getNext()); 
                }
            }
        }
    }
   
}
