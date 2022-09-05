package javaspringpatika.business.concretes;

import javaspringpatika.business.abstracts.ProductService;
import javaspringpatika.core.DataResult;
import javaspringpatika.core.Result;
import javaspringpatika.core.SuccessDataResult;
import javaspringpatika.core.SuccessResult;
import javaspringpatika.dataAccess.abstracts.ProductDao;
import javaspringpatika.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;
    @Autowired
    public ProductManager(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("yeni bir ürün eklendi");
    }

    @Override
    public Result update(Product product) {
        this.productDao.save(product);
        return new SuccessResult("ürün güncellenmesi yapıldı");
    }

    @Override
    public Result delete(int id) {
        this.productDao.deleteById(id);
        return new SuccessResult("bir ürün silindi");
    }

    @Override
    public DataResult<List> getAll() { // ürünlerin listelenmesi sağlanacak
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll());
    }

    @Override
    public DataResult<List> getAllDeadlineProduct(String deadline) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getAllPullDate(deadline));
    }

    @Override
    public DataResult<List> getAllNotDeadlineProduct(String deadline, LocalDateTime localDateTime) {
        //burada lcoalDateTime ile bizim girdiğimiz dateline farkı alınarak işlem yapılacaktır.
        //.................
        //.................
        return new SuccessDataResult<List<Product>>

                (this.productDao.getAllNotPullDate(deadline,localDateTime));
    }

    @Override
    public DataResult getById(int id) {//ürünler id numaralarına göre listelenecekler
        return new SuccessDataResult<Product>
                (this.productDao.getById(id));
    }

}
