package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.List;

public class BaseDao {

    private static Connection con;

    private static PreparedStatement pstm;

    public static Vector<String> select(String sql, List<String> list) throws SQLException, ClassNotFoundException {
        Vector<String> vector = new Vector<>();
        con = new DbConnector().getConnection();
        pstm = con.prepareStatement(sql);
        for (int i = 0; i < list.size(); i++) {
            pstm.setString(i + 1, list.get(i));
        }
        //��ѯ�������
        ResultSet resultSet = pstm.executeQuery();
        //�й� ResultSet ���е����ƺ����͵���Ϣ
        ResultSetMetaData rmd = resultSet.getMetaData();
        //��ȡ�����������
        int col = rmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= col; i++) {
                vector.add(resultSet.getString(i));
            }
        }
        resultSet.close();
        pstm.close();
        con.close();
        return vector;
    }

    public static int update(String sql, List<String> list) throws SQLException {
        int updateCount = 0;
        con = new DbConnector().getConnection();
        pstm = con.prepareStatement(sql);
        for (int i = 0; i < list.size(); i++) {
            pstm.setString(i + 1, list.get(i));
        }
        updateCount = pstm.executeUpdate();
        pstm.close();
        con.close();
        System.out.println("update success");
        return updateCount;
    }

    public static Vector<Vector<String>> selectAll(String sql, List<String> list) throws SQLException {
        Vector<Vector<String>> vectors = new Vector<>();
        con = new DbConnector().getConnection();
        pstm = con.prepareStatement(sql);
        for (int i = 0; i < list.size(); i++) {
            pstm.setString(i + 1, list.get(i));
        }
        ResultSet resultSet = pstm.executeQuery();
        ResultSetMetaData rmd = resultSet.getMetaData();
        int col = rmd.getColumnCount();
        while (resultSet.next()) {
            Vector<String> vector = new Vector<>();
            for (int i = 1; i <= col; i++) {
                vector.add(resultSet.getString(i));
            }
            vectors.add(vector);
        }
        resultSet.close();
        pstm.close();
        con.close();
        return vectors;
    }


    //��������
    public static int insert(String sql, List<String> list) throws SQLException {
        con = new DbConnector().getConnection();
        try {
            pstm = con.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                pstm.setString(i + 1, list.get(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        int insertCount = 0;
        try {
            insertCount = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            pstm.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //��return 0 ��֤��û�в����κ�����
        return insertCount;
    }

}
