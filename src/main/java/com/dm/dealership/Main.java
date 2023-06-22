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

        VehicleDao vehicleDataManager = new VehicleDao(basicDataSource);

        DealershipDao dealershipDao = new DealershipDao(basicDataSource);

        SalesDao salesDao = new SalesDao(basicDataSource);


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

//        Vehicle vehicle = new Vehicle(12345678, 2015, "benz", "amg", "sedan", "black", 1010, 80000, false);
//        dealershipDao.create(vehicle);

        ///////////////////////////

//        dealershipDao.delete(12345678);


//        SalesContract salesContract = new SalesContract(10112, 23434, 2323, true);
//        salesDao.create(salesContract); // not fully working
    }

        ///////////////////////////





}