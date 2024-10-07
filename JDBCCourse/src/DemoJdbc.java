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

        //fetching all the records
        sql = "select * from students";

        ResultSet fetchAllRecords = st.executeQuery(sql);
        while(fetchAllRecords.next()){
            System.out.print(fetchAllRecords.getInt("id") + " - ");
            System.out.println(fetchAllRecords.getString("name"));
        }

        //CRUD operations
        sql = "insert into students values (105, 'test4')";
        boolean insertRecord = st.execute(sql);
        System.out.println(insertRecord);//this doesnt give us the status so returning is of no use, if u need to understand more about this look into the function definition
        //so we can just execute the sql

        //prepared statement
        /*
            1. if we have to get the data from a source and execute the query it is difficult to format the query
            2. to stop sql injections (not sure about this have to do some research)
            3. improve performance
         */
        int studentId = 106;
        String studentName = "test5";
        sql = "insert into students values (?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        //we cannot execute the query at this point
        pst.setInt(1, studentId);//column number and the value
        pst.setString(2, studentName);
        pst.execute();


        //closing the connection
        con.close();






    }
}
