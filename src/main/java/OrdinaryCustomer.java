public class OrdinaryCustomer implements Customer {
    private final String name;
    private final String surname;
    private int balance;
    private Basket basket;


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Basket getBasket() {
        return basket;
    }

    public OrdinaryCustomer(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.basket = new Basket();
    }

    @Override
    public void checkBasket() {
        if (this.getBasket().getBasketMap().size() == 0) {
            System.out.println("Ваша корзина пуста! Исправьте это!");
            return;
        }
        System.out.println(basket.getBasketToPrint());
        //Принцип Single-Responsibily на практике, класс Customer сам показывает корзину, это делает метод в классе Basket
        System.out.println("Общая сумма в корзине: " + basket.calculatePrice(this) + " руб.");
    }

    @Override
    public void deposit(int sum) {
        this.setBalance(sum);
        System.out.println("Вы пополнили ваш баланс на - " + sum);
        System.out.println("Ваш баланс: " + balance);
    }

    @Override
    public void addGood(RatedGood ratedGood, int quantity) {
        this.basket.getBasketMap().put(ratedGood, quantity);
    }

    @Override
    public void buy() {
        if (basket.calculatePrice(this) > balance) {
            //Принцип Single-Responsibily на практике, класс Customer сам не считает цену корзины, это делает метод в классе Basket
            System.out.println("Не хватает средств для совершения покупки! " +
                    "\nВаш баланс: " + balance + "" +
                    "\nНеобходимая сумма: " + basket.calculatePrice(this));
            return;
        }
        System.out.println("Вы совершили покупку!");
        balance -= basket.calculatePrice(this);
        System.out.println("Ваш баланс: " + balance);
        this.basket.getBasketMap().clear();

    }
}
