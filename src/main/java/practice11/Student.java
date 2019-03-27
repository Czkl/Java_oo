package practice11;

public class Student extends Person{

    private Klass klass;

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Student(int id, String name, int age, Klass klass) {
        super(id,name,age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        if ( klass.getLeader() != null && klass.getLeader().getId() == this.getId()) {
            return super.introduce() + " I am a Student. I am Leader of Class " + klass.getNumber() + ".";
        } else {
            return super.introduce()+" I am a Student. I am at Class "+klass.getNumber()+".";
        }
    }
}
