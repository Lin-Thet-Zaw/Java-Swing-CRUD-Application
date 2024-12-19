
package javacrudapplication;


public class UserModel {
    private int id;
    private String fristName;
    private String lastName;
    private String email;
    private String country;
    
    public UserModel( int id, String fristName, String lastName, String email, String country){
        this.id = id;
        this.fristName = fristName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFristName() {
        return fristName;
    }

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
