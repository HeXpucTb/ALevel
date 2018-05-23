public class Employer {
    public void checkPerson(String json){
        Person person = Adapter.getPersonFromJSON(json);
        if(!person.isEmployed()&&person.isHomeOwner()){
            System.out.println("This person will be employed!");
        }else{
            System.out.println("Gimme more");
        }
    }
}
