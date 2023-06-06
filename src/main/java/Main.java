import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static final ProductShop PRODUCT_SHOP;

    static {
        try {
            PRODUCT_SHOP = new ProductShop("Goods.json");
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш магазин! \nПожалуйста введите имя и фамилию: ");
        String name = scanner.nextLine();
        String[] logData = name.split(" ");
        OrdinaryCustomer actualOrdinaryCustomer = PRODUCT_SHOP.getCb().login(logData[0], logData[1]);
        System.out.println(PRODUCT_SHOP.greetingMessage(actualOrdinaryCustomer));
        while (true) {
            System.out.println(PRODUCT_SHOP.mainMenu());
            int command = scanner.nextInt();
            if (command == 0) {
                System.out.println("Ждем вас снова!");
                break;
            }
            switch (command) {
                case 1:
                    while (true) {
                        System.out.println(PRODUCT_SHOP.listOfGoods());
                        int goodToBuy = scanner.nextInt();
                        if (goodToBuy == 0) {
                            break;
                        }
                        if (goodToBuy > PRODUCT_SHOP.getPriceList().getPricelist().size()) {
                            System.out.println("Извините, данного номера нет в списке!");
                        } else {
                            System.out.println("И количество: ");
                            int quantity = scanner.nextInt();
                            actualOrdinaryCustomer.addGood(PRODUCT_SHOP.getPriceList().getPricelist().get(goodToBuy - 1), quantity);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ваш баланс: " + actualOrdinaryCustomer.getBalance());
                    break;
                case 3:
                    System.out.println("Cколько вы хотите внести, введите сумму: ");
                    int moneyToPut = scanner.nextInt();
                    actualOrdinaryCustomer.deposit(moneyToPut);
                    break;
                case 4:
                    actualOrdinaryCustomer.checkBasket();
                    break;
                case 5:
                    actualOrdinaryCustomer.buy();
                    break;
                case 0:
                    System.out.println("Ждем вас снова!");
                    break;
                default:
                    System.out.println("Такой команды еще нет!");
            }
        }

    }
}
