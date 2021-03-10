package api.dao;

import model.History;
import model.Order;

public interface IHistoryDao {
    void save(History history);

    History findById(Integer id);

    void delete(Integer id);
}
