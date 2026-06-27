import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class ex2 {
    
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }
            if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Mouse", "Electronics"),
            new Product(109, "Desk", "Furniture"),
            new Product(102, "Chair", "Furniture"),
            new Product(107, "Monitor", "Electronics")
        };

        Product foundLinear = linearSearch(products, 102);
        System.out.println("Linear Search Result: " + (foundLinear != null ? foundLinear.productName : "Not Found"));

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        Product foundBinary = binarySearch(products, 107);
        System.out.println("Binary Search Result: " + (foundBinary != null ? foundBinary.productName : "Not Found"));
    }
}