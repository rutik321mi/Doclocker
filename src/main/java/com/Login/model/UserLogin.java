package com.Login.model;

public class UserLogin {
	private long userid;
    private String password;
    private String role;
 public UserLogin(long id, String pass, String role) {
    super();

	 userid = id;

	 password = pass;
	 this.role= role;
 }
    public long getAadhar() {
    return userid;
    }
   
    public String getPassword() {
    return password;
    }
    public String getRole() {
        return role;
        }
   
}
