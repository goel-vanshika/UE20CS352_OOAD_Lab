import java.util.*;
class Animal
{
    private String name;
    public Animal(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    void speak(String name)
    {   
        System.out.println("The animal "+name+" is making a sound.");
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<=N;i++)
        {
            String inputline = sc.nextLine();
            String[] a = inputline.split(" ");
            if(a[0].equals("DOG"))
                {
                    Dog d = new Dog(a[1],a[2]);
                    d.speak();
                }
                if(a[0].equals("CAT"))
                {
                    Cat c = new Cat(a[1],a[2]);
                    c.speak();
                }

        }
    }
}
class Dog extends Animal
    {
        public Dog(String breed, String name)
        {
            super(name);
            this.breed = breed;
        }
        private String breed;
        void speak()
        {
            System.out.println("The "+breed+" "+super.getName()+" is barking.");
        }
    }

class Cat extends Animal
    {
        public Cat(String color, String name)
        {
            super(name);
            this.color=color;
        }
        private String color;
        void speak()
        {
            System.out.println("The "+color+" cat "+super.getName()+" is meowing.");
        }
    }