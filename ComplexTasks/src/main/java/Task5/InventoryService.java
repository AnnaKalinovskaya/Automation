package Task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InventoryService {

    private static boolean isIventoryOpen = false;

    private HashMap<String, List<Product>> products = new HashMap<>();

    public static void setInventoryOpenFlag(boolean value){
        isIventoryOpen = value;
    }

    public static boolean getInventoryOpenFlag(){
        return isIventoryOpen;
    }

    public HashMap<String, List<Product>> getProducts(){
        return this.products;
    }

    public void addProduct(Product p){
        if (isIventoryOpen) {
            if (products.containsKey(p.getCategory())){
                List<Product> categoryProducts = products.get(p.getCategory());
                categoryProducts.add(p);
                products.put(p.getCategory(), categoryProducts);
            } else {
                List<Product> newCategoryProducts = new ArrayList<>();
                newCategoryProducts.add(p);
                products.put(p.getCategory(), newCategoryProducts);
            }
        }
    }

    public Product getOneProductByCategory(String category) throws OutOfStockException {

        if (this.products.containsKey(category) && !this.products.get(category).isEmpty()) {
            return this.products.get(category).get(0);
        }
        else throw new OutOfStockException("No products in category: " + category);
    }

    public List<Product> getAllProductsByCategory(String category) throws OutOfStockException{
        if (this.products.containsKey(category) && !this.products.get(category).isEmpty()) {
            return this.products.get(category);
        } else throw new OutOfStockException("No products in category: " + category);
    }

    public List<Product> filterByPrice(String category, double fromPrice, double toPrice){
        return this.products.get(category).stream().filter(p -> p.getPrice() >= fromPrice && p.getPrice() <= toPrice).toList();
    }








}
