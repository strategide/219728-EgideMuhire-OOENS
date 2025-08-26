package edu.strathmore.dbit.ooens.entity;

import edu.strathmore.dbit.ooens.utils.TimeStamp;

public class Session extends BaseEntity {
    private String studentId;
    private String token;
    private String cookie;

    public Session(String id, String studentId, String token, String cookie, TimeStamp timeStamp) {
        super(id, timeStamp);
        this.studentId = studentId;
        this.token = token;
        this.cookie = cookie;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
