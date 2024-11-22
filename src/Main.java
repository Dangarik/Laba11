import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Квас", 55.0);
        Product product2 = new Product("Сухарики", 23.0);

        Store store1 = new Store("ATB");
        store1.addProduct(product1, 10.0);
        store1.addProduct(product2, 22.0);

        Store store2 = new Store("Eco-market");
        store2.addProduct(product1, 54.0);
        store2.addProduct(product2, 160.0);

        StoreService service = new StoreService();
        service.addStore(store1);
        service.addStore(store2);

        double minPricePivo = service.findMinPrice("Пиво");
        System.out.println("Мінімальна ціна на Пиво: " + minPricePivo);

        double minPriceSuhariki = service.findMinPrice("Сухарики");
        System.out.println("Мінімальна ціна на Сухарики: " + minPriceSuhariki);

        List<Store> storesWithMinPricePivo = service.findStoresWithMinPrice("Квас", minPricePivo);
        System.out.println("Магазини з мінімальною ціною на Пиво:");
        for (Store store : storesWithMinPricePivo) {
            System.out.println(store.getName());
        }

        List<Store> storesWithMinPriceSuhariki = service.findStoresWithMinPrice("Сухарики", minPriceSuhariki);
        System.out.println("Магазини з мінімальною ціною на Сухарики:");
        for (Store store : storesWithMinPriceSuhariki) {
            System.out.println(store.getName());
        }

        boolean isStoreWithAllCheaper = service.checkLessThanRecommendedPrice();
        System.out.println("Є магазин, усі товари якого дешевші за рекомендовану ціну: " + isStoreWithAllCheaper);
    }
}
