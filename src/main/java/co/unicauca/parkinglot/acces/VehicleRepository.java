/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parkinglot.acces;

import co.unicauca.parkinglot.dominio.TypeEnum;
import co.unicauca.parkinglot.dominio.Vehicle;
import co.unicauca.parkinglot.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class VehicleRepository implements IVehicleRepository{

    private Connection conn;

    public VehicleRepository() {
        initDatabase();
    }   
    
    @Override
    public boolean save(Vehicle newVehicle) {
        try {
            //Validate product
            if (newVehicle == null || newVehicle.getPlate().isBlank() ) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Vehicle (NumberPlate,TypeVehicle,VehicleModel, VehicleBrand ) "
                    + "VALUES ( ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehicle.getPlate());
            pstmt.setString(2, newVehicle.getType().toString());         
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Vehicle> list() {
         List<Vehicle> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT NumberPlate, TypeVehicle, VehicleModel, VehicleBrand FROM Vehicle";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle newVehicle = new Vehicle();
                newVehicle.setPlate(rs.getString("NumberPlate"));
                newVehicle.setType((TypeEnum) rs.getObject("TypeVehicle"));

                vehicles.add(newVehicle);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
    
     private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	NumberPlate text PRIMARY KEY,\n"
                + "     Type text NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        // Guarda los datos en memoria RAM
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}