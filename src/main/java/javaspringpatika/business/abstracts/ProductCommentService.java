package javaspringpatika.business.abstracts;

import javaspringpatika.core.DataResult;
import javaspringpatika.core.Result;
import javaspringpatika.entities.concretes.ProductComment;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductCommentService <T>{

    Result add(ProductComment productComment);

    Result update(ProductComment productComment);

    Result delete(int id);

    DataResult<List<T>> getAll(int productId);

    DataResult<List<T>> getAllWithCalender(int productId, LocalDateTime localDateTime);


    DataResult<T> getById(int id);
}
