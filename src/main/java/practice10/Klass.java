package practice10;


import java.util.List;

public class Klass {
    private Integer number;

    private Student leader;

    public Student getLeader() {
        return leader;
    }

    public Klass(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDisplayName(){
        return "Class " + number;
    }

    public void assignLeader(Student student){
        if (student.getKlass().getNumber() != this.getNumber()) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = student;
    }

    public void appendMember(Student student) {
        student.setKlass(this);
    }

    public boolean isIn(List<Klass> classes) {

        return classes.contains(this);
    }
}

