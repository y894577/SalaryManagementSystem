package tool;

import Dao.PaymentDao;
import People.Parameters;
import People.Payment;
import People.User;

import java.lang.reflect.Parameter;
import java.sql.SQLException;

/*
1.1 专任教师的工资由：岗位工资 + 基础绩效+课酬+临时性加班报酬+补/扣  （5部分组成）
    岗位工资：教授2000元，副教授1800元，讲师1500元，助教1200元；
    基础绩效工资：教授1000元，副教授800元，讲师600元，助教500元；
    课酬= 职称系数×节数×学生系数×单位课筹
    职称系数：教授职称系数为1.5，副教授为1.3，讲师为1.2，助教和其他人员为1.0；
            学生系数 = 学生人数/60，不足1的按1来计算，单位课酬为35元/节

1.2 非专任教师的工资： 岗位工资 + 基础绩效+管理岗绩效+岗位补助+临时性加班报酬+补/扣
    岗位工资：院长/书记：2000元，副院长/副书记： 1800元，系\部\中心主任：1500元，系\部\中心副主任：1200元，其他：1000元
    基础绩效工资：院长/书记：1100元，副院长/副书记： 900元，系\部\中心主任：700元，系\部\中心副主任：600元，其他：500元
    管理岗绩效：院长/书记：AV*2，副院长/副书记：AV*1.8，系\部\中心主任：AV*1.5，系\部\中心副主任：AV*1.2，其他：AV 。(Av为全院所有专任教师课酬的平均值)
    岗位补助：从事管理工作又承担教学任务的非专任教师享受岗位补助。岗位补助标准为：课酬的一半。课酬计算标准与专任教师相同。

1.3 既从事教学工作又从事管理工作的（如院长），由个人选择按专任教师岗或非专任教师岗来计算工资。

1.4 临时性加班报酬和补/扣必须提高备注。

 */

public class Calculate {
    private String department;
    private String position;
    private String title;
    private String isFullTime;
    private String isManager;
    private String isTeaching;



    private Payment payment;
    private float titleParameter = 0;

    public Payment getPayment() {
        return payment;
    }

