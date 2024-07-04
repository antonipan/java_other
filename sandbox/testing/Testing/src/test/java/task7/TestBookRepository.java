package homework4;

import homework4.book.Book;
import homework4.book.BookRepository;
import homework4.book.BookService;
import homework4.book.InMemoryBookRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class TestBookRepository {


    @Test
    void testBookService() {
        InMemoryBookRepository bookRepositoryM = mock(InMemoryBookRepository.class);
        BookService bookService = new BookService(bookRepositoryM);
        when(bookService.findBookById("1")).thenReturn(new Book("1"));

        List<Book> book = new ArrayList<>();
        assertNotNull(bookRepositoryM);
        when(bookService.findAllBooks()).thenReturn(book);

        book.add(new Book("1", "Book1", "Author1"));
        book.add(new Book("2", "Book2", "Author2"));
        book.add(new Book("3", "Book3", "Author3"));

    }
}
