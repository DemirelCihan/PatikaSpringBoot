package javaspringpatika.business.concretes;

import javaspringpatika.business.abstracts.ProductCommentService;
import javaspringpatika.core.DataResult;
import javaspringpatika.core.Result;
import javaspringpatika.core.SuccessDataResult;
import javaspringpatika.core.SuccessResult;
import javaspringpatika.dataAccess.abstracts.ProductCommentDao;
import javaspringpatika.entities.concretes.ProductComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductCommentManager implements ProductCommentService {

    private ProductCommentDao productCommentDao;
    @Autowired
    public ProductCommentManager(ProductCommentDao productCommentDao){
        this.productCommentDao = productCommentDao;
    }

    @Override
    public Result add(ProductComment productComment) {
        this.productCommentDao.save(productComment);
        return new SuccessResult("yeni bir yorum eklendi");
    }

    @Override
    public Result update(ProductComment productComment) {
        this.productCommentDao.save(productComment);
        return new SuccessResult("yorumlar güncellendi");

    }
    @Override
    public Result delete(int id) {
        this.productCommentDao.deleteById(id);
        return new SuccessResult("yorumlar silindi");
    }

    @Override
    public DataResult<List<ProductComment>> getAll(int productId) {
        return new SuccessDataResult<List<ProductComment>>
                (this.productCommentDao.findAll());
    }

    @Override
    public DataResult<List> getAllWithCalender(int productId, LocalDateTime localDateTime) {
//belirli tarih aralığı ile ilgili komutlar burada olacak
        return new SuccessDataResult<List<ProductComment>>
                (this.productCommentDao.getAllByComment(productId,localDateTime));
    }

    @Override
    public DataResult getById(int id) {
        return new SuccessDataResult<ProductComment>
                (this.productCommentDao.getById(id));
    }
}
