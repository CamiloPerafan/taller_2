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
 * pagar de una moto que hace uso del servicio de parqueadero.
 */
public class MotoParkingCost implements IParkingCost {


    @Override
    public double calculateCost(Vehicle vehicle,LocalTime input,LocalTime output) {
        long minutes = ChronoUnit.MINUTES.between(input, output);// Obtener el tiempo completo en minutos
        
        double result = 0.0;
        double valorFijo = 1.000;
        double valorMinuto = 500/60;
        
        if(minutes <= 60){ //si es por una hora o menos de la hora
           return valorFijo;
        }else{ //mas de una hora
            double valRedondeo=((minutes - 60)* valorMinuto);
            double parteDecimal= valRedondeo%1;
            double parteEntera= valRedondeo-parteDecimal;
            double numero = valRedondeo*10;            
            if(numero%1==0){ //es entero 
                result = valorFijo + valRedondeo;
                return result;
            }else{  //es decimal
                int redondeo= (int) Math.ceil(numero); //aplicando redondeo
                result = valorFijo + parteEntera+(redondeo*100);
                return Math.ceil(result);
            }           
        }
    }    
}
