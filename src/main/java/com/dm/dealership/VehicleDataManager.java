package com.dm.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDataManager {

    private BasicDataSource basicDataSource;
    public VehicleDataManager(BasicDataSource basicDataSource){
        this.basicDataSource = basicDataSource;}

    public List<Vehicle> getByPrice(){
        List<Vehicle> vehiclesPrice = new ArrayList<>();

        String query = "Select * From vehicles Where price;";

        try(
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while(resultSet.next()){
                int vin = resultSet.getInt("vin");
                int year = resultSet.getInt("year");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String vehicleType = resultSet.getString("vehicleType");
                String color = resultSet.getString("color");
                int odometer = resultSet.getInt("odometer");
                double price = resultSet.getDouble("price");

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                vehiclesPrice.add(vehicle);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return vehiclesPrice;
    }


}
