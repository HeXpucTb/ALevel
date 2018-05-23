public class Person {
    private final String lastName;
    private final String firstName;
    private String middleName;
    private String salutation;
    private String suffix;
    private String streetAdress;
    private String city;
    private String state;
    private final boolean isFemail;
    private boolean isEmployed;
    private boolean isHomeOwner;
    private Person(String lastName, String firstName, boolean isFemail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.isFemail = isFemail;
    }
    private void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    private void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    private void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    private void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setState(String state) {
        this.state = state;
    }

    private void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    private void setHomeOwner(boolean homeOwner) {
        isHomeOwner = homeOwner;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public boolean isFemail() {
        return isFemail;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public boolean isHomeOwner() {
        return isHomeOwner;
    }
    public static class PersonBuilder{
        private String lastName;
        private String firstName;
        private boolean isFemail;
        private String middleName;
        private String salutation;
        private String suffix;
        private String streetAdress;
        private String city;
        private String state;
        private boolean isEmployed;
        private boolean isHomeOwner;
        private PersonBuilder builder;
        public PersonBuilder(){
            this.builder = new PersonBuilder();
        }
        public Person build(){
            Person person = new Person(lastName,firstName,isFemail);
            person.setMiddleName(middleName);
            person.setSalutation(salutation);
            person.setSuffix(suffix);
            person.setStreetAdress(streetAdress);
            person.setCity(city);
            person.setState(state);
            person.setEmployed(isEmployed);
            person.setHomeOwner(isHomeOwner);
            return person;
        }
        public PersonBuilder setLastName(String lastName){
            this.lastName = lastName;
            return builder;
        }
        public PersonBuilder setFirstName(String firstName){
            this.firstName = firstName;
            return builder;
        }
        public PersonBuilder setFemail(boolean isFemail){
            this.isFemail = isFemail;
            return builder;
        }
        public PersonBuilder setMiddleName(String middleName){
            this.middleName = middleName;
            return builder;
        }
        public PersonBuilder setSalutation(String salutation){
            this.salutation = salutation;
            return builder;
        }
        public PersonBuilder setSuffix(String suffix){
            this.suffix = suffix;
            return builder;
        }
        public PersonBuilder setStreetAdress(String streetAdress){
            this.streetAdress = streetAdress;
            return builder;
        }
        public PersonBuilder setCity(String city){
            this.city = city;
            return builder;
        }
        public PersonBuilder setState(String state){
            this.state = state;
            return builder;
        }
        public PersonBuilder setEmployed(boolean isEmployed){
            this.isEmployed = isEmployed;
            return builder;
        }
        public PersonBuilder setHomeOwner(boolean isHomeOwner){
            this.isHomeOwner = isHomeOwner;
            return builder;
        }
    }
}
