package practice11;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Teacher extends Person implements Observer {

    private List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Teacher(String name, int age, List<Klass> classes) {
        super(name, age);
        this.classes = classes;
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public void setClasses(List<Klass> classes) {
        this.classes = classes;
    }

    @Override
    public String introduce() {
        if (classes == null || classes.size() == 0) {
            return super.introduce() + " I am a Teacher. I teach No Class.";
        } else {
            String str = super.introduce() + " I am a Teacher. I teach Class ";
            for (Klass aClass : classes) {
                str += aClass.getNumber() +", ";
            }
            str = str.trim().substring(0, str.length() - 2) +".";
            return str;
        }
    }
    public String introduceWith(Student student){
        if (isTeaching(student)){
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
        }
    }

    public boolean isTeaching(Student student){
        if (classes == null || classes.isEmpty()) {
            return false;
        } else {
            return student.getKlass().isIn(classes);
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Klass) {
            Klass klass = (Klass) o;
            if (classes.contains(klass)){
                System.out.print("I am "+this.getName()+". I know "+klass.getLeader().getName()+" become Leader of Class "+klass.getNumber()+".\n");
            }
        }else if(arg instanceof Student){
            Student student = (Student) arg;
            Klass klass = student.getKlass();
            System.out.print("I am "+this.getName()+". I know "+student.getName()+" has joined Class "+klass.getNumber()+".\n");
        }
    }
}

