package com.shopingmanagement.services;

import com.shopingmanagement.exceptions.ProductNotFound;
import com.shopingmanagement.model.Product;
import com.shopingmanagement.reposetory.ProductRepository;

import java.util.HashMap;
import java.util.Map;

import static com.shopingmanagement.reposetory.ProductRepository.getAllProducts;

public class ProductService {

    //  Add Product to Shop
    public void addProduct(String productName, double price, double discountPercentage, int productStock){
        Product product = new Product(productName, price, discountPercentage, productStock);
        ProductRepository.addProduct(product);
        System.out.println("Product added successfully.");
    }

    //View All Products
    public void displayAllProduct(){
        Map<String, Product> allProductList = getAllProducts();

        if(allProductList.isEmpty()){
            System.out.println("No product available");
            return;
        }
        for(Product product : allProductList.values()){
            System.out.println("ID: " + product.getProductId() +
                    " | Product Name: " + product.getProductName() +
                    " | Price: " + product.getPrice() +
                    " | Available Stock: " + product.getProductStock() +
                    " | Discount: " + product.getDiscountPercentage()
            );
        }
        System.out.println("~~~~~END~~~~~");
    }

    //Remove Product from Shop
    public void removeProductFromShop(String productId) throws ProductNotFound{
        Product p = findProductById(productId);

        ProductRepository.removeProductFromShop(productId);

        System.out.println("Product with Id : " + productId + " is removed successfully");
    }

    //Add Stock of product
    public void addStock(String productId, int stock) throws ProductNotFound {
        Product product = findProductById(productId);

        ProductRepository.addStock(product, stock);

        System.out.println("Stock updated successfully.");
        System.out.println("Final stock count: " + product.getProductStock());
    }

    //Update Discount
    public void updateDiscount(String productId, double discount) throws ProductNotFound {
        Product product = findProductById(productId);

        product.setDiscountPercentage(discount);

        System.out.println("Discount updated successfully.");
        System.out.println("Final discount percentage: " + product.getProductStock());
    }

    public static Product findProductById(String productId){
        Product product = getAllProducts().get(productId.toUpperCase());
        if(product == null){
            throw new ProductNotFound("Product with id: " + productId + " not found");
        }
        return product;
    }

}
