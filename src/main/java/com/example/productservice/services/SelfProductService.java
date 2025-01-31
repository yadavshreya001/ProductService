package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to DB to fetch a product with given id.
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist");
        }

        return productOptional.get();
    }

//    @Override
//    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
//
    ////        Sort sort = Sort.by("price").ascending().and(Sort.by("title").descending())
    ////        Sort.by("price").ascending().and(Sort.by("title").ascending().and(Sort.by("quantity").ascending()
//
//        return productRepository.findAll(
//                PageRequest.of(pageNumber,
//                        pageSize,
//                        Sort.by("price").ascending())
//        );
//    }

    @Override
    public List<Product> getAllProducts() {

//        Sort sort = Sort.by("price").ascending().and(Sort.by("title").descending())
//        Sort.by("price").ascending().and(Sort.by("title").ascending().and(Sort.by("quantity").ascending()

//        return productRepository.findAll(
//                PageRequest.of(pageNumber,
//                        pageSize,
//                        Sort.by("price").ascending())
//        );

        return productRepository.findAll();
    }

    //PATCH
    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist");
        }

        Product productInDB = optionalProduct.get();

        if (product.getTitle() != null) {
            productInDB.setTitle(product.getTitle());
        }

        if (product.getPrice() != null) {
            productInDB.setPrice(product.getPrice());
        }

        return productRepository.save(productInDB);
    }

    //PUT
    //TODO
    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();

//        if (category.getId() == null) {
//            // We need to create a new Category object in the DB first.
//            category = categoryRepository.save(category);
//            product.setCategory(category);
//        }

        return productRepository.save(product);
    }
}