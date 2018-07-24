package com.devsav;

import org.apache.log4j.Logger;
import com.devsav.common.exception.PeopleDAOException;
import com.devsav.model.manager.DownloadFromDB;

import java.sql.SQLException;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        DownloadFromDB downloadFromDB = new DownloadFromDB();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    downloadFromDB.downloadPeoples();
                } catch (PeopleDAOException e) {
                    LOGGER.error(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    downloadFromDB.downloadChecks();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    downloadFromDB.downloadTypes();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    downloadFromDB.downloadTasks();
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }


}
