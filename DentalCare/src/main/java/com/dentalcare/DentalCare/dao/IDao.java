package com.dentalcare.DentalCare.dao;


import java.util.List;

public interface IDao<T> {
    public T toSave(T t);

    public T toSearch(Long id);

    public List<T> look_up();

    public void delete(Long g);

}
