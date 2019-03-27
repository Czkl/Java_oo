package practice11;



import java.util.List;
import java.util.Observable;

public class Klass extends Observable {
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
        setChanged();
        notifyObservers(this);
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        setChanged();
        notifyObservers(student);
    }

    public boolean isIn(List<Klass> classes) {
        if (classes == null || classes.isEmpty()) {
            return false;
        } else {
            return classes.contains(this);
        }
    }

}

