public interface Customer {
    // Принцип Dependency inversion позволяет нам отталкиваться от методов, написанных в интерфейсе, при этом меняя наследников и добавляя в них новые функции
    void checkBasket();

    void deposit(int sum);

    void addGood(RatedGood ratedGood, int quantity);

    void buy();

}
