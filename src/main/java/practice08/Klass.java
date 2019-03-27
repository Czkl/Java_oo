package practice08;

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
        this.leader = student;
    }
}
