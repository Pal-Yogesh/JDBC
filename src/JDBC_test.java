import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JDBC_test {
    public static void main(String[] args) throws ClassNotFoundException , SQLException {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Pattern p = Pattern.compile((0-9)+"@(gmail|yahoo|reddif).com");
        Matcher m = p.matcher(str);
    }
}

