import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Product {
    private String name;
    private double recommendedPrice;

    public Product(String name, double recommendedPrice) {
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }

    public String getName() {
        return name;
    }

    public double getRecommendedPrice() {
        return recommendedPrice;
    }
}