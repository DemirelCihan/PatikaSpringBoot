package javaspringpatika.api.controllers;

import javaspringpatika.business.abstracts.ProductCommentService;
import javaspringpatika.core.DataResult;
import javaspringpatika.core.Result;
import javaspringpatika.entities.concretes.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/productComments")
@CrossOrigin
public class ProductCommentsController {
    private ProductCommentService productCommentService;
    @Autowired
    public ProductCommentsController(ProductCommentService productCommentService){
        this.productCommentService = productCommentService;
    }
    @PostMapping("/add")
    public Result add (@RequestBody ProductComment productComment){
        return this.productCommentService.add(productComment);
    }
    @PutMapping("/update")
    public Result update(@RequestBody ProductComment productComment){
        return this.productCommentService.update(productComment);
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.productCommentService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<ProductComment>>getAll(@RequestParam int productId){//bir ürüne ait yorumlar listelenecektir.
        return this.productCommentService.getAll(productId);
    }
    @GetMapping("/getAllWithCalender")
    public DataResult<List<ProductComment>> getAllWithCalender(@RequestParam int productId, LocalDateTime localDateTime){
        return this.productCommentService.getAllWithCalender(productId,localDateTime);
    }


    @GetMapping("/getById")
    public DataResult<ProductComment> getById(@RequestParam int id){
        return this.productCommentService.getById(id);
    }
}
