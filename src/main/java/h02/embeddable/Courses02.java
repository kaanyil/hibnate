package h02.embeddable;

import javax.persistence.Embeddable;

@Embeddable //@Embdeddable is used to make data a class object inside a table
public class Courses02 {


    private String elective;
    private String mandatory;

    public Courses02() {
    }

    public Courses02(String elective, String mandatory) {
        this.elective = elective;
        this.mandatory = mandatory;
    }

    public String getElective() {
        return elective;
    }

    public Courses02 setElective(String elective) {
        this.elective = elective;
        return this;
    }

    public String getMandatory() {
        return mandatory;
    }

    public Courses02 setMandatory(String mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    @Override
    public String toString() {
        return "Course: selective=" + elective + ", mandatory=" + mandatory + ".";
    }


}