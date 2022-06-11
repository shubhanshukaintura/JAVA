import java.sql.*;

class JDBCTest{
	public static void main(String args[])
	{
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success");	
		}
		catch(Exception e){
			System.out.println(e);		
		}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse1?			autoReconnect=true&useSSL=false","root","gehu");
			System.out.println("Connection Established");	
		}
		catch(Exception e){
			System.out.println("Connection Not Established");
		}
		/*try{
			
			//st.executeUpdate("insert into emp(id,name)values(15,'Raj')");
		}
		catch(Exception e)
		{
			System.out.println("Insertion Failed");		
		}*/
		try{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from emp");
			while(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));			
			}		
		}
		catch(Exception e)
		{
			System.out.println("Result SET Failed");		
		}
	}
}
