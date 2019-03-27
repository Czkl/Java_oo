package practice10;


import java.util.List;

public class Teacher extends Person{

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
        if (student.getKlass().isIn(classes)){
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        } else {
            return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
        }
    }

    public boolean isTeaching(Student student){
        return student.getKlass().isIn(classes);
    }
}

