import Task5.InventoryService;
import Task5.OutOfStockException;
import Task5.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class Task5Tests {

    private static InventoryService is = new InventoryService();

    @BeforeAll
    public static void prepData(){
        InventoryService.setInventoryOpenFlag(true);
        Product p1 = new Product("clothes", "t-shirt", 50);
        Product p2 = new Product("clothes", "shirt", 20);
        Product p3 = new Product("clothes", "jeans", 90);
        Product p4 = new Product("clothes", "jacket", 150);

        Product p5 = new Product("tech", "tv", 3000);
        Product p6 = new Product("tech", "phone", 1000);
        Product p7 = new Product("tech", "headphones", 200);
        Product p8 = new Product("tech", "watches", 300);

        is.addProduct(p1);
        is.addProduct(p2);
        is.addProduct(p3);
        is.addProduct(p4);
        is.addProduct(p5);
        is.addProduct(p6);
        is.addProduct(p7);
        is.addProduct(p8);
    }

    private static Stream<Arguments> priceBounds(){
        return Stream.of(
                Arguments.of("clothes", 90.00, 200.00),
                Arguments.of("tech", 200.00, 1000.00)
        );
    }

    @Test
    public void addProductWhenAllowed(){
        InventoryService.setInventoryOpenFlag(true);
        Product toAdd = new Product("clothes", "vest", 50);
        is.addProduct(toAdd);
        Assertions.assertTrue(is.getProducts().get("clothes").contains(toAdd), "Product wasn't added with flag set to true");
    }

    @Test
    public void addProductWhenNotAllowed(){
        InventoryService.setInventoryOpenFlag(false);
        Product toAdd = new Product("clothes", "sneakers", 150.99);
        is.addProduct(toAdd);
        Assertions.assertFalse(is.getProducts().get("clothes").contains(toAdd), "Product was added when flag was set to false");
    }

    @Test
    public void testOutOfStockException(){
        Assertions.assertThrows(OutOfStockException.class, () -> is.getAllProductsByCategory("non-existing"),
                "Exception wasn't thrown for category which has no products");
    }

    @ParameterizedTest
    @MethodSource("priceBounds")
    public void testPriceFilter (String category, double from, double to){
        List<Product> actuallyFiltered = is.filterByPrice(category, from, to);
        Assertions.assertTrue(actuallyFiltered.stream().allMatch(p -> p.getPrice() >= from && p.getPrice() <= to),
                "Filtered list contains product which price is out of selected bounds");
    }
}
