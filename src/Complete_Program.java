import java.sql.*;
import java.util.Scanner;

public class Complete_Program  {
    public Connection con = null;
    public PreparedStatement ps = null;
    Complete_Program() throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3308/Studatabase","root","");
    }
    public void insert(String a,String b,String c,String d,String e) throws SQLException{
        int a1 = Integer.parseInt(a);
        int e1 = Integer.parseInt(e);
        String str = "insert into stu values(" + a1 + ",'" + b + "','" + c + "','" + d + "'," + e1 +")";
        System.out.println(str);

        ps = con.prepareStatement(str);
        ps.executeUpdate();
    }
    public void delete(String a) throws SQLException{
        Integer a1 = Integer.parseInt(a);
        String str1 = "delete from stu where rollno="+ a1;
        System.out.println(str1);
        ps = con.prepareStatement(str1);
        ps.executeUpdate();
    }
    public void modify(String a, String e) throws SQLException{
        int a1 = Integer.parseInt(a);
        int e1 = Integer.parseInt(e);
        String str2 = "update stu set fee"+e1+" where rollno="+a1;
        System.out.println(str2);
        PreparedStatement ps = con.prepareStatement(str2);
        ps.executeUpdate();
    }
    public void display(String a) throws SQLException{
        Integer a1 = Integer.parseInt(a);
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from stu where rollno ="+a1);
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getInt(5));
        }
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------");
        System.out.println("Press 1. inserting the record ");
        System.out.println("Press 2. delete a record ");
        System.out.println("Press 3. modify a record ");
        System.out.println("Press 4. display the record ");
        System.out.println("Press 0. exit the program ");
        System.out.println("-----------------------------");
        Complete_Program cp = new Complete_Program();


        switch (args[0]) {
            case "0":
                break;
            case "1":
                cp.insert(args[1], args[2], args[3], args[4], args[5]);
                System.out.println("record inserted");
                break;
            case "2":
                cp.delete(args[1]);
                break;
            case "3":
                cp.modify(args[1], args[2]);
                break;
            case "4":
                cp.display(args[1]);
                break;
            default:
                System.out.println("enter your choice again ");
        }
    }
}
