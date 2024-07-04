package furniture.my_factory_furniture;

public class BarLoading {
    /**
     * метод имитирует загрузку.
     */
    public void stringRun () {
        char ch1 = '#';
        for (int i = 0; i < 10; i++) {
            System.out.print(ch1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println();
    }
}

