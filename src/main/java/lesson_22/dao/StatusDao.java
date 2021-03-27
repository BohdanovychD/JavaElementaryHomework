package lesson_22.dao;

import lesson_22.model.Status;

public interface StatusDao {
    void save(Status status);

    void update(Status status);

    void delete(Status status);

    Status findById(long id);

}
