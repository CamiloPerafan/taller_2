/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.dominio;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase que implementa el metodo calculateCost para el calculo del total a
 * pagar de un carro que hace uso del servicio de parqueadero.
 */
public class CarParkingCost implements IParkingCost{

    @Override
    public double calculateCost(Vehicle vehicle, LocalTime input, LocalTime output) {

        long minutes = ChronoUnit.MINUTES.between(input, output);
        
        double result = 0.0;
        double valorFijo = 2.000;

        if (minutes <= 60) {
            return valorFijo;
        } else {
            result = valorFijo + ((minutes - 60) * 1000) / 60;
            return result;
        }
    }

  
    
}
