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
        List<Vehicle> vehiclesPrice = new ArrayList<>();

        String query = "Select * From vehicles Where price Between ? And ?;";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, minRange);
            preparedStatement.setInt(2, maxRange);
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

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price);

                    vehiclesPrice.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiclesPrice;
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

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price);

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

                    Vehicle vehicle = new Vehicle(vinNum, year, make, model, vehicleType, color, odometer, price);

                    vehicleYear.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicleYear;
    }
}
