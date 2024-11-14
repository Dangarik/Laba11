import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class StoreService {
    private List<Store> stores;

    public StoreService() {
        this.stores = new ArrayList<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public double findMinPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        for (Store store : stores) {
            Double price = store.getPriceForProduct(productName);
            if (price != null && price < minPrice) {
                minPrice = price;
            }
        }
        return minPrice;
    }

    public List<Store> findStoresWithMinPrice(String productName, double minPrice) {
        List<Store> result = new ArrayList<>();
        for (Store store : stores) {
            if (store.getPriceForProduct(productName) != null &&
                    store.getPriceForProduct(productName) == minPrice) {
                result.add(store);
            }
        }
        return result;
    }


    public boolean checkLessThanRecommendedPrice() {
        for (Store store : stores) {
            boolean allCheaper = true;
            Iterator<Product> productIterator = store.getProducts().iterator();
            Iterator<Double> priceIterator = store.getPrices().iterator();
            while (productIterator.hasNext() && priceIterator.hasNext()) {
                Product product = productIterator.next();
                Double price = priceIterator.next();
                if (price >= product.getRecommendedPrice()) {
                    allCheaper = false;
                    break;
                }
            }
            if (allCheaper) {
                return true;
            }
        }
        return false;
    }
}
