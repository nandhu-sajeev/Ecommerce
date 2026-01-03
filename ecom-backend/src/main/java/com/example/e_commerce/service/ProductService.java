package com.example.e_commerce.service;

import com.example.e_commerce.model.Product;
import com.example.e_commerce.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private JobRepo jobRepo;

    public List<Product> getAllProducts() {
        return jobRepo.findAll();
    }

    public Product getProductById(int id) {
        return jobRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return jobRepo.save(product);
    }

    public void deleteProduct(int id) {
        jobRepo.deleteById(id);
    }

    public List<Product> searchProduct(String keyword) {
        return jobRepo.searchProduct(keyword);
    }
}
