package com.dentalcare.DentalCare.services;

import com.dentalcare.DentalCare.dao.IDao;
import com.dentalcare.DentalCare.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientService {
    private IDao<Patient> patientIDao;

    public PatientService(IDao<Patient> patientIDao) {
        this.patientIDao = patientIDao;
    }
    //get
    public IDao<Patient> getPatientDao(){
        return patientIDao;
    }
    //set
    public void setPatientDao(IDao<Patient> patientIDao){
        this.patientIDao = patientIDao;
    }
    //delegation responsability to save to the DAO
    public Patient toSave(Patient patient)  {
        return patientIDao.toSave(patient);
    }

    public Patient toSearch(Long id) {
        return patientIDao.toSearch(id);
    }
    public List<Patient> look_up(){
        return  patientIDao.look_up();
    }
}
