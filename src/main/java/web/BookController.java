package main.java.web;

import java.util.List;

import main.java.entity.Book;
import main.java.service.BookService;

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
	
	@RequestMapping(value="/list")
	public String list(Model model){
		List<Book> list=bookService.queryAllBooks();
		model.addAttribute("list", list);
		return "book/list";
	}

	@RequestMapping(value="/{id}/detail",method=RequestMethod.GET)
	public String detail(Model model,@PathVariable("id") int id){
		if (id==0) {
			return "forward:/book/list";
		}
		Book book=bookService.queryBookByID(id);
		if (book==null) {
			return "forward:/book/list";
		}
		return "book/detail";
	}
	
	@RequestMapping(value="/addinit")
	public String addinit(){
		return "book/add";
	}
	
	@RequestMapping(value = "/add")
	public String add(Book book) {
		bookService.addOneBook(book.getName(), book.getDescription(), 1, 1, 1);
		return "redirect:/book/list";
	}
	
	@RequestMapping(value = "/{id}/edit")
	public String edit(Book book){
		bookService.updateOneBook(book.getName(), book.getDescription(), 1, 1, 1);
		return "redirect:/book/list";
	}
	
}
