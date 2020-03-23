package Dao;

import People.Parameters;
import People.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ParaDao {
    //创建参数
    public int setParameters(Parameters parameters) throws SQLException {
        List<String> list = new ArrayList<>();
        list.add(parameters.getUser().getUserID());
        list.add(String.valueOf(parameters.getClassNum()));
        list.add(String.valueOf(parameters.getStudentNum()));
        list.add(String.valueOf(parameters.getLivingPara()));
        list.add(String.valueOf(parameters.getTitlePara()));
        list.add(String.valueOf(parameters.getPhonePara()));
        list.add(String.valueOf(parameters.getOtherPara()));
        list.add(parameters.getCalculatePara());
        String sqllist = "userID,classNum,studentNum,livingPara,titlePara,phonePara,otherPara,calculatePara";
        String sql = "insert into parameters (" + sqllist + ") values (?,?,?,?,?,?,?,?)";
        return BaseDao.insert(sql, list);
    }


    //    public int updateParameters(String flag, Parameters parameters) throws SQLException {
//        String sql = "update parameters set " + flag + "='" + 0 + "' where userID = " + parameters.getUser().getUserID();
//        List<String> list = new ArrayList<>();
//        int updateCount = 0;
//        updateCount = BaseDao.update(sql, list);
//        return updateCount;
//    }
    //更新参数
    public static int updateParameters(Parameters parameters, List<String> list) throws SQLException {
        list.add(String.valueOf(parameters.getClassNum()));
        list.add(String.valueOf(parameters.getStudentNum()));
        list.add(String.valueOf(parameters.getLivingPara()));
        list.add(String.valueOf(parameters.getTitlePara()));
        list.add(String.valueOf(parameters.getPhonePara()));
        list.add(String.valueOf(parameters.getOtherPara()));
        list.add(parameters.getCalculatePara());
        list.add(parameters.getUser().getUserID());

        String sqllist = "classNum=?, studentNum=?, livingPara=?, titlePara=?, phonePara=?, otherPara=?, calculatePara=?";
        String sql = "update parameters set " + sqllist + " where userID = ?";
        int updateCount = 0;
        updateCount = BaseDao.update(sql, list);
        return updateCount;
    }

    //获取参数
    public Parameters getParameters(String userID) throws SQLException, ClassNotFoundException {
        Parameters parameters = null;
        List<String> list = new ArrayList<>();
        list.add(userID);
        String sql = "select * from parameters where userID = ?";
        Vector<String> v = null;
        v = BaseDao.select(sql, list);
        System.out.println(v);
        if (v != null) {
            parameters = new Parameters();
            parameters.setClassNum(Integer.parseInt(v.get(1)));
            parameters.setStudentNum(Integer.parseInt(v.get(2)));
            parameters.setLivingPara(Float.parseFloat(v.get(3)));
            parameters.setTitlePara(Float.parseFloat(v.get(4)));
            parameters.setPhonePara(Float.parseFloat(v.get(5)));
            parameters.setOtherPara(Float.parseFloat(v.get(6)));
            parameters.setCalculatePara(v.get(7));
        }

        return parameters;
    }
}
