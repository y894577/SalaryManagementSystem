package People;

public class Payment {
    private User user;
    //岗位工资
    private float paymentTitle;
    //基础效绩工资
    private float paymentBaseTitle;
    //课酬
    private float paymentClass;
    //其他补助
    private float paymentTemporary;
    //管理效绩
    private float paymentOther;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getPaymentTitle() {
        return paymentTitle;
    }

    public void setPaymentTitle(float paymentTitle) {
        this.paymentTitle = paymentTitle;
    }

    public float getPaymentBaseTitle() {
        return paymentBaseTitle;
    }

    public void setPaymentBaseTitle(float paymentBaseTitle) {
        this.paymentBaseTitle = paymentBaseTitle;
    }

    public float getPaymentClass() {
        return paymentClass;
    }

    public void setPaymentClass(float paymentClass) {
        this.paymentClass = paymentClass;
    }

    public float getPaymentTemporary() {
        return paymentTemporary;
    }

    public void setPaymentTemporary(float paymentTemporary) {
        this.paymentTemporary = paymentTemporary;
    }

    public float getPaymentOther() {
        return paymentOther;
    }

    public void setPaymentOther(float paymentOther) {
        this.paymentOther = paymentOther;
    }

}
