package iuh.fit.se.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class Class_ {
//    @Value("DHKTPM18A")
    private String classId;
//    @Value("Dai Hoc KTPM18A")
    private String className;

    public Class_() {}

    public Class_(String classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class_{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
