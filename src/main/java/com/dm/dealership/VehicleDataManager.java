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

    public VehicleDataManager(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public List<Vehicle> getByPrice(int minRange, int maxRange) {
        List<Vehicle> vehiclesPrice = new ArrayList<>(); // creating an empty arrayList to hold vehicles

        String query = "Select * From vehicles Where price Between ? And ?;"; //giving query to execute

        try (
                Connection connection = this.basicDataSource.getConnection(); // using try to get connection and matching query
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, minRange); // setting the query / prepare statement
            preparedStatement.setInt(2, maxRange);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery(); // getting the result of the query and executing the query
            ) {

                while (resultSet.next()) {
                    int vinNum = resultSet.getInt("vinNum");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String vehicleType = resultSet.getString("vehicleType");
                    String color = resultSet.getString("color");
                    int odometer = resultSet.getInt("odometer");
                    int price = resultSet.getInt("price");
                    boolean sold = resultSet.getBoolean("sold"); // setting the column/rows

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price, sold); // creating new instance of vehicle with the column / row themes

                    vehiclesPrice.add(vehicle); // adding the vehicle price to "vehicles"
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // surrounding with a catch to catch errors
        }

        return vehiclesPrice; // returning the price of vehicle
    }


    public List<Vehicle> getMakeNdModel(String makeResult, String modelResult) {
        List<Vehicle> vehicleMakeNdModel = new ArrayList<>();

        String query = "Select * From Vehicles Where make=? AND model=?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, makeResult);
            preparedStatement.setString(2, modelResult);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vinNum = resultSet.getInt("vinNum");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String vehicleType = resultSet.getString("vehicleType");
                    String color = resultSet.getString("color");
                    int odometer = resultSet.getInt("odometer");
                    int price = resultSet.getInt("price");
                    boolean sold = resultSet.getBoolean("sold");

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price, sold);

                    vehicleMakeNdModel.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleMakeNdModel;
    }

    public List<Vehicle> getYear(int minYear, int maxYear) {
        List<Vehicle> vehicleYear = new ArrayList<>();

        String query = "Select * From vehicles Where year Between ? And ?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, minYear);
            preparedStatement.setInt(2, maxYear);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vinNum = resultSet.getInt("vinNum");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String vehicleType = resultSet.getString("vehicleType");
                    String color = resultSet.getString("color");
                    int odometer = resultSet.getInt("odometer");
                    int price = resultSet.getInt("price");
                    boolean sold = resultSet.getBoolean("sold");

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price, sold);

                    vehicleYear.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleYear;
    }

    public List<Vehicle> getColor(String colorResult) {
        List<Vehicle> vehicleColor = new ArrayList<>();

        String query = "Select * From vehicles Where color=?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, colorResult);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vinNum = resultSet.getInt("vinNum");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String vehicleType = resultSet.getString("vehicleType");
                    String color = resultSet.getString("color");
                    int odometer = resultSet.getInt("odometer");
                    int price = resultSet.getInt("price");
                    boolean sold = resultSet.getBoolean("sold");

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price, sold);

                    vehicleColor.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleColor;
    }

    public List<Vehicle> getByMileage(int minMileage, int maxMileage) {
        List<Vehicle> vehiclesMileage = new ArrayList<>();

        String query = "Select * From vehicles Where odometer Between ? And ?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, minMileage);
            preparedStatement.setInt(2, maxMileage);

            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vinNum = resultSet.getInt("VinNum");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String vehicleType = resultSet.getString("vehicleType");
                    String color = resultSet.getString("color");
                    int odometer = resultSet.getInt("odometer");
                    int price = resultSet.getInt("price");
                    boolean sold = resultSet.getBoolean("sold");

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price, sold);

                    vehiclesMileage.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclesMileage;
    }

    public List<Vehicle> getType(String typeResult) {
        List<Vehicle> typeForVehicle = new ArrayList<>();

        String query = "Select * From vehicles Where vehicleType=?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, typeResult);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    int vinNum = resultSet.getInt("vinNum");
                    int year = resultSet.getInt("year");
                    String make = resultSet.getString("make");
                    String model = resultSet.getString("model");
                    String vehicleType = resultSet.getString("vehicleType");
                    String color = resultSet.getString("color");
                    int odometer = resultSet.getInt("odometer");
                    int price = resultSet.getInt("price");
                    boolean sold = resultSet.getBoolean("sold");

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price, sold);

                    typeForVehicle.add(vehicle);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return typeForVehicle;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void create(Vehicle vehicle){
        String query = "INSERT INTO vehicles(vinNum, year, make, model, vehicleType, color, odometer, price, sold) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try(
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1, vehicle.getVinNum());
            preparedStatement.setInt(2, vehicle.getYear());
            preparedStatement.setString(3, vehicle.getMake());
            preparedStatement.setString(4, vehicle.getModel());
            preparedStatement.setString(5, vehicle.getVehicleType());
            preparedStatement.setString(6, vehicle.getColor());
            preparedStatement.setInt(7, vehicle.getOdometer());
            preparedStatement.setInt(8, vehicle.getPrice());
            preparedStatement.setBoolean(9, vehicle.isSold());

            int rows = preparedStatement.executeUpdate();
            System.out.printf("Rows updated %d\n", rows);
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void delete(int vinNum){
        String query = "Delete From vehicles Where vinNum=?;";

        try(
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1, vinNum);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Row Deleted %d\n", rows);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


}
