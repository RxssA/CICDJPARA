package ie.atu.week4.jpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepo productRepo;
    private ProductService productService;

    public ProductController(ProductService productService, ProductRepo productRepo) {
        this.productService = productService;
        this.productRepo = productRepo;
    }

    public List<Product> getProducts() {
        return productService.findAll();
    }

    public void addProduct(Product product) {
      productService.add(product);
    }

    public void updateProduct(Long id, Product product) {
        Product updateProduct = productRepo.getReferenceById(id);
        updateProduct.setId(product.getId());
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
