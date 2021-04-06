package lesson_22.service;

import lesson_22.model.Status;

public interface StatusService {
    void save(Status status);

    void update(Status status);

    void delete(Status status);

    Status findById(long id);
}
