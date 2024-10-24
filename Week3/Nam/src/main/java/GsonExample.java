import com.google.gson.Gson;
public class GsonExample {
	public static void main(String[] args) {
        
        String jsonString = "{ \"name\": \"John\", \"age\": 30, \"isStudent\": false }";

        Gson gson = new Gson();

        Person person = gson.fromJson(jsonString, Person.class);

        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);
        System.out.println("Is Student: " + person.isStudent);

        String jsonFromObject = gson.toJson(person);
        System.out.println("JSON from Object: " + jsonFromObject);
    }
}
