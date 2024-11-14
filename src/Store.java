import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Store {
    private String name;
    private List<Product> products;
    private List<Double> prices;

    public Store(String name) {
        this.name = name;
        this.products = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product, double price) {
        products.add(product);
        prices.add(price);
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public Double getPriceForProduct(String productName) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(productName)) {
                return prices.get(i);
            }
        }
        return null;
    }
}