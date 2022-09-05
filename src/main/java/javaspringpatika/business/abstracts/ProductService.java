package javaspringpatika.business.abstracts;

import javaspringpatika.core.DataResult;
import javaspringpatika.core.Result;
import javaspringpatika.entities.concretes.Product;
import javaspringpatika.entities.concretes.ProductComment;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService <T>{
    Result add(Product product);

    Result update(Product product);

    Result delete(int id);

    DataResult<List<T>> getAll();

    DataResult<List<T>> getAllDeadlineProduct(String deadline);

    DataResult<List<T>> getAllNotDeadlineProduct(String deadline,LocalDateTime localDateTime);

    DataResult<T> getById(int id);
}
