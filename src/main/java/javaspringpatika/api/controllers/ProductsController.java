package javaspringpatika.api.controllers;

import javaspringpatika.business.abstracts.ProductService;
import javaspringpatika.core.DataResult;
import javaspringpatika.core.Result;
import javaspringpatika.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {
    private ProductService productService;
    @Autowired
    public ProductsController(ProductService productService){
       this.productService = productService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Product product){
        return this.productService.update(product);

    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.productService.delete(id);
    }
    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getAllDeadlineProduct")
    public DataResult<List<Product>> getAllDeadlineProduct(@RequestParam String deadline){
        return this.productService.getAllDeadlineProduct(deadline);
        //son kullanma tarihi geçen ürünlerin listelenmesi
    }

    @GetMapping("/getAllNotDeadlineProduct")
    public DataResult<List<Product>> getAllNotDeadlineProduct(@RequestParam String deadline, LocalDateTime localDateTime){
        return this.productService.getAllNotDeadlineProduct(deadline,localDateTime);
    //son kullanma tarihi geçmeyen ürünlerin listelenmesi.
    }


    @GetMapping("/getById")
    public DataResult<Product> getById(@RequestParam int id){
        return this.productService.getById(id);
    }





}
