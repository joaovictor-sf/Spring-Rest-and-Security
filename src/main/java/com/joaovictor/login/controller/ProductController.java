package com.joaovictor.login.controller;

import com.joaovictor.login.domain.Product;
import com.joaovictor.login.domain.ProductDTO;
import com.joaovictor.login.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    //Alguns dos metodos feitos nessa classe seriam mais adequados em uma classe de servico, mas como o projeto e pequeno, optei por deixar aqui mesmo.

    @GetMapping
    public ResponseEntity getAllProduct() {
        var products = productRepository.findAllByActiveTrue();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Validated ProductDTO data) {
        Product product = new Product(data);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Validated ProductDTO data) {
        Optional<Product> optionalProduct = productRepository.findById(data.id());
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            //productRepository.save(product);
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    //@DeleteMapping("/{id}")
    //public ResponseEntity deleteProduct(@PathVariable String id) {
    //    productRepository.deleteById(id);
    //    return ResponseEntity.notFound().build();
    //}

    //Como deletar o produto pode causar problemas futuros, optei por apenas desativar o produto, assim, ele nao aparece mais na lista de produtos, mas ainda esta no banco de dados.

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setActive(false);
            //productRepository.save(product);
            return ResponseEntity.noContent().build();
        }
        throw new EntityNotFoundException();
    }
}
