package mate.academy.springboot.swagger.service;

import java.math.BigDecimal;
import mate.academy.springboot.swagger.model.Product;
import mate.academy.springboot.swagger.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product update(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Page<Product> findAllByPriceBetweenWithSort(BigDecimal from,
                                                       BigDecimal to,
                                                       PageRequest pageRequest) {
        return (Page<Product>) productRepository.findAllByPriceBetween(from, to, pageRequest);

    }

    @Override
    public Page<Product> findAllWithSort(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }
}