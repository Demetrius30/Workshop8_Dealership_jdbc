package com.dm.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();

        String username = args[0];
        String password = args[1];

        basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealership_main?reconnect=true");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        VehicleDataManager vehicleDataManager = new VehicleDataManager(basicDataSource);


//        List<Vehicle> vehicles = vehicleDataManager.getByPrice(10000, 20000);
//        System.out.println(vehicles);

        //////////////////////

//        List<Vehicle> vehicles = vehicleDataManager.getMakeNdModel("ford", "Explorer" );
//        System.out.println(vehicles);

        //////////////////////

//        List<Vehicle> vehicles = vehicleDataManager.getYear(1990, 2015);
//        System.out.println(vehicles);

        /////////////////////

//        List<Vehicle> vehicles = vehicleDataManager.getColor("red");
//        System.out.println(vehicles);

        //////////////////////

//        List<Vehicle> vehicles =  vehicleDataManager.getByMileage(1000, 200000);
//        System.out.println(vehicles);

        ////////////////////////

//        List<Vehicle> vehicles = vehicleDataManager.getType("suv");
//        System.out.println(vehicles);

        //////////////////////////

//        Vehicle vehicle = new Vehicle(1234567, 2015, "benz", "amg", "sedan", "black", 1010, 80000, false);
//        vehicleDataManager.create(vehicle);

        ///////////////////////////

        vehicleDataManager.delete(12345);


    }
}