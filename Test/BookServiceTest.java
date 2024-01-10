import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testFindBookById() {
        String id = "123";
        Book book = new Book(id, "Title", "Author");
        when(bookRepository.findById(id)).thenReturn(book);

        Book result = bookService.findBookById(id);

        assertEquals(book, result);
    }

    @Test
    public void testFindAllBooks() {
        List<Book> books = Arrays.asList(
                new Book("1", "Title1", "Author1"),
                new Book("2", "Title2", "Author2")
        );
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.findAllBooks();

        assertEquals(books, result);
    }
}
