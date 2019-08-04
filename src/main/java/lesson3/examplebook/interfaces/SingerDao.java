package lesson3.examplebook.interfaces;

import lesson3.examplebook.model.Singer;

import java.util.List;

public interface SingerDao<T> {

    List<T> findAll();
    List<T> findAllWithAlbum();
    T findById(long id);
    T save(Singer value);
    void delete(Singer value);
}
