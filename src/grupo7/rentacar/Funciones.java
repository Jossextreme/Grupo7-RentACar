/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.rentacar;

import grupo7.rentacar.Alquileres.Alquiler;
import grupo7.rentacar.Alquileres.ColaAlquiler;
import grupo7.rentacar.Cliente.Cliente;
import grupo7.rentacar.Extras.ListaExtras;
import grupo7.rentacar.Vehiculos.ListaVehiculo;

/**
 *
 * @author geova
 */
public class Funciones {
    //
    //      Cambiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaar el public
    //
    public static ColaAlquiler alquileres = new ColaAlquiler();
    public static ListaVehiculo vehiculos = new ListaVehiculo();
    public static void solicitarAlquiler(
            Cliente cliente,
            int cantidadDias, 
            int pasajerosMinimo, 
            String preferenciaMarca, 
            int Modelo, 
            ListaExtras extras){
        if(cantidadDias >= 30){
            cliente.subirCategoria();
        }
        Alquiler alquiler = new Alquiler(
                cliente,
                cantidadDias,
                pasajerosMinimo,
                preferenciaMarca,
                Modelo,
                extras
        );
        
        alquileres.encola(alquiler);
        
    }
    public static void asignarAlquiler(){
        //vehiculos.Consultar(placa)
    }
}
