package com.dentalcare.DentalCare.dao.impl;

import com.dentalcare.DentalCare.dao.IDao;
import com.dentalcare.DentalCare.domain.Patient;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacientDaoH2 implements IDao<Patient> {


    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    private final static String DB_URL = "jdbc:h2:~/dataBase2;INIT=RUNSCRIPT FROM 'create.sql'";

    private final static String DB_USER ="root";

    private final static String DB_PASSWORD = "";

    final  static Logger log = Logger.getLogger(PacientDaoH2.class);

    @Override
    public Patient toSave(Patient patient) {

        log.debug("New register was succesfull: " + patient.toString());

        Connection connection = null;
        PreparedStatement preparedStatement=null;

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Create a sentence
            preparedStatement = connection.prepareStatement("INSERT INTO patient values(?,?,?,?,?,?)");
            preparedStatement.setLong(1,patient.getId());
            preparedStatement.setString(2,patient.getName());
            preparedStatement.setString(3,patient.getLastname());
            preparedStatement.setString(4,patient.getAddress());
            preparedStatement.setInt(5,patient.getDni());
            preparedStatement.setDate(6, (java.sql.Date) patient.getDischargeDate());

            preparedStatement.executeUpdate();
            preparedStatement.close();


        }catch (SQLException | ClassNotFoundException throwables){
           throwables.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient toSearch(Long id) {
        log.debug(" Searching id : " + id );

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Patient patient = null;

        //1 Up  driver and connection

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Create a sentence
            preparedStatement = connection.prepareStatement("SELECT * FROM patient WHERE id=?");
            preparedStatement.setLong(1,id);

            //3 Execute
            ResultSet result = preparedStatement.executeQuery();

            // 4 evaluation

            while(result.next()){
                Long idPatient = result.getLong("id");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                String address = result.getString("address");
                Integer dni = result.getInt("dni");
                Date dischargeDate=result.getDate("dischargeDate");
                patient = new Patient();
                patient.setId(idPatient);
                patient.setName(name);
                patient.setLastname(lastName);
                patient.setAddress(address);
                patient.setDni(dni);
                patient.setDischargeDate(dischargeDate);
            }

            preparedStatement.close();


        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return patient;
    }

    @Override
    public List<Patient> look_up() {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Patient> patients = new ArrayList();

        //1 Up  driver and connection
        //log.debug(" List of patient : " + List<patient> );
        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Create a sentence
            preparedStatement = connection.prepareStatement("SELECT * FROM patient");

            //3 Execute
            ResultSet result = preparedStatement.executeQuery();

            // 4 evaluation

            while(result.next()){
                Long idPatient = result.getLong("id");
                String name = result.getString("name");
                String lastName = result.getString("lastName");
                String address = result.getString("address");
                Integer dni = result.getInt("dni");
                Date dischargeDate=result.getDate("dischargedate");

                Patient patient = new Patient();
                patient.setId(idPatient);
                patient.setName(name);
                patient.setLastname(lastName);
                patient.setAddress(address);
                patient.setDni(dni);
                patient.setDischargeDate(dischargeDate);

                patients.add(patient);
            }

            preparedStatement.close();


        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
        return patients;
    }

    @Override
    public void delete(Long id) {
        log.debug("Register id " + id + " was deleted" );
        Connection connection = null;
        PreparedStatement preparedStatement=null;
        try {
            //Up JDBC Driver
            Class.forName(DB_JDBC_DRIVER);
            //Connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //Prepared statement for delete a register
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM patient WHERE id=?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
