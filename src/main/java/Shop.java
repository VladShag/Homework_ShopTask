public interface Shop {
    // Принцип Dependency inversion позволяет нам отталкиваться от методов, написанных в интерфейсе, при этом меняя наследников и добавляя в них новые функции
    // Так интерфейс Shop имплементируется в классе ProductShop, но также может быть импелентирован в Строительном магазине, Мебельном и т.п.
    String greetingMessage(OrdinaryCustomer ordinaryCustomer);

    String mainMenu();

    String listOfGoods();
}
