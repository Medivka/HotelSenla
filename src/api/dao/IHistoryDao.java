package api.dao;

import model.Order;

public interface IHistoryDao {
    void save(Order order);

    Order findById(Integer id);

    void delete(Integer id);
}
