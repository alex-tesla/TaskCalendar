package com.devsav.model.dao;


import com.devsav.model.connector.Connector;
import com.devsav.model.pojo.TypeTask;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public class TypeTaskDAO {

    public TypeTaskDAO() {
    }

    public TypeTask create() {
        return null;
    }


    public TypeTask read(int key) {
        return null;
    }


    public void update(TypeTask typeTask) {

    }


    public void delete(TypeTask typeTask) {

    }


    public List<TypeTask> getAll() throws SQLException {
        Connector connector = Connector.getInstance();
        List<TypeTask> listOfType = new LinkedList<>();
        ResultSet resultSet = connector.query("select * from type_task");

        while (resultSet.next()){
            TypeTask typeTask = new TypeTask(resultSet.getLong("id"),
                    resultSet.getString("type"),
                    resultSet.getDate("date_from"),
                    resultSet.getDate("date_to"));
            listOfType.add(typeTask);
        }
        return listOfType;
    }


    public void upload() {

    }
}
