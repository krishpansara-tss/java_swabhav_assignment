package com.shopingmanagement.reposetory;

import com.shopingmanagement.exceptions.ProductNotFound;
import com.shopingmanagement.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    static Map<String, Product> allProductList = new HashMap<>();

    public static void addProduct(Product product){
        allProductList.put(product.getProductId().toUpperCase(), product);
    }

    //View All Products
    public static Map<String, Product> getAllProducts(){
        return allProductList;
    }

    //Remove Product from Shop
    public static void removeProductFromShop(String productId) {
        allProductList.remove(productId.toUpperCase());
    }

    //Add Stock of product
    public static void addStock(Product product, int stock) throws ProductNotFound {
        int finalStock = product.getProductStock() + stock;
        product.setProductStock(finalStock);
    }

    //Update Discount
    public void updateDiscount(String productId, double discount) throws ProductNotFound {
        Product product = findProductById(productId.toUpperCase());

        product.setDiscountPercentage(discount);

        System.out.println("Discount updated successfully.");
        System.out.println("Final discount percentage: " + product.getDiscountPercentage());
    }

    public Product findProductById(String productId){
        Product product = allProductList.get(productId.toUpperCase());
        if(product == null){
            throw new ProductNotFound("Product with id: " + productId + " not found");
        }
        return product;
    }

}
