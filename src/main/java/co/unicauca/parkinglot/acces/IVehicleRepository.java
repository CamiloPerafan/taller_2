/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.acces;

import co.unicauca.parkinglot.dominio.Vehicle;
import java.util.List;
/**
 * Interface que permite guardar los diferentes vehiculos
 * en una lista.
 */
public interface IVehicleRepository {
     boolean save(Vehicle newProduct);

    List<Vehicle> list();
}
