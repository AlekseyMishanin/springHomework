package lesson3.dzspring.interfaces;

import java.util.List;

public interface CommandDAO<T> {

    void persist (T value);
    void merge (T value);
    T find (String id);
    void remove (String id);
    List<T> findAll();
    void removeAll();
    T getById(String id);
    List<T> getSortedByName();
}
