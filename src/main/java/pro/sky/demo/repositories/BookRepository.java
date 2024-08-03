package pro.sky.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.demo.model.Book;

//Book сущность с которой работаем
//Long тип идентификатора
public interface BookRepository extends JpaRepository<Book,Long>{
    //методы не указываем за нас это сделаеть spring

}
