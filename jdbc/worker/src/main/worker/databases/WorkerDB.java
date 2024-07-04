package databases;

import model.BaseWorker;
import model.WorkerHour;
import model.WorkerMonth;

import java.sql.*;
import java.util.List;

public class WorkerDB {

    private static final String USER = "root";
    private static final String PASSWORD = "Root!123";
    private static final String URL = "jdbc:mysql://localhost:3306/workers";

    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static Statement statement = null;

    public BaseWorker worker;


    public void addDB (List<BaseWorker> listWorker, int countStartWorker){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Драйвер успешно зарегистрирован.. ");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение успешно установлено. ");

            for (int i = countStartWorker; i < listWorker.size(); i++) {
                BaseWorker worker = listWorker.get(i);
                String sql = "INSERT INTO salary (name, salary, age, mark)" +
                        " VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, worker.getName());
                preparedStatement.setString(3, String.valueOf(worker.getAge()));
                preparedStatement.setString(2, String.valueOf(worker.getSalary()));
                preparedStatement.setString(4, worker.getMark());
                int rows = preparedStatement.executeUpdate();
                if (rows > 0) {
                    System.out.println("A row has been inserted. ");
                }
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

            String sql = "SELECT * FROM salary";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;
            while (result.next()) {
                count++;
                String name = result.getString(2);
                String age = result.getString(4);
                String salary = result.getString(3);

                System.out.println(count + " " + name + " " + age + " " + salary + ";");
            }

            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void selectDB (List<BaseWorker> listWorker){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение успешно установлено. ");

            String sql = "SELECT * FROM salary";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;
            while (result.next()) {
                count++;
                String name = result.getString(2);
                int age = Integer.parseInt(result.getString(4));
                double salary = Double.parseDouble(result.getString(3));
                String mark = result.getString(5);
                if (mark.equals("month")) {
                    worker = new WorkerMonth(salary);
                } else {
                    worker = new WorkerHour(salary/(20.8*8));
                }
                worker.setName(name);
                worker.setAge(age);
                listWorker.add(worker);
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

            String sql = "DELETE FROM salary WHERE name = '" + name + "';";
            statement = connection.prepareStatement(sql);
            int rows = statement.executeUpdate(sql);
            System.out.printf("%d row(s) deleted\n", rows);


            statement.close();
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
