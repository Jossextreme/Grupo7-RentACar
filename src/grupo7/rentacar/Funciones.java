/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.rentacar;

import grupo7.rentacar.Alquileres.Alquiler;
import grupo7.rentacar.Alquileres.ColaAlquiler;
import grupo7.rentacar.Cliente.Categoria;
import grupo7.rentacar.Cliente.Cliente;
import grupo7.rentacar.Cliente.ListaCliente;
import grupo7.rentacar.Enumeraciones.EstadoAlquiler;
import grupo7.rentacar.Enumeraciones.EstadoVehiculo;
import grupo7.rentacar.Extras.ListaExtras;
import grupo7.rentacar.Vehiculos.ListaVehiculo;
import grupo7.rentacar.Vehiculos.Vehiculo;
import javax.swing.JOptionPane;
import grupo7.rentacar.Enumeraciones.Combustibles;

/**
 *
 * @author geova
 */
public class Funciones {

    private ColaAlquiler alquileres = new ColaAlquiler();
    private ListaVehiculo vehiculos = new ListaVehiculo();
    private ListaCliente clientes = new ListaCliente();
    private ListaExtras extras = new ListaExtras();
    
    //
    //      Funciones cliente
    //
    public void crearCliente(
            String nombre, 
            String fecha, 
            int cedula,
            String correo, 
            Categoria categoria
    ){
 
        Cliente clienteN = new Cliente();

        clienteN.setNombre(nombre);
        clienteN.setFechaNaci(fecha);
        clienteN.setCedula(cedula);
        clienteN.setCorreoElec(correo);
        clienteN.setCategoria(categoria);

        this.clientes.Insertar(clienteN);
        //JOptionPane.showMessageDialog(null, clientes.Listar());
    }
    public void eliminarCliente(int cedula){
        try {
            clientes.Eliminar(cedula);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error: Cliente no encontrado",
                    "Error: Cliente no encontrado",
                    0
            );
        }


    }
    
    public Cliente buscarCliente(int cedula){
        return clientes.Consultar(cedula);
    }
    public void modificarCliente(Cliente cliente){
        clientes.Modificar(cliente);
    }
    
    //
    //      Funciones Vehículo
    //
    public void ingresarVehiculo(String placa, String marca,
            int modelo, int anno, String color, int cilindrada,
            int pasajeros, double precio, ListaExtras ex, Combustibles comb) {

        Vehiculo vehiculoN = new Vehiculo();

        vehiculoN.setPlaca(placa);
        vehiculoN.setMarca(marca);
        vehiculoN.setModelo(modelo);
        vehiculoN.setAnno(anno);
        vehiculoN.setColor(color);
        vehiculoN.setCilindrada(cilindrada);
        vehiculoN.setPasajeros(pasajeros);
        vehiculoN.setPrecio(precio);
        vehiculoN.setEstado(EstadoVehiculo.Disponible);
        vehiculoN.setExtras(ex);
        vehiculoN.setCombustible(comb);

        this.vehiculos.registrar(vehiculoN);
    }
    public void modificarVehiculo(Vehiculo vehiculo){
        vehiculos.Modificar(vehiculo);
    }
    public Vehiculo buscarVehiculo(String Placa){
        return vehiculos.Consultar(Placa);
    }
    public void eliminarVehiculo(String placa){
        try{
            vehiculos.Eliminar(placa);
        }catch(Exception ex){
                    JOptionPane.showMessageDialog(
                    null,
                    "Error: Vehiculo no encontrado",
                    "Error: Vehiculo no encontrado",
                    0
            ); 
        }
    }
    
    //
    //      Funciones Alquiler
    //
    public void solicitarAlquiler(
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
    
    
    public Vehiculo asignarAlquiler(){
        Alquiler alquiler = alquileres.atiende();
        Vehiculo vehiculoAsignado = vehiculos.consultarGustos(alquiler);
        
        if(vehiculoAsignado != null){
            vehiculoAsignado.setEstado(EstadoVehiculo.Alquilado);
             alquiler.setEstado(EstadoAlquiler.Procesado);
        
            alquiler.setMontoFinal(
                    (vehiculoAsignado.getPrecio() * alquiler.getTiempo()
                            )*1.13
            );
            if(alquiler.getMontoFinal()>= 70000){
                alquiler.getC().subirCategoria();
            }
            JOptionPane.showMessageDialog(
                    null, 
                    "¡Alquiler completado satisfactoriamente!", 
                    "Alquiler: Procesado", 
                    1
            );
        }else{
            alquiler.setEstado(
                    EstadoAlquiler.Rechazado
            );
            JOptionPane.showMessageDialog(
                    null, 
                    "No hay vehiculos disponibles a su criterio", 
                    "Alquiler: Rechazado", 
                    0
            );
        }
       
        return vehiculoAsignado;
    }

    //
    //      Getters & Setters
    //
    public ColaAlquiler getAlquileres() {
        return alquileres;
    }

    public ListaVehiculo getVehiculos() {
        return vehiculos;
    }

    public ListaCliente getClientes() {
        return clientes;
    }

    public ListaExtras getExtras() {
        return extras;
    }
}
