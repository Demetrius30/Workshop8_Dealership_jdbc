package com.dm.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DealershipDao {

    DealershipDao dealershipDao;

    private BasicDataSource basicDataSource;

    public DealershipDao(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public void create(Vehicle vehicle){
        String query = "INSERT INTO vehicles(vinNum, year, make, model, vehicleType, color, odometer, price, sold)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";

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
