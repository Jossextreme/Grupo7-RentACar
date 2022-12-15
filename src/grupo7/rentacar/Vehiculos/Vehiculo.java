/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.rentacar.Vehiculos;

import grupo7.rentacar.Enumeraciones.Combustibles;
import grupo7.rentacar.Enumeraciones.EstadoVehiculo;
import grupo7.rentacar.Extras.ListaExtras;

/**
 *
 * @author geova
 */
public class Vehiculo {
    private EstadoVehiculo estado;
    private Combustibles combustible;
    private String placa;
    private String marca;
    private int modelo;
    private int anno;
    private String color;
    private int cilindrada;
    private int pasajeros;
    private double precio;
    private ListaExtras extras;

    public Vehiculo(Combustibles combustible, String placa, String marca, 
int modelo, int anno, String color, int cilindrada, int pasajeros,
double precio, ListaExtras ex) {
        this.combustible = combustible;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anno = anno;
        this.color = color;
        this.cilindrada = cilindrada;
        this.pasajeros = pasajeros;
        this.precio = precio;
        this.extras = ex;
        //Estado por defauls sería Disponible
        estado = EstadoVehiculo.Disponible;
    }
    public Vehiculo(){
        
    }
    
    public void setExtras(ListaExtras ex){
        this.extras = ex;
    }
    
    public ListaExtras getExtras(){
        return extras;
    }
    
    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public Combustibles getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustibles combustible) {
        this.combustible = combustible;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Marca: "+getMarca()+
                "\n"+"Modelo: "+getModelo()+
                "\n"+"Placa: "+getPlaca()+
                "\n"+"Año: "+getAnno()+
                "\n"+"Cilindraje: "+getCilindrada()+
                "\n"+"Pasajeros: "+getPasajeros()+
                "\n"+"Estado: "+getEstado()+
                "\n"+"Combustible: "+getCombustible()+
                "\n"+"Extras: "+getExtras()+
                "\n------------------------------------------------------";
    }
}
