package dao;

import api.dao.IHistoryDao;
import model.History;
import model.Order;
import util.IdGenerator;

import java.util.ArrayList;

public class HistoryDao implements IHistoryDao {
    Order order;
History history;
    private ArrayList<History> historyList = new ArrayList<>();

    public ArrayList<History> getHistoryList() {
        return new ArrayList<>(historyList);
    }


    @Override
    public void save(History history) {

         historyList.add(history);
    }

    @Override
    public History findById(Integer id) {
        for (int i = 0; i < historyList.size(); i++) {
            History history = historyList.get(i);
            if (id.equals(history.getId())) {
                return history;
            } else history = null;
        }
        return history;
    }

    @Override
    public void delete(Integer id) {
        if (id < historyList.size() + 1) {
            for (int i = 0; i < historyList.size(); i++) {
                History history = historyList.get(i);
                if (id.equals(history.getId())) {
                    historyList.remove(i);
                }
            }
        } else System.out.println("order not found");
    }
}
