package tool;

import People.Parameters;
import People.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class MyTimer {
    Timer timer;

    Calendar today = Calendar.getInstance();
    //获取这个月的天数
    int day = today.getActualMaximum(Calendar.DAY_OF_MONTH);
    long delay = (long) day * 1000 * 60 * 60 * 24;

    public MyTimer(User user, Parameters parameters) {
        Date time = getTime();
        System.out.println("时间 " + time + " 触发函数");
        timer = new Timer();
        timer.schedule(new Task(user,parameters), time, delay);
    }

    public Date getTime() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 10);
        calendar.set(Calendar.SECOND, 00);
        //如果过了10号再重定义参数则下个月才发工资
        if (System.currentTimeMillis() > calendar.getTimeInMillis()) {
            calendar.set(Calendar.MONTH, Calendar.MONTH + 1);
        }
        return calendar.getTime();
    }

//    public static void main(String[] args) throws ParseException {
//        new MyTimer("test");
//    }
}
