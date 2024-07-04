public class Main {
    public static void main(String[] args) {
        TestConnection testConnection = new TestConnection();
//        testConnection.addDB("Ivan", "Ivanovo", 30);
        testConnection.selectDB();
        testConnection.deleteDB("Jon");

    }
}