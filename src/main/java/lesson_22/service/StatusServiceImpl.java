package lesson_22.service;

import lesson_22.dao.StatusDao;
import lesson_22.dao.StatusDaoImpl;
import lesson_22.model.Status;

public class StatusServiceImpl implements StatusService {
    @Override
    public void save(Status status) {
        StatusDao statusDao = new StatusDaoImpl();

        if (status.getAlias().isBlank()) {
            return;
        }
        status.setAlias(status.getAlias());
        status.setDescription(status.getDescription());

        statusDao.save(status);
    }

    @Override
    public void update(Status status) {
        StatusDao statusDao = new StatusDaoImpl();

        if(status.getAlias().isBlank()) {
            return;
        }
        status.setAlias(status.getAlias());
        status.setDescription(status.getDescription());
        statusDao.update(status);
    }

    @Override
    public void delete(Status status) {
        if(status.getAlias().isBlank()) {
            return;
        }
        StatusDao statusDao = new StatusDaoImpl();
        status.setId(status.getId());
        statusDao.delete(status);
    }

    @Override
    public Status findById(long id) {
        StatusDao statusDao = new StatusDaoImpl();
        return statusDao.findById(id);
    }
}
