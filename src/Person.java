import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Person {
    private int Id;
    private String username;
    private String password;
    private String email;
    private String fname;
    private String lname;
    private String mname;
    private String mobile;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Person(int Id,String username, String password, String email, String fname, String lname, String mname, String mobile) {
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.mobile = mobile;

    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", mname='" + mname + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
    public static Person getPerson(List<Person> personList,String username,String password){
        Person account = null;
        for(Person person:personList){
            if(person.getUsername().equals(username) && person.getPassword().equals(password)){
                account = person;
            }

        }
        return account;
    }


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(32454,"marcpogz","admane127","marcpogz@gmail.com","Marc","Pogz","D","0909090909"));
        personList.add(new Person(545545,"janedoe","doejane21","janedoe@gmail.com","Jane","Doe","Guo","093030303030"));
        System.out.println(personList.get(0).toString());
        System.out.println(personList.get(1).toString());
        Scanner input = new Scanner(System.in);
        String un,pw;

        try{
            System.out.println("Enter username: ");
            un=input.nextLine();
            System.out.println("Enter password: ");
            pw = input.nextLine();
            Person currentUser= getPerson(personList,un,pw);
            if((currentUser)!=null){
                System.out.println(currentUser);
            }
            else{
                throw new RuntimeException("Invalid username or password");
            }
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
