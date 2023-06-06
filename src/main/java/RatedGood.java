public class RatedGood extends Good {
    // Open-closed принцип, расширяя класс Good, добавляя новую переменную, при этом другие методы берет от класса родителя
    //Liskov substitution principle - класс, наследованный от класса Good полностью повторяет переменные и методы родительского класса, следовательно, может заменять родительский где это необходимо
    private String name;
    private int price;
    private double rating;

    public RatedGood(String name, int price, double rating) {
        super(name, price);
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name + " Цена: " + price + " руб. Рейтинг: " + rating;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }
}
