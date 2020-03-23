package Dao;

import People.Payment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PaymentDao {
    //更新工资
    public int updatePayment(String flag, Payment payment) throws SQLException {
        float salary = 0;
        switch (flag) {
            case "paymentTitle":
                salary = payment.getPaymentTitle();
                break;
            case "paymentBaseTitle":
                salary = payment.getPaymentBaseTitle();
                break;
            case "paymentClass":
                salary = payment.getPaymentClass();
                break;
            case "paymentTemporary":
                salary = payment.getPaymentTemporary();
                break;
            case "paymentOther":
                salary = payment.getPaymentOther();
                break;
        }
        String sql = "update payment set" + flag + "='" + salary + "' where userID = " + payment.getUser().getUserID();
        List<String> list = new ArrayList<>();
        int updateCount = 0;
        updateCount = BaseDao.update(sql, list);
        return updateCount;
    }

    //创建工资
    public int setPayment(Payment payment) throws SQLException {
        List<String> list = new ArrayList<>();
        list.add(payment.getUser().getUserID());
        list.add(String.valueOf(payment.getPaymentTitle()));
        list.add(String.valueOf(payment.getPaymentBaseTitle()));
        list.add(String.valueOf(payment.getClass()));
        list.add(String.valueOf(payment.getPaymentTemporary()));
        list.add(String.valueOf(payment.getPaymentOther()));
        String sqllist = "userID,paymentTitle,paymentBaseTitle,paymentClass,paymentTemporary,paymentOther";
        String sql = "insert into payment(" + sqllist + ") values (?,?,?,?,?,?)";
        int insertCount = 0;
        insertCount = BaseDao.insert(sql, list);
        return insertCount;
    }

    //获取工资
    //在DataDao类里写了方法

}
