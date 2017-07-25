package BookstoreTest;

import java.util.List;

import org.fkit.bookstore.domain.Book;
import org.fkit.bookstore.service.BookstoreService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BookTest extends BaseJunit{
	/**
	 * 自动注入BookstoreService
	 */
	@Autowired
	@Qualifier("bookstoreService")
	private BookstoreService bookstoreService;
	
	//测试getAllOneBook
	@Test
	public void getAllOneBookTest(){
		List<Book> bookList = bookstoreService.getAllOneBook();
		System.out.println("测试小说类");
		System.out.println(bookList);
	}
	
	//测试getAllTwoBook
	@Test
	public void getAllTwoBookTest(){
		List<Book> bookList = bookstoreService.getAllTwoBook();
		System.out.println("测试文学类");
		System.out.println(bookList);
	}
	
	//测试getAllThreeBook
	@Test
	public void getAllThreeBookTest(){
		List<Book> bookList = bookstoreService.getAllThreeBook();
		System.out.println("测试历史类");
		System.out.println(bookList);
	}
	
	//测试getAllTwoBook
	@Test
	public void getAllFourookTest(){
		List<Book> bookList = bookstoreService.getAllFourBook();
		System.out.println("测试科技类");
		System.out.println(bookList);
	}
	
	//测试getBookDetail
	@Test
	public void GetBookDetailTest(){
		Integer bookID=1;
		Book bookGetBookDetail=bookstoreService.getBookDetail(bookID);
		System.out.println(bookGetBookDetail);
	}
	
	
}
