
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class student {
    
    public void insertUpdateDeleteStudent(char operation, Integer id, String fname,String lname,String sex, String bdate,String phone, String address)
    {
    
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        
        //I FOR INSERT
        if(operation == 'i'){
        
            try {
                ps = con.prepareStatement("INSERT INTO student(first_name, last_name, sex, birthdate, phone, address) VALUES (?,?,?,?,?,?)");
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, sex);
                ps.setString(4, bdate);
                ps.setString(5, phone);
                ps.setString(6, address);     
                
                if(ps.executeUpdate()>0){
                 JOptionPane.showMessageDialog(null,"New Student Added");
                
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    
    }
    
}
