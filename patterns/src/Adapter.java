import com.google.gson.Gson;

abstract class Adapter {
    public static String personToJSON(Person person){
        Gson gson = new Gson();
        return gson.toJson(person);
    }
    public static Person getPersonFromJSON(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }
}
