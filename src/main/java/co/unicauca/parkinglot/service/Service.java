/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.service;

import co.unicauca.parkinglot.acces.IVehicleRepository;
import co.unicauca.parkinglot.dominio.IParkingCost;
import co.unicauca.parkinglot.dominio.ParkingCostFactory;
import co.unicauca.parkinglot.dominio.Vehicle;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servicio es la clase que concentra la lógica de negocio
 *
 * @author libardo Docs Sqlite; https://www.sqlitetutorial.net/sqlite-java/
 */

/**
 * Servicio es la clase que concentra la lógica de negocio
 *
 * @author libardo Docs Sqlite; https://www.sqlitetutorial.net/sqlite-java/
 */
public class Service {
    private IVehicleRepository repository;
     
    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }
    
    public long calculateParkingCost(Vehicle vehiculo, LocalDateTime input, LocalDateTime output) {
        if (vehiculo == null) {
            return -1;
        }

        IParkingCost parkingcost = ParkingCostFactory.getInstance().getDelivery(vehiculo.getType());
        long result = (long) parkingcost.calculateCost(vehiculo, LocalTime.MIN, LocalTime.MAX);
        return result;
    }
       
    public boolean saveVehicle(Vehicle newVehicle) {

        //Validate product
        if (newVehicle == null ||  newVehicle.getPlate().isBlank()) {
            return false;
        }

        repository.save(newVehicle);
        return true;
    }
    
    public List<Vehicle> listVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles = repository.list();;

        return vehicles;

    }
}
