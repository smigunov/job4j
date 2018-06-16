package classes;

public class Profession {
    public String name;
    public String occupation;

}
public class Doctor extends Profession {
    public void cure(Patient patient) {
        return;
    }
    public Diagnose getDiagnose(Patient patient) { return; }
}

public class Diagnose {
    public String Name;
}

public class Patient {
    public String name;
}

public class Engineer extends Profession {
    public void build (House house) {
        return;
    }
}

public class House {
}

public class Student {
    public String name;
}

public class Teacher extends Profession {
    public void teach(Student student) {
        return;
    }
}
