package ro.ulbs.proiectaresoftware.lab4;

public class Tanar {
    private String name;
    private int age;
    private String address;

    public Tanar(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName()    { return name; }
    public int getAge()        { return age; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return String.format("Tanar{ name='%s', age=%d, address='%s' }",
                name, age, address);
    }
}
