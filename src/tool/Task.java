package tool;

import Dao.PaymentDao;
import People.Parameters;
import People.Payment;
import People.User;

import java.sql.SQLException;
import java.util.TimerTask;

public class Task extends TimerTask {

    private User user;
    private Parameters parameters;

    public Task(User user, Parameters parameters) {
        setParameters(parameters);
        setUser(user);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public void run() {
        try {
            sendPayment(this.user, this.parameters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("任务已执行");
    }

    public void sendPayment(User user, Parameters parameters) throws SQLException {
        Calculate calculate = new Calculate(user, parameters);
        Payment payment = calculate.getPayment();
        PaymentDao paymentDao = new PaymentDao();
        paymentDao.setPayment(payment);

    }

}
