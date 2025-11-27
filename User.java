
package javafxapplication23;

public class User {
    private int userId;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String role;
    private String createdAt;

    public User(int userId, String username, String password, 
                String phoneNumber, String role, String createdAt) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.createdAt = createdAt;
    }

    public int getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getFullName() { return fullName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getRole() { return role; }
    public String getCreatedAt() { return createdAt; }
}