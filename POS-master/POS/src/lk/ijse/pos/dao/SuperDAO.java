package lk.ijse.pos.dao;

import java.util.ArrayList;

public interface SuperDAO<T,ID> {
    boolean add(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID id) throws Exception;

    T search(ID id) throws Exception;

    ArrayList<T> getAll() throws Exception;

}