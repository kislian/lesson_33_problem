package pro.sky.demo.services;

import org.springframework.stereotype.Service;
import pro.sky.demo.model.Book;
import pro.sky.demo.repositories.BookRepository;

import java.util.Collection;

@Service
public class BookService {
     //создаём хранилище для наших книг
    //хэш мап по ключу идентификатор + сама книга
    //называем эту хэш мапу books  и стразу её инициализируем
    //хэш мапа нам теперь не нужна
   //private final HashMap<Long, Book> books=new HashMap<>();
    //repositoty прослойка между базой данных и сервисом
    //увеличение идентификатора передаём базе данных
    //private long lastId=0;
    //метод принимает в качестве аргумента книгу
    //его задача давать новый идентификатор добавленной книге
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   //получаем готовую книгу из http запроса и сохраняем в базу
    public Book createBook(Book book){
        //используем методы springa
     return bookRepository.save(book);
    };
//есть иденитфикатор который можем получить из контроллера хотим получить книгу с этим идентификатором
    public Book findBook(long id) {
        return bookRepository.findById(id).get();
    }

    //если найдёт то заменет, если нет дабавит новую строку в конец
    public Book editBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(long id){
       bookRepository.deleteById(id);
    }

    public Collection<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
