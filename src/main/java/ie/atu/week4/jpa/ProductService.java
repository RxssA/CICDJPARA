package ie.atu.week4.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public void add(Product product){
        productRepo.save(product);
    }
    public List<Product> deleteById(Long id){
        productRepo.deleteById(id);
        return productRepo.findAll();
    }

    public void update(Long id, Product product){
        Product updatedProduct = productRepo.getReferenceById(id);
        updatedProduct.setProductName(updatedProduct.getProductName());
        updatedProduct.setProductDescription(updatedProduct.getProductDescription());
        updatedProduct.setProductPrice(updatedProduct.getProductPrice());
    }
}
