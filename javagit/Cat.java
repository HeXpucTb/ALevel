import java.util.Objects;

public class Cat {
    private String name;
     public void meow(){
        System.out.println(name + " mrrr");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
     }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}

/* dkjlk lkdffj lkjsfdglkj lkjlsd
sdfg;lkdfg
sdfg
sdfg
sfdg
sfdghk;lkerr;lk 
fg kljsdffglkj lkjeriwerrto poieproigpdfg*/