package fourthtask;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PasswordsChecker {
    private ArrayList<String> passwords;
    private List<OverlapContainer> previousTop10 = new ArrayList<>();
    private Set<String> top10 = new HashSet<>();
    public void addPasswordsToList(){
        String n;
        passwords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader( new FileReader("/home/aleksandr/temp/Logins.txt"))){
            while ((n = reader.readLine())!= null){
                n = n.substring(n.indexOf(" "));
                passwords.add(n);
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }catch (IOException e){
            System.out.println("Ошибка ввода-вывода");
        }
    }
    public void checkOverlap(){
        String tempString;
        for (int i = 0; i < passwords.size(); i++) {
            OverlapContainer overlapContainer = new OverlapContainer();
            tempString = passwords.get(i);
            overlapContainer.setPassword(tempString);
            int count = 0;
            for (int j = 0; j < passwords.size(); j++) {
                if(tempString.equals(passwords.get(j))){
                    count++;
                }
            }
            overlapContainer.setOverlap(count);
            previousTop10.add(overlapContainer);
        }
    }
    public void returnTop10PasswordsList(){
        Collections.sort(previousTop10, new Comparator<OverlapContainer>() {
            @Override
            public int compare(OverlapContainer t, OverlapContainer t1) {
                if(t.getOverlap()>t1.getOverlap()){
                    return -2;
                }
                if (t.getOverlap()==t1.getOverlap()){
                    return 0;
                }else return 2;
            }
        });
        for (OverlapContainer ex: previousTop10) {
            top10.add(ex.getPassword());
        }
    }
    public void print10Top(Set<String> list){
        int j = 0;
        for (String i:list) {
            if (j==10)return;
            System.out.println(i);
            j++;
        }
    }

    public Set<String> getTop10() {
        return top10;
    }
}
