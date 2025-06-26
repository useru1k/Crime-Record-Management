package crimerecordsystem.model;

public class User {
    private int userId;
    private String userName;
    private String passwordHash;
    private String userRole;

    public User(int userId, String userName, String passwordHash, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getUserRole() {
        return userRole;
    }
}
