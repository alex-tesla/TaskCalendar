package com.devsav.model.connector;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;

public final class Connector {

    private static final Logger LOGGER = LogManager.getLogger(Connector.class);

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5433/calendardb";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "root";

    private Connection connection;
    private Statement statement;
    public static Connector instance;


    private Connector() {
        try {
            Class.forName(DB_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("SQL error " + e.getMessage());
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static synchronized Connector getInstance() {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    public ResultSet query(String query) throws SQLException{
        statement = instance.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public PreparedStatement preparedStatement(String query) throws SQLException {
        statement = instance.connection.createStatement();
        PreparedStatement ps = instance.connection.prepareStatement(query);
        return ps;
    }

}
