package com.devsav.model.dao;


import com.devsav.model.connector.Connector;
import com.devsav.model.pojo.CheckList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public class CheckListDAO {

    public CheckListDAO() {
    }

    public CheckList create() {
        return null;
    }


    public CheckList read(int key) {
        return null;
    }


    public void update(CheckList check) {

    }


    public void delete(CheckList check) {

    }


    public List<CheckList> getAll() throws SQLException {
        Connector connector = Connector.getInstance();
        List<CheckList> listOfCheck = new LinkedList<>();
        ResultSet resultSet = connector.query("select * from check_list");

        while (resultSet.next()){
            CheckList checkList = new CheckList(resultSet.getLong("id"),
                    resultSet.getLong("id_task"),
                    resultSet.getString("description"),
                    resultSet.getBoolean("is_complete"));

            listOfCheck.add(checkList);
        }
        return listOfCheck;
    }


    public void upload() {

    }
}
