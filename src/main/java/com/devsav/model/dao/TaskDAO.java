package com.devsav.model.dao;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.devsav.model.connector.Connector;
import com.devsav.model.entity.TaskEntity;
import com.devsav.model.pojo.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
@Component
public class TaskDAO {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("CALENDARDB");

    private static final Logger LOGGER = LogManager.getLogger(TaskDAO.class);

    private static final String SQL_UPDATE_COMPLETE = "UPDATE task SET is_complete=? WHERE id = ?";

    public TaskDAO() {
    }

    public List<Task> getAll() {
        List<Task> listOfTask = new ArrayList<>();
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        EntityManager entityManager = EMF.createEntityManager();
        List<TaskEntity> listOfEntity =
                entityManager.createQuery("from TaskEntity ").getResultList();
        for (TaskEntity entity: listOfEntity) {
            mapperFactory.classMap(TaskEntity.class, Task.class);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            Task task = mapper.map(entity, Task.class);
            listOfTask.add(task);
        }
        return listOfTask;
    }

    public boolean setCompleteById(int id) {
        try {
            Connector connector = Connector.getInstance();
            PreparedStatement ps = connector.preparedStatement(SQL_UPDATE_COMPLETE);

            ps.setBoolean(1, true);
            ps.setLong(2, id);
            int count = ps.executeUpdate();
            if(count > 0){
                LOGGER.debug("inserted " + count);
                return true;
            }else{
                LOGGER.debug(" not inserted");
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    public List<Task> getTasksByType(int id_type) {
        List<Task> listOfTask = new ArrayList<>();
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        EntityManager entityManager = EMF.createEntityManager();
        Query query = entityManager.createQuery("from TaskEntity where idType = :id_type");
        query.setParameter("id_type", id_type);
        List<TaskEntity> listOfEntity = query.getResultList();

        for (TaskEntity entity: listOfEntity) {
            mapperFactory.classMap(TaskEntity.class, Task.class);
            MapperFacade mapper = mapperFactory.getMapperFacade();
            Task task = mapper.map(entity, Task.class);
            listOfTask.add(task);
        }
        return listOfTask;
    }
}
