package coderHouse.JPA.services;

import coderHouse.JPA.entities.Product;
import coderHouse.JPA.reposotories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Obtener todos los productos
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Buscar producto por ID
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    // Buscar producto por código
    public Optional<Product> getProductByCode(String code) {
        return productRepository.findByCode(code);
    }

    // Guardar un nuevo producto
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Actualizar producto
    public Optional<Product> updateProduct(int id, Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setDescription(productDetails.getDescription());
            product.setCode(productDetails.getCode());
            product.setStock(productDetails.getStock());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        });
    }

    // Eliminar un producto
    public boolean deleteProduct(int id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

