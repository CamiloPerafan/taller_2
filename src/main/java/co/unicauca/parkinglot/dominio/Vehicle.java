/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.dominio;

/**
 * Clase principal donde se definen todas las caracteristicas de un vehiculo
 */

public class Vehicle {
    
    private TypeEnum type;
    private String plate;       
    
//CONSTRUCTOR

    public Vehicle(String plate, TypeEnum type) {
        this.type = type;
        this.plate = plate;        
    }

    public Vehicle() {
    }


//GETTERS AND SETTERS

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
