/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author karabo68
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    
    private final ArrayList<ReportData> productList = new ArrayList<>();
    private final Scanner inputScanner = new Scanner(System.in);

    public void DisplayMenu() {
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.print("Enter (1) to launch menu or any other key to exit: ");
        String startInput = inputScanner.nextLine();

        if (!startInput.equals("1")) {
            ExitApplication();
            return;
        }

        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new product.");
            System.out.println("(2) Search for a product.");
            System.out.println("(3) Update a product.");
            System.out.println("(4) Delete a product.");
            System.out.println("(5) Print report.");
            System.out.println("(6) Exit Application.");
            System.out.print("Selection >> ");

            String choice = inputScanner.nextLine();
            switch (choice) {
                case "1":
                    CaptureProduct();
                    break;
                case "2":
                    SearchProduct();
                    break;
                case "3":
                    UpdateProduct();
                    break;
                case "4":
                    DeleteProduct();
                    break;
                case "5":
                    PrintReport();
                    break;
                case "6":
                    ExitApplication();
                    return;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }

            System.out.print("\nEnter (1) to launch menu or any other key to exit: ");
            String subChoice = inputScanner.nextLine();
            if (!subChoice.equals("1")) {
                ExitApplication();
                return;
            }
        }
    }

    public void CaptureProduct() {
        System.out.println("\nCAPTURE A NEW PRODUCT");
        System.out.print("Enter the product code: ");
        String code = inputScanner.nextLine();

        System.out.print("Enter the product name: ");
        String name = inputScanner.nextLine();

        String category = "";
        while (true) {
            System.out.println("Select the product category:");
            System.out.println("1. Desktop Computer");
            System.out.println("2. Laptop");
            System.out.println("3. Tablet");
            System.out.println("4. Printer");
            System.out.println("5. Gaming Console");
            System.out.print("Product Category >> ");
            String categoryChoice = inputScanner.nextLine();

            if (categoryChoice.equals("1")) {
                category = "Desktop Computer";
                break;
            } else if (categoryChoice.equals("2")) {
                category = "Laptop";
                break;
            } else if (categoryChoice.equals("3")) {
                category = "Tablet";
                break;
            } else if (categoryChoice.equals("4")) {
                category = "Printer";
                break;
            } else if (categoryChoice.equals("5")) {
                category = "Gaming Console";
                break;
            } else {
                System.out.println("Invalid category selected. Please enter a valid number (1-5).\n");
            }
        }

        System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years: ");
        String warrantyChoice = inputScanner.nextLine();
        String warranty = warrantyChoice.equals("1") ? "6 months" : "2 years";

        System.out.print("Enter the price for " + name + " >> ");
        double price = Double.parseDouble(inputScanner.nextLine());

        System.out.print("Enter the stock level for " + name + " >> ");
        int stock = Integer.parseInt(inputScanner.nextLine());

        System.out.print("Enter the supplier for " + name + " >> ");
        String supplier = inputScanner.nextLine();

        ReportData newProduct = new ReportData(code, name, category, warranty, price, stock, supplier);
        SaveProduct(newProduct);
    }

    public void SaveProduct(ReportData product) {
        productList.add(product);
        System.out.println("Product details has been saved successfully!!!");
    }

    public void SearchProduct() {
        System.out.print("\nPlease enter the product code to search: ");
        String code = inputScanner.nextLine();

        for (ReportData product : productList) {
            if (product.getProductCode().equalsIgnoreCase(code)) {
                System.out.println("\nPRODUCT SEARCH RESULTS");
                System.out.println("PRODUCT CODE:\t\t" + product.getProductCode());
                System.out.println("PRODUCT NAME:\t\t" + product.getProductName());
                System.out.println("PRODUCT CATEGORY:\t" + product.getProductCategory());
                System.out.println("PRODUCT WARRANTY:\t" + product.getProductWarranty());
                System.out.println("PRODUCT PRICE:\t\tR " + product.getProductPrice());
                System.out.println("PRODUCT STOCK LEVELS:\t" + product.getProductStockLevel());
                System.out.println("PRODUCT SUPPLIER:\t" + product.getProductSupplier());
                return;
            }
        }
        System.out.println("The product cannot be located. Invalid Product");
    }

    public void UpdateProduct() {
        System.out.print("\nPlease enter the product code to update: ");
        String code = inputScanner.nextLine();

        for (ReportData product : productList) {
            if (product.getProductCode().equalsIgnoreCase(code)) {
                System.out.print("Update the warranty? (y) Yes, (n) No: ");
                String updateWarranty = inputScanner.nextLine();
                if (updateWarranty.equalsIgnoreCase("y")) {
                    System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years: ");
                    String warrantyChoice = inputScanner.nextLine();
                    product.setProductWarranty(warrantyChoice.equals("1") ? "6 months" : "2 years");
                }

                System.out.print("Update the product price? (y) Yes, (n) No: ");
                String updatePrice = inputScanner.nextLine();
                if (updatePrice.equalsIgnoreCase("y")) {
                    System.out.print("Enter the new price for " + product.getProductName() + " >> ");
                    double newPrice = Double.parseDouble(inputScanner.nextLine());
                    product.setProductPrice(newPrice);
                }

                System.out.print("Update the stock level? (y) Yes, (n) No: ");
                String updateStock = inputScanner.nextLine();
                if (updateStock.equalsIgnoreCase("y")) {
                    System.out.print("Enter the new stock level for " + product.getProductName() + " >> ");
                    int newStock = Integer.parseInt(inputScanner.nextLine());
                    product.setProductStockLevel(newStock);
                }

                System.out.println("Product details has been updated successfully!!!");
                return;
            }
        }
        System.out.println("The product cannot be located. Invalid Product");
    }

    public void DeleteProduct() {
        System.out.print("\nPlease enter the product code to delete: ");
        String code = inputScanner.nextLine();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductCode().equalsIgnoreCase(code)) {
                System.out.print("Are you sure you want to delete product " + code + "? (y) Yes, (n) No: ");
                String confirm = inputScanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    productList.remove(i);
                    System.out.println("Product has been deleted successfully!");
                } else {
                    System.out.println("Product deletion cancelled.");
                }
                return;
            }
        }
        System.out.println("The product cannot be located. Invalid Product");
    }

    public void PrintReport() {
        if (productList.isEmpty()) {
            System.out.println("\nNo products available to display.");
            return;
        }
           
        System.out.println("\nPRODUCT REPORT");
            System.out.println("*******************************************************");
        double totalValue = 0;

        for (int i = 0; i < productList.size(); i++) {
            ReportData product = productList.get(i);
            System.out.println("PRODUCT " + (i + 1));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("PRODUCT CODE >>\t\t" + product.getProductCode());
            System.out.println("PRODUCT NAME >>\t\t" + product.getProductName());
            System.out.println("PRODUCT CATEGORY >>\t" + product.getProductCategory());
            System.out.println("PRODUCT WARRANTY >>\t" + product.getProductWarranty());
            System.out.println("PRODUCT PRICE >>\t" + product.getProductPrice());
            System.out.println("PRODUCT LEVEL >>\t" + product.getProductStockLevel());
            System.out.println("PRODUCT SUPPLIER >>\t" + product.getProductSupplier());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            totalValue += (product.getProductPrice() * product.getProductStockLevel());
        }

        int totalCount = productList.size();
        double averageValue = totalValue / totalCount;
            System.out.println("********************************************************");
            System.out.println("TOTAL PRODUCT COUNT: " + totalCount);
            System.out.println("TOTAL PRODUCT VALUE: R " + totalValue);
            System.out.println("AVERAGE PRODUCT VALUE: R " + Math.round(averageValue));
            System.out.println("********************************************************");
    }   

    public void ExitApplication() {
        System.out.println("Exiting Application. Goodbye!");   
                
}
  }