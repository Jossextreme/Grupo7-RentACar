/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.rentacar.Alquileres;

import grupo7.rentacar.Cliente.Cliente;
import grupo7.rentacar.Enumeraciones.EstadoAlquiler;
import grupo7.rentacar.Extras.ListaExtras;
import grupo7.rentacar.Vehiculos.Vehiculo;

/**
 *
 * @author geova
 */
public class Alquiler {
    private Cliente c;
    private Vehiculo v;
    private int tiempo;
    private int preferenciaPasajeros;
    private String preferenciaMarca;
    private int preferenciaModelo;
    private ListaExtras extras;
    private EstadoAlquiler estado;
    private double montoFinal;

    public Alquiler(
            Cliente c,  
            int tiempo, 
            int preferenciaPasajeros, 
            String preferenciaMarca, 
            int preferenciaModelo, 
            ListaExtras extras) {
        this.c = c;
        this.tiempo = tiempo;
        this.preferenciaPasajeros = preferenciaPasajeros;
        this.preferenciaMarca = preferenciaMarca;
        this.preferenciaModelo = preferenciaModelo;
        this.extras = extras;
        
        this.estado = EstadoAlquiler.Registrado;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public Vehiculo getV() {
        return v;
    }

    public void setV(Vehiculo v) {
        this.v = v;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getPreferenciaPasajeros() {
        return preferenciaPasajeros;
    }

    public void setPreferenciaPasajeros(int preferenciaPasajeros) {
        this.preferenciaPasajeros = preferenciaPasajeros;
    }

    public String getPreferenciaMarca() {
        return preferenciaMarca;
    }

    public void setPreferenciaMarca(String preferenciaMarca) {
        this.preferenciaMarca = preferenciaMarca;
    }

    public int getPreferenciaModelo() {
        return preferenciaModelo;
    }

    public void setPreferenciaModelo(int preferenciaModelo) {
        this.preferenciaModelo = preferenciaModelo;
    }

    public ListaExtras getExtras() {
        return extras;
    }

    public void setExtras(ListaExtras extras) {
        this.extras = extras;
    }

    public EstadoAlquiler getEstado() {
        return estado;
    }

    public void setEstado(EstadoAlquiler estado) {
        this.estado = estado;
    }
    @Override
    public String toString() {
        return 
                "Persona="+getC().getNombre()+
                "\n"+ "Categor??a="+getC().getCategoria()+
                "\n"+ "Cantidad Minima Pasajeros="+preferenciaPasajeros+
                "\n"+ "Preferencia marca ="+preferenciaMarca+
                "\n"+ "Preferencia Modelo="+preferenciaModelo+
                "\n"+ "Extras="+extras+
                "\n"+ "Estado="+estado+"\n----------------\n\n";
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }
}
