package javaspringpatika.dataAccess.abstracts;

import javaspringpatika.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
List<Product> getAllPullDate (String deadline ); //product entity sınıfından deadline bilgisini alacak
//son kullanım tarihi entityde String olarak tutulmaktadır.
List<Product> getAllNotPullDate(String deadline, LocalDateTime localDateTime);
}
