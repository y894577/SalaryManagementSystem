package Dao;

import People.User;
import com.sun.source.tree.NewArrayTree;
import viewItem.UserInfoCreate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

public class UserDao {

    private User user;

    //查询用户
    public User getUser(String userName) throws SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        list.add(userName);
        String sql = "select * from user where userName = ?";
        Vector<String> v = null;
        v = BaseDao.select(sql, list);
        System.out.println(v);
        if (v != null) {
            user = createUser(v);
        }

        return user;
    }

    public static Vector<User> getUsers(List<String> userIDList) throws SQLException {
        Vector<User> users = new Vector<>();
        String sql = "select * from user";
        List<String> list = new ArrayList<>();
        //执行查询所有操作
        Vector<Vector<String>> vectors = BaseDao.selectAll(sql, list);
        User user = new User();
        //将查询返回的vectors集合遍历加入user集合
        for (Vector<String> v : vectors) {
            user = createUser(v);
            users.add(user);
        }
        return users;
    }

    public int addUser(User user) throws SQLException {
        List<String> list = new ArrayList<>();
        list.add(user.getUserID());
        list.add(user.getUserName());
        list.add(user.getUserPwd());
        list.add(user.getDepartment());
        list.add(user.getPosition());
        list.add(user.getTitle());
        list.add(user.getFullTime());
        list.add(user.getManager());
        list.add(user.getTeaching());
        list.add(user.getAdmin());
        String sqllist = "userID,userName,userPwd,department,position,title,isFullTime,isManager,isTeaching,isAdmin";
        String sql = "insert into user(" + sqllist + ") values (?,?,?,?,?,?,?,?,?,?)";
        return BaseDao.insert(sql, list);
    }


    public int deleteUser(User user) {
        return 0;
    }

    public int updateUser(User user) throws SQLException {
        List<String> list = new ArrayList<>();
        list.add(user.getUserName());
        list.add(user.getUserPwd());
        list.add(user.getDepartment());
        list.add(user.getPosition());
        list.add(user.getTitle());
        list.add(user.getAdmin());
        list.add(user.getTeaching());
        list.add(user.getManager());
        list.add(user.getFullTime());
        list.add(user.getUserID());
        String sqllist = "userName=?, userPwd=?, department=?, position=?, title=?, isAdmin=?, isTeaching=?, isManager=?, isFullTime=?";
        String sql = "update user set "+ sqllist+" where userID = ?";
        int updateCount = 0;
        updateCount = BaseDao.update(sql,list);
        return updateCount;
    }


    public List getUserAttributes(User user) {
        return null;
    }

    public int insert(User user) {
        return 0;
    }

    public static User createUser(Vector<String> v){
        User user = new User();
        user.setUserID(v.get(0));
        user.setUserName(v.get(1));
        user.setUserPwd(v.get(2));
        user.setDepartment(v.get(3));
        user.setPosition(v.get(4));
        user.setTitle(v.get(5));
        user.setFullTime(v.get(6));
        user.setManager(v.get(7));
        user.setAdmin(v.get(8));
        user.setTeaching(v.get(9));
        return user;
    }

}
