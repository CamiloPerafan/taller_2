/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.dominio;

import co.unicauca.parkinglot.dominio.IParkingCost;
import co.unicauca.parkinglot.dominio.Vehicle;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Clase que implementa el metodo calculateCost para el calculo del total a
 * pagar de un camion que hace uso del servicio de parqueadero.
 */
public class TruckParkingCost implements IParkingCost{

    @Override
    public double calculateCost(Vehicle vehicle, LocalTime input, LocalTime output) {

        long minutes = ChronoUnit.MINUTES.between(input, output);
        double result = 0.0;
        double valorFijo = 15.000;
        
        int rand1 = (int) (Math.random() * 1000 + 1);
        int rand2 = (int) (Math.random() * 1000 + 1);

        if (rand2 == rand1) {
            System.out.println("FELICIDADES!!! Ganaste un servicio de parqueadero gratis.");
            return result;
        }
        if (minutes <= 720) {
            return 10000;
        } else {
            result = (minutes * valorFijo) / 60;
            return result;
        }
    }
    
}
