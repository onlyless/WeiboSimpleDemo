package Service;

import DAO.RelationDAO;
import model.User;

import java.util.List;

public class RelationService {
    private RelationDAO relationDAO;
    public RelationService(RelationDAO relationDAO) {
        this.relationDAO = relationDAO;
    }

    public List<User> getFans(User user){
        return relationDAO.getFans(user);
    }
    public List<User> getFollows(User user){
        return relationDAO.getFollows(user);
    }
}
