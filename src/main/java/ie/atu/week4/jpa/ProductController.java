package ie.atu.week4.jpa;

import jakarta.validation.Valid;
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
    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.findAll();
    }
    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody  Product product) {
      productService.add(product);
      return product;
    }
    @PutMapping("/update/{id}")
    public Product updateProduct(@Valid @PathVariable Long id,@Valid @RequestBody Product product) {
        productService.update(id, product);
        return product;
    }
    @DeleteMapping("/remove/{id}")
    public void deleteProduct(@Valid @PathVariable Long id) {
        productRepo.deleteById(id);
    }
}
