package myboard.repository;

import myboard.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bungubbang
 * Date: 13. 3. 7.
 * Time: 오후 7:54
 * To change this template use File | Settings | File Templates.
 */
public class UserMemoryRepository implements UserRepository{

    private static UserMemoryRepository instance = new UserMemoryRepository();

    public static UserMemoryRepository getInstance() {
        return instance;
    }

    private List<User> users = new ArrayList<User>();

    private UserMemoryRepository() {
        User user = new User();
        user.setId("bungubbang");
        user.setPassword("skp");
        users.add(user);
    }

    @Override
    public User findById(String id) {
        for (User user : users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
