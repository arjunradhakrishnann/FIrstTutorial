package contactapp.practice.arjun.contactapp;

/**
 * Created by CTPL-DM05 on 09-02-2018.
 */

public class DataModel {
    private String fname,lname,email;
    private int id,phone;

    public DataModel(String fname, String lname, String email, int id, int phone) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.id = id;
        this.phone = phone;
    }

    public DataModel() {

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
