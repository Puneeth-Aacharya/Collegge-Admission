import java.sql.*;

import javax.swing.JOptionPane;

public class Student {
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */
	
	
	 public static Connection Connect(){
		String url="jdbc:mysql://localhost:3306/student";
		String usr="root";
		String pass="";//"puneeth@123";
		
		Connection con=null;
		try {
			con=DriverManager.getConnection(url,usr,pass);
			return con;
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
            return null;
		}
	}

}
