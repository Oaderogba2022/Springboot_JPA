package ie.atu.week4.jpa;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

   public List<Product> add(Product product){
        productRepository.save(product);
        return productRepository.findAll();

   }

    public boolean deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);  // Delete the product
            return true;
        }
        return false;  // Return false if product is not found
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductDescription(updatedProduct.getProductDescription());
            existingProduct.setProductPrice(updatedProduct.getProductPrice());
            existingProduct.setProductCode(updatedProduct.getProductCode());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }



}
