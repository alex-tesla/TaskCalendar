package com.devsav.model.dao;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.devsav.common.exception.PeopleDAOException;
import com.devsav.model.connector.Connector;
import com.devsav.model.entity.PeopleEntity;
import com.devsav.model.pojo.People;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.BatchUpdateException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
@Component
public class PeopleDAO {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("CALENDARDB");

    private static final Logger LOGGER = LogManager.getLogger(PeopleDAO.class);
    private static final String SQL_CREATE_USER =
            "INSERT INTO people (firstname, lastname, email, login, password, role) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_GET_ALL = "SELECT * FROM people";
    private static final String SQL_UPLOAD_ALL = "INSERT INTO people (id, firstname, lastname, email, login, password, is_blocked) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_FIND_USER = "SELECT * FROM people WHERE login = ? AND password = ?";
    private static final String SQL_FIND_LOGIN = "SELECT * FROM people WHERE login = ?";
    private static final String SQL_FIND_ID = "SELECT * FROM people WHERE id = ?";
    private static final String SQL_UPDATE_PEOPLE = "UPDATE people SET id=?, firstname=?, lastname=?, email=?, login=?, password=?, is_blocked=? WHERE id = ?";


    public List<People> getAllPeoples() throws PeopleDAOException {
        List<People> listOfPeople = new ArrayList<>();
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        EntityManager entityManager = EMF.createEntityManager();
        List<PeopleEntity> listOfEntity =
                entityManager.createQuery("from PeopleEntity").getResultList();
        for (PeopleEntity entity: listOfEntity) {
            mapperFactory.classMap(PeopleEntity.class, People.class);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            People people = mapper.map(entity, People.class);
            listOfPeople.add(people);
                    }
        return listOfPeople;
    }


    public void upload(List<People> listOfPeople) {

        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_UPLOAD_ALL);
            for (People people : listOfPeople) {
                ps.setLong(1, people.getId());
                ps.setString(2, people.getFirstname());
                ps.setString(3, people.getLastname());
                ps.setString(4, people.getEmail());
                ps.setString(5, people.getLogin());
                ps.setString(6, people.getPassword());
                ps.setBoolean(7, people.getIs_blocked());
                ps.addBatch();
            }
            int[] count = ps.executeBatch();
            System.out.println("Add - " + count);

        } catch (BatchUpdateException e) {
            LOGGER.error("Batch error - " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.error("SQL error - " + e.getMessage());
        }
    }


    public boolean registrationPeople(String firstName, String lastName, String email,
                                      String login, String password) throws PeopleDAOException {
        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_CREATE_USER);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, login);
            ps.setString(5, password);
            ps.setString(6, "user");
            int count = ps.executeUpdate();
            if(count > 0){
                LOGGER.debug("inserted " + count);
                return true;
            }else{
                LOGGER.debug(login + " " + password + " not inserted");
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new PeopleDAOException();
        }
        return false;

    }
    public People getUserByLoginAndPassword(String login, String password) throws PeopleDAOException {

        People people = null;
        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_FIND_USER);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                LOGGER.debug("find");
                people = new People(resultSet.getLong("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_blocked"),
                        resultSet.getString("role"));
            } else {
                LOGGER.debug(login + " " + password + " not found");
                throw new PeopleDAOException();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new PeopleDAOException();
        }
        return people;
    }

    public People getUserByLogin(String login) throws PeopleDAOException {

        LOGGER.debug("Ищем по логину в базе");

        People people = null;
        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_FIND_LOGIN);
            ps.setString(1, login);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                LOGGER.debug("find");
                people = new People(resultSet.getLong("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_blocked"),
                        resultSet.getString("role"));
            } else {
                LOGGER.debug(login + " not found");
                throw new PeopleDAOException();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new PeopleDAOException();
        }
        return people;
    }

    public People getUserById(int id) throws PeopleDAOException {
        People people = null;
        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_FIND_ID);
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                LOGGER.debug("find");
                people = new People(resultSet.getLong("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("is_blocked"),
                        resultSet.getString("role"));
            } else {
                LOGGER.debug(id + " not found");
                throw new PeopleDAOException();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new PeopleDAOException();
        }
        return people;
    }

    public boolean updatePeople(People people) throws PeopleDAOException {
        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_UPDATE_PEOPLE);

            ps.setLong(1, people.getId());
            ps.setString(2, people.getFirstname());
            ps.setString(3, people.getLastname());
            ps.setString(4, people.getEmail());
            ps.setString(5, people.getLogin());
            ps.setString(6, people.getPassword());
            ps.setBoolean(7, people.getIs_blocked());
            ps.setLong(8, people.getId());
            int count = ps.executeUpdate();
            if(count > 0){
                LOGGER.debug("inserted " + count);
                return true;
            }else{
                LOGGER.debug(" not inserted");
            }
        } catch (SQLException e) {
            LOGGER.error(e);
            throw new PeopleDAOException();
        }
        return false;
    }
}