    public Calculate(User user, Parameters parameters) throws SQLException {
        init(user);
        payment = new Payment();
        initPaymentClass(parameters);
        initPaymentOther(parameters);
        initTemporary(parameters);
        initPaymentTitle();
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsFullTime(String isFullTime) {
        this.isFullTime = isFullTime;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public void setIsTeaching(String isTeaching) {
        this.isTeaching = isTeaching;
    }

    public void setParameter(String title) {
//        职称系数：教授职称系数为1.5，副教授为1.3，讲师为1.2，助教和其他人员为1.0；
        switch (title) {
            case "教授":
                titleParameter = (float) 1.5;
                break;
            case "副教授":
                titleParameter = (float) 1.3;
                break;
            case "讲师":
                titleParameter = (float) 1.2;
                break;
            case "助教":
            case "其他人员":
                titleParameter = (float) 1.0;
                break;
        }
    }

    public void init(User user) {
        setDepartment(user.getDepartment());
        setTitle(user.getTitle());
        setPosition(user.getPosition());
        setIsFullTime(user.getFullTime());
        setIsManager(user.getManager());
        setIsTeaching(user.getTeaching());
        setParameter(user.getTitle());
    }

    //计算岗位工资和基础效绩工资
    public void initPaymentTitle() {
//  岗位工资：教授2000元，副教授1800元，讲师1500元，助教1200元；

        //专任
        if (isFullTime.equals("true")) {
//  基础绩效工资：教授1000元，副教授800元，讲师600元，助教500元；
            switch (title) {
                case "教授":
                    payment.setPaymentTitle(2000);
                    payment.setPaymentBaseTitle(1000);
                    break;
                case "副教授":
                    payment.setPaymentTitle(1800);
                    payment.setPaymentBaseTitle(800);
                    break;
                case "讲师":
                    payment.setPaymentTitle(1500);
                    payment.setPaymentBaseTitle(600);
                    break;
                case "助教":
                    payment.setPaymentTitle(1200);
                    payment.setPaymentBaseTitle(500);
                    break;
                case "其他人员":
                    payment.setPaymentTitle(1000);
                    payment.setPaymentBaseTitle(300);
                    break;
            }
        }
        //非专职
        else {
//  基础绩效工资：院长/书记：1100元，副院长/副书记： 900元，系\部\中心主任：700元，系\部\中心副主任：600元，其他：500元
            switch (title) {
                case "教授":
                    payment.setPaymentTitle(2000);
                    break;
                case "副教授":
                    payment.setPaymentTitle(1800);
                    break;
                case "讲师":
                    payment.setPaymentTitle(1500);
                    break;
                case "助教":
                    payment.setPaymentTitle(1200);
                    break;
                case "其他人员":
                    payment.setPaymentTitle(1000);
                    break;
            }
            switch (position) {
                case "院长/书记":
                    payment.setPaymentBaseTitle(1100);
                    break;
                case "副院长/副书记":
                    payment.setPaymentBaseTitle(900);
                    break;
                case "系\\部\\中心主任":
                    payment.setPaymentBaseTitle(700);
                    break;
                case "系\\部\\中心副主任":
                    payment.setPaymentBaseTitle(600);
                    break;
                case "其他":
                    payment.setPaymentBaseTitle(500);
                    break;
            }
        }

    }

    //计算课酬
    public void initPaymentClass(Parameters parameters) {
//        课酬= 职称系数×节数×学生系数×单位课筹
//        职称系数：教授职称系数为1.5，副教授为1.3，讲师为1.2，助教和其他人员为1.0；
//        学生系数 = 学生人数/60，不足1的按1来计算，单位课酬为35元/节
        double stu = Math.ceil((double) parameters.getStudentNum() / 60);
        float salary = (float) (titleParameter * parameters.getClassNum() * stu * 35);

        if (isFullTime.equals("true")) {
            payment.setPaymentClass(salary);
        } else {
            payment.setPaymentClass(0);
        }
    }

    public void initTemporary(Parameters parameters) {
        //补贴分为生活津贴、职务津贴、电话津贴、其他津贴
        float salary = parameters.getLivingPara() + parameters.getTitlePara() + parameters.getPhonePara() + parameters.getOtherPara();
        if (isTeaching.equals("true") && isManager.equals("true") && isFullTime.equals("false")) {
//            岗位补助：从事管理工作又承担教学任务的非专任教师享受岗位补助。岗位补助标准为：课酬的一半。课酬计算标准与专任教师相同。
            double stu = Math.ceil((double) parameters.getStudentNum() / 60);
            float classes = (float) (titleParameter * parameters.getClassNum() * stu * 35);
            salary += classes / 2;
        }
        payment.setPaymentTemporary(salary);
    }

    //管理岗位计算
//    管理岗绩效：院长/书记：AV*2，副院长/副书记：AV*1.8，系\部\中心主任：AV*1.5，系\部\中心副主任：AV*1.2，其他：AV 。(Av为全院所有专任教师课酬的平均值)
//    暂定av = 个人课酬
    public void initPaymentOther(Parameters parameters) {
        double stu = Math.ceil((double) parameters.getStudentNum() / 60);
        float salary = (float) (titleParameter * parameters.getClassNum() * stu * 35);
        //计算岗位补助
        if (isFullTime.equals("true")) {
            switch (position) {
                case "院长/书记":
                    payment.setPaymentOther((float) (salary * 2));
                    break;
                case "副院长/副书记":
                    payment.setPaymentOther((float) (salary * 1.8));
                    break;
                case "系\\部\\中心主任":
                    payment.setPaymentOther((float) (salary * 1.5));
                    break;
                case "系\\部\\中心副主任":
                    payment.setPaymentOther((float) (salary * 1.2));
                    break;
                case "其他":
                    payment.setPaymentOther(salary);
                    break;
            }
        } else
            payment.setPaymentOther(0);

    }


}
