import java.util.HashMap;

public class Basket {
    private HashMap<RatedGood, Integer> basketMap;

    public Basket() {
        this.basketMap = new HashMap<>();
    }

    public int calculatePrice(OrdinaryCustomer ordinaryCustomer) {
        int sum = 0;
        HashMap<RatedGood, Integer> customersBasket = ordinaryCustomer.getBasket().getBasketMap();
        for (RatedGood g : customersBasket.keySet()) {
            sum += customersBasket.get(g) * g.getPrice();
        }
        return sum;
    }

    public String getBasketToPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ваша корзина: ");
        for (RatedGood g : basketMap.keySet()) {
            sb.append(g.getName());
            sb.append(" - ");
            sb.append(basketMap.get(g));
            sb.append(" шт.");
        }
        return sb.toString();
    }

    public HashMap<RatedGood, Integer> getBasketMap() {
        return basketMap;
    }

}
