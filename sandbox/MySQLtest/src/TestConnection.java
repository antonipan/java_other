import java.sql.*;

public class TestConnection {

    private static final String USER = "root";
    private static final String PASSWORD = "Root!123";
    private static final String URL = "jdbc:mysql://localhost:3306/mytestdb";
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static Statement statement = null;




    public void addDB (String name, String city, int age){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Драйвер успешно зарегистрирован.. ");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение успешно установлено. ");

            String sql = "INSERT INTO users (name, city, age)" +
                    " VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, String.valueOf(age));

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("A row has been inserted. ");
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void selectDB (){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение успешно установлено. ");

            String sql = "SELECT * FROM users";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;
            while (result.next()) {
                count++;
                String name = result.getString(2);
                String city = result.getString(3);
                String age = result.getString(4);

                System.out.println(count + " " + name + " " + city + " " + age + ";");
            }

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteDB (String name){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение успешно установлено... ");

            String sql = "DELETE FROM users WHERE name = '" + name + "';";
            statement = connection.prepareStatement(sql);
            int rows = statement.executeUpdate(sql);
            System.out.printf("%d row(s) deleted", rows);


            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
