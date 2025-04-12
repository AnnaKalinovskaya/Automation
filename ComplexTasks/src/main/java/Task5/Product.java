package Task5;

import java.util.Objects;

public class Product {

    private String name;
    private double price;
    private String category;

    public Product(String category, String name, double price){
        this.category = category.toLowerCase();
        this.name = name.toLowerCase();
        this.price = price;
    }

    public String getCategory(){
        return this.category;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String toString(){
        return "Category: " + this.category + "; Product name: " + this.name + "; Price: " + this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }
}
