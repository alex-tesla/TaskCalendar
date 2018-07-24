package com.devsav.model.manager;

import com.devsav.common.exception.PeopleDAOException;
import com.devsav.model.dao.CheckListDAO;
import com.devsav.model.dao.PeopleDAO;
import com.devsav.model.dao.TaskDAO;
import com.devsav.model.dao.TypeTaskDAO;
import com.devsav.model.pojo.CheckLists;
import com.devsav.model.pojo.Peoples;
import com.devsav.model.pojo.Tasks;
import com.devsav.model.pojo.TypeTasks;
import com.devsav.parser.ParserXML;

import java.sql.SQLException;

public class DownloadFromDB {


    public DownloadFromDB() {
    }

    public void downloadPeoples() throws  PeopleDAOException {
        Peoples peoples = new Peoples();
        PeopleDAO peopleDAO = new PeopleDAO();
//        peoples.setPeoples(peopleDAO.getAllPeoples());
        ParserXML.parseToXml("people.xml", peoples, Peoples.class);
    }

    public void downloadChecks() throws SQLException {
        CheckLists checkLists = new CheckLists();
        CheckListDAO checkListDAO = new CheckListDAO();
        checkLists.setChecks(checkListDAO.getAll());
        ParserXML.parseToXml("check_list.xml", checkLists, CheckLists.class);
    }

    public void downloadTypes() throws SQLException {
        TypeTasks typeTasks = new TypeTasks();
        TypeTaskDAO typeTaskDAO = new TypeTaskDAO();
        typeTasks.setTypes(typeTaskDAO.getAll());
        ParserXML.parseToXml("type_task.xml", typeTasks, TypeTasks.class);
    }

    public void downloadTasks() throws SQLException {
        Tasks tasks = new Tasks();
        TaskDAO taskDAO = new TaskDAO();
        tasks.setTasks(taskDAO.getAll());
        ParserXML.parseToXml("task.xml", tasks, Tasks.class);
    }
}