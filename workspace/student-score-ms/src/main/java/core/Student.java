package core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String studentId;
    private String name;
    private int klass;
    private String email;
    private String personalId;
    private String mobilePhone;
    private String nativePlace;
    private String grender;

    public Student(String name, String studentId, int klass, String email, String personalId, String mobilePhone, String nativePlace, String grender) {
        this.name = name;
        this.studentId = studentId;
        this.klass = klass;
        this.email = email;
        this.personalId = personalId;
        this.mobilePhone = mobilePhone;
        this.nativePlace = nativePlace;
        this.grender = grender;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getKlass() {
        return klass;
    }

    public void setKlass(int klass) {
        this.klass = klass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getGrender() {
        return grender;
    }

    public void setGrender(String grender) {
        this.grender = grender;
    }
}
