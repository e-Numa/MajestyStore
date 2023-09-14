package com.enuma.helper;

import com.enuma.enums.ProductCategory;
import com.enuma.model.ProductProperties;
import com.enuma.model.Stock;

import java.io.*;
import java.util.Map;

public class Updates {
    public static boolean addProductToStore() {
        File file = new File("./src/main/resources/stockList.csv");
        String line = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length == 4 && !row[0].equalsIgnoreCase("name")) {
                    String name = row[0];
                    ProductCategory cat = Sorter.getProductCategory(row[1]);
                    double price = Double.parseDouble(row[2]);
                    int quantity = Integer.parseInt(row[3]);

                    ProductProperties newProduct = new ProductProperties(name, cat, price, quantity);

                    Sorter.getProductMapByCategory(cat).put(name, newProduct);
                    Stock.getTotalProducts().put(name, newProduct);
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not Found" + e);
        } catch (IOException e) {
            System.out.println("Input or Output error" + e);
        }
        return false;
    }

    public static boolean updateStoreRecord() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/resources/store_productList.csv"))) {
            // Write the header
            writer.write("Name,Category,Price,Quantity\n");

            // Write the products for each category
            writeProductCategory(writer);
            return true;
        } catch (IOException e) {
            System.out.println("Error updating store record: " + e.getMessage());
            return false;
        }
    }

    private static void writeProductCategory(Writer writer) throws IOException {
        Map<String, ProductProperties> productMap = Stock.getTotalProducts();

        for (ProductProperties product : productMap.values()) {
            String name = product.getName();
            ProductCategory category = product.getCAT();
            double price = product.getPrice();
            int quantity = product.getQuantity();
            writer.write(String.format("%s,%s,%.2f,%d\n", name, category, price, quantity));
        }
    }

    public static void viewItems(String category) {
        try {
            ProductCategory categoryEnum = ProductCategory.valueOf(category.toUpperCase());
            Map<String, ProductProperties> productPropertiesMap = Sorter.getProductMapByCategory(categoryEnum);

            if (productPropertiesMap != null) {
                System.out.println('\n' + "     Sort Product Category");
                System.out.println("______________________________________");
                System.out.println("Name" + "            " + "Price" + "         " + "Quantity");
                for (var item : productPropertiesMap.values()) {
                    System.out.printf("%-15s %-15s %-15s", item.getName(), "₦ " + item.getPrice(), item.getQuantity());
                    System.out.println();
                }
            } else {
                System.out.println("Invalid product category: " + category);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid product category: " + category);
        }
    }

    public static boolean addProductToCsvFile(String name, ProductCategory category, double price, int quantity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./src/main/resources/store_productList.csv", true))) {

            // Append the new product to the CSV file
            writer.write(String.format("%s,%s,%.2f,%d\n", name, category, price, quantity));

            // Create a new ProductProperties instance and add it to the appropriate map
            Updates.addProductToStore();
            System.out.println("Product Added Successfully");

            return true;
        } catch (IOException e) {
            System.out.println("Error adding product to store: " + e.getMessage());
            return false;
        }
    }
}
