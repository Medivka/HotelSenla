package com.inputOutput;

import com.dao.ServiceDao;
import com.fasad.FasadService;
import com.model.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ServiceInputOutput {

    private static ServiceInputOutput instance;
    private String servicePathInFile = "src/main/java/com/hdd/services.dat";

    public static ServiceInputOutput getInstance() {
        if (instance == null) {
            instance = new ServiceInputOutput();
        }
        return instance;
    }

    public void writeInFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(servicePathInFile))) {
            oos.writeObject(ServiceDao.getInstance().getServiceList());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(servicePathInFile))) {
            ServiceDao.getInstance().setServiceList((ArrayList<Service>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
