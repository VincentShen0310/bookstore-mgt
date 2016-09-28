package web;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import common.Page;
import entity.Author;
import entity.Book;
import service.AuthorService;
import service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value="/list")
	public String list(Model model,Book book,HttpServletRequest request,Page page){
		
		List<Book> list=bookService.queryBooksByCondition(book.getName(), book.getDescription(), book.getStatus(), book.getIsDisplay(), request.getParameter("authorName"), page);
		
		String currentPage = request.getParameter("currentPage");
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		if(currentPage == null ||  !pattern.matcher(currentPage).matches()) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		
		model.addAttribute("list", list);
		model.addAttribute("booksearch", book);
		request.setAttribute("authorName", request.getParameter("authorName"));
		model.addAttribute("page", page);
		return "book/list";
	}
		
	@RequestMapping(value="/{id}/detail",method=RequestMethod.GET)
	public String detail(Model model,@PathVariable("id") int id){
		if (id==0) {
			return "redirect:/book/list";
		}
		Book book=bookService.queryBookByID(id);
		if (book==null) {
			return "redirect:/book/list";
		}
		List<Author> alist=authorService.queryAllAuthors(0,100);
		model.addAttribute("bookdetail", book);
		model.addAttribute("authorlist", alist);
		return "book/detail";
	}
	
	@RequestMapping(value="/addinit")
	public String addinit(Model model){
		List<Author> alist=authorService.queryAllAuthors(0,100);
		model.addAttribute("authorlist", alist);
		return "book/add";
	}
	
	@RequestMapping(value = "/add")
	public String add(Book book) {
		bookService.addOneBook(book.getName(), book.getDescription(), book.getStatus(),book.getIsDisplay(),book.getAuthorId());
		return "redirect:/book/list";
	}
	
	@RequestMapping(value = "/{id}/edit")
	public String edit(Book book){
		bookService.updateOneBook(book.getId(), book.getName(), book.getDescription(), book.getStatus(), book.getIsDisplay(),book.getAuthorId());
		return "redirect:/book/list";
	}
	
}
