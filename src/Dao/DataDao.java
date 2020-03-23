package Dao;

import com.sun.jdi.FloatValue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class DataDao {
    static String[][] t_data = new String[20][];

    public String[][] get_t_dates(String sql) throws SQLException {
        for (int i = 0; i < 20; i++) {
            t_data[i] = new String[8];
        }
        List<String> list = new ArrayList<>();
        Vector<Vector<String>> vectors = new Vector<>();
        vectors = BaseDao.selectAll(sql, list);
        int rows = vectors.size();
        int i = 0;
        for (Vector<String> x : vectors) {
            float sum = 0;
            for (int j = 0; j < 7; j++) {
                if (j != 0 && j != 6)
                    sum += Float.parseFloat(x.get(j));
                t_data[i][j] = String.valueOf(x.get(j));
            }
            t_data[i][7] = String.valueOf(sum);
            i++;
        }
        return t_data;
    }

    public void add_t_dates() {
        //定时发送
        String sqllist = "";
        String sql = "";
        List<String> list = new ArrayList<>();
    }
}
