package ua.lviv.iot.manager;

import ua.lviv.iot.model.Product;
import ua.lviv.iot.model.ProductType;
import ua.lviv.iot.processor.impl.iShopManager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopManager implements iShopManager {
    public String nameOFManager;

    public ShopManager(String nameOFManager) {
        this.nameOFManager = nameOFManager;
    }

    private List<Product> productList = new ArrayList<>();


    @Override
    public void addProductToTheList(Product product) {
        productList.add(product);
    }

    @Override
    public void deleteProductFromTheList(Product product) {
        productList.remove(product);
    }

    @Override
    public void sortListBYPrice() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice() - p2.getPrice();
            }
        });
    }

    @Override
    public void sortListByVolume() {
        productList.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getVolume() - p2.getVolume();
            }
        });
    }

    @Override
    public void printListOfProduct() {
        System.out.println(productList.toString());

    }

    @Override
    public void findProductByProductType(ProductType productType) {
        List<Product> filteredList = productList.stream()
                .filter(product -> product.getProductType() == productType).collect(Collectors.toList());
        System.out.println(filteredList);
    }
}
