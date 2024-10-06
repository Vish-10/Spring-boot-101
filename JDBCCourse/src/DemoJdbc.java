import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws Exception {
        //we have to use the 7 steps here

        //Class.forName(className: "org.postgresql.Driver"); this is not more required
        //the throws exception is tp handle exceptions

        String url = "jdbc:postgresql://localhost:5432/Spring101";
        String userName = "postgres";
        String password = "0000";

        String sql = "select name from students where id = 101";

        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection Established");

        Statement st = con.createStatement();//creating a statement
        ResultSet result = st.executeQuery(sql);//executing a statement
        //result.next(); //it returns true if you have a next row
        //by default the pointer will be before the first record
        //so we have to do this before getting the results

        result.next();

        String name = result.getString("name");
        System.out.println(name);

        //closing the connection
        con.close();






    }
}
