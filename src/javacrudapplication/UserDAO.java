
package javacrudapplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {
   private final Connection connection;
   
    public UserDAO() throws SQLException {
       connection = DbConnetion.getConnection();
    }
   
    public int insertUser(UserModel user){
         String sql = "INSERT INTO users (frist_name, last_name, email, country) VALUES (?,?,?,?)";
         try{
              PreparedStatement smt = connection.prepareStatement(sql);
              smt.setString(1, user.getFristName());
              smt.setString(2, user.getLastName());
              smt.setString(3, user.getEmail());
              smt.setString(4, user.getCountry());
              smt.executeUpdate();
              return 1;
         }catch(SQLException e){
             return 0;
         }   
    }
   
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM users";
            PreparedStatement smt = connection.prepareStatement(sql);
            ResultSet res =  smt.executeQuery();
            while(res.next()) {
                int id = res.getInt("id");
                String fName = res.getString("frist_name");
                String lName = res.getString("last_name");
                String email = res.getString("email");
                String country = res.getString("country");
                
                users.add(new UserModel(id, fName, lName, email, country));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }
    
    public boolean updateUser(UserModel user) throws SQLException {
        String query = "UPDATE users SET frist_name = ?, last_name = ?, email = ?, country = ? WHERE id = ?";
        try (
            PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getFristName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCountry());
            stmt.setInt(5, user.getId());
            return stmt.executeUpdate() > 0;
        }
    }
    
    public boolean deleteUser(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id=?";
        try (
            PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
