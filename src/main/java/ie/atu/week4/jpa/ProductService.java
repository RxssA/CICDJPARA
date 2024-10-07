package ie.atu.week4.jpa;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepo productRepo;
    private List<Product> productList = new ArrayList<>();

    private Product findProductById(int id) {
        for (Product product : productList) {
            if (product.getProductCode() == id) {
                return product;
            }
        }
        return null;
    }

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> add(Product product){
        productRepo.save(product);
        return productRepo.findAll();
    }
    public List<Product> deleteById(Long id){
        productRepo.deleteById(id);
        return productRepo.findAll();
    }

    public List<Product> updateById(Long id){
        Product updatedProduct = findProductById(Math.toIntExact(id));
        if (updatedProduct != null) {
            updatedProduct.setProductName(updatedProduct.getProductName());
            updatedProduct.setProductDescription(updatedProduct.getProductDescription());
            updatedProduct.setProductPrice(updatedProduct.getProductPrice());
        }
        return productRepo.findAll();
    }
}
