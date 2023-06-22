package com.dm.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SalesDao {

    SalesDao salesDao;
    private BasicDataSource basicDataSource;

    public SalesDao(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    public void create(SalesContract salesContract){
        String query = "INSERT INTO salesContract(dealershipId, vinNum, price, sold) VALUES(?, ?, ?, ?);";

        try(
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setInt(1, salesContract.getDealershipId());
            preparedStatement.setInt(2, salesContract.getVinNum());
            preparedStatement.setInt(3, salesContract.getPrice());
            preparedStatement.setBoolean(4, salesContract.isSold());

            int rows = preparedStatement.executeUpdate();
            System.out.printf("Sales Contract updated!\n", rows);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int vinNum){
        String query = "Delete From salescontracts Where vinNum=?;";

        try(
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);

        ){
            preparedStatement.setInt(1, vinNum);

            int rows = preparedStatement.executeUpdate();

            System.out.printf("Delete Successful %d\n", rows);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
