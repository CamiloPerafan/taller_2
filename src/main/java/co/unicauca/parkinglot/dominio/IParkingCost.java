/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.dominio;

import java.time.LocalTime;

/**
 * Interfaz que define el metodo IParkingCost el cual debe ser implementado por
 * la clase que use la interfaz
 */
public interface IParkingCost { //Delivery
    double calculateCost(Vehicle vehicle,LocalTime input,LocalTime output);
}
