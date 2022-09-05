package javaspringpatika.dataAccess.abstracts;

import javaspringpatika.entities.concretes.ProductComment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductCommentDao extends JpaRepository<ProductComment,Integer> {
List<ProductComment> getAllByComment( int productId, LocalDateTime localDateTime);

}
