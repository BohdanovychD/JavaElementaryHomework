package lesson_22.service;

import lesson_22.dao.StatusDao;
import lesson_22.dao.StatusDaoImpl;
import lesson_22.model.Status;
import org.apache.log4j.Logger;

public class StatusServiceImpl implements StatusService {

    Logger logger = Logger.getLogger(StatusDaoImpl.class);

    @Override
    public void save(Status status) {
        logger.debug(status.toString());
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
        logger.debug(status.toString());
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
        logger.debug(status.toString());
        if(status.getAlias().isBlank()) {
            return;
        }
        StatusDao statusDao = new StatusDaoImpl();
        status.setId(status.getId());
        statusDao.delete(status);
    }

    @Override
    public Status findById(long id) {
        logger.debug("Information from status.findId");
        StatusDao statusDao = new StatusDaoImpl();
        return statusDao.findById(id);
    }
}
