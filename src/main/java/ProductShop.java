import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ProductShop implements Shop {
    private final CustomerBase cb;
    private final RatedGoodsList priceList;

    public CustomerBase getCb() {
        return cb;
    }

    public RatedGoodsList getPriceList() {
        return priceList;
    }


    public ProductShop(String filename) throws ParseException, IOException {
        this.priceList = new RatedGoodsList(filename);
        this.cb = CustomerBase.getInstance();
    }

    @Override
    public String greetingMessage(OrdinaryCustomer ordinaryCustomer) {
        return "Добро пожаловать " + ordinaryCustomer.getName() + " " + ordinaryCustomer.getSurname() + "!";
    }

    @Override
    public String mainMenu() {
        return "Список доступный действий: \n1.Начать покупки " +
                "\n2.Посмотреть баланс " +
                "\n3.Внести деньги на счет " +
                "\n4.Посмотреть корзину " +
                "\n5.Перейти к оформлению заказа " +
                "\n0.Выход";

    }

    @Override
    public String listOfGoods() {
        return "Вот список товаров, доступных для покупки! Пожалуйста, выберете что вы хотите купить, выбрав номер товара:  \nДля оформления введите 0 \n" + priceList;
    }
}
