import java.util.*;
class Person
{
    protected String name;
    protected int age;
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    // public String getName()
    // {
    //     return name;
    // }
    // public Person(int age)
    // {
    //     this.age = age;
    // }
    // public int getAge()
    // {
    //     return age;
    // }
    void introduce()
    {   
        System.out.println("My name is "+name+" and my age is "+age);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        while(sc.hasNextLine())
        {
            String inputline = sc.nextLine();
            String[] a = inputline.split(" ");
            n = a.length;
            if(n==2)
            {
                Person p = new Person(a[0],Integer.parseInt(a[1]));
                p.introduce();
            }
            if(n==3)
            {
                try
                {
                    int temp = Integer.parseInt(a[2]);
                    Student s = new Student(a[0],Integer.parseInt(a[1]),Integer.parseInt(a[2]));
                    s.introduce();   
                }
                catch(NumberFormatException nfe)
                {
                    Teacher t = new Teacher(a[0],Integer.parseInt(a[1]),a[2]);
                    t.introduce(); 
                }
            }
            if(n==4)
            {
                GraduateStudent g = new GraduateStudent(a[0],Integer.parseInt(a[1]),Integer.parseInt(a[2]),a[3]);
                g.introduce();
            }
        }
        System.out.println("fin");
    } 
}
class Student extends Person
    {
        protected int studentID;
        public Student(String name, int age, int studentID)
        {
            super(name,age);
            this.studentID = studentID;
        }
        void introduce()
        {   
            super.introduce();
            System.out.println("I am a student with student ID : "+studentID);
        }
    }
class GraduateStudent extends Student
{
    private String thesisTitle;
    public GraduateStudent(String name, int age, int studentID, String thesisTitle)
        {
            super(name,age,studentID);
            this.thesisTitle = thesisTitle;
        }
    void introduce()
        {   
            super.introduce();
            System.out.println("I am a graduate student and my thesis title is "+thesisTitle);
        }
}

class Teacher extends Person
    {
        public Teacher(String name, int age, String subject)
        {
            super(name,age);
            this.subject=subject;
        }
        private String subject;
        void introduce()
        {   
            super.introduce();
            System.out.println("I am a teacher and I teach "+subject);
        }
    }