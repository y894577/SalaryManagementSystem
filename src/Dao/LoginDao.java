package Dao;

import People.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LoginDao {

    public User checkedUser(String userID, String userPwd) throws SQLException, ClassNotFoundException {
        User user = new User();
        //�����ݿ��ѯ����
        List<String> list = new ArrayList<>();
        list.add(userID);
        list.add(userPwd);
        String sql = "select * from user where userID = ? and userPwd = ?";
		Vector<String> v = new Vector<>();
		v = BaseDao.select(sql,list);
		//����Ϊ�գ��򴴽��µ��û����������û�
		if(v.size()!=0){
			user = UserDao.createUser(v);
            return user;
		}else {
		    return null;
        }
    }

}
