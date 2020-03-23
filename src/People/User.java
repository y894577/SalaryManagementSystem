package People;

public class User {

    private String userID;

    private String userName;

    private String userPwd;

    private String department;

    private String position;

    private String title;

    private String isFullTime;

    private String isManager;

    private String isTeaching;

    private String isAdmin;

    public void showMessage(String msg) {

    }

    public void searchInfo() {

    }

    public void searchSalary() {

    }

    public String getUserID() {
        return userID;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public String getManager() {
        return String.valueOf(isManager);
    }

    public String getTeaching() {
        return String.valueOf(isTeaching);
    }

    public String getAdmin() {
        return String.valueOf(isAdmin);
    }

    public String getFullTime() {
        return String.valueOf(isFullTime);
    }


    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setAdmin(String admin) {
        isAdmin = admin;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setFullTime(String fullTime) {
        isFullTime = fullTime;
    }

    public void setManager(String manager) {
        isManager = manager;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTeaching(String teaching) {
        isTeaching = teaching;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
