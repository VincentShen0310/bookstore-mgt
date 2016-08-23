package main.java.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import main.java.entity.Author;
import main.java.service.AuthorService;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value="/list")
	public String list(Model model,Author author){
		List<Author> list=authorService.queryAuthorsByCondition(author.getName(), author.getDescription(), author.getStatus(), author.getIsDisplay());
		model.addAttribute("authorsearch", author);
		model.addAttribute("list", list);
		return "author/list";
	}
	
	@RequestMapping(value="/{id}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model model){
		if (id==0) {
			return "forward:/author/list";
		}
		Author author=authorService.queryAuthorByID(id);
		if (author==null) {
			return "forward:/author/list";
		}
		model.addAttribute("authordetail", author);
		return "author/detail";
	}
	
	@RequestMapping(value="/addinit")
	public String addinit(){
		return "author/add";
	}
	
	@RequestMapping(value = "/add")
	public String add(Author author) {
		authorService.addOneAuthor(author.getName(), author.getDescription(),author.getStatus(),author.getIsDisplay(), 1);
		return "redirect:/author/list";
	}
	
	@RequestMapping(value = "/{id}/edit")
	public String edit(Author author) throws IOException{
		authorService.updateOneAuthor(author.getId(), author.getName(), author.getDescription(),author.getStatus(), author.getIsDisplay());
		return "redirect:/author/list";
	}
	
	@RequestMapping(value="/uploadinit")
	public String uploadinit(){
		return "author/upload";
	}
	
	
	@RequestMapping(value = "/upload")
	@ResponseBody
	public String upload(@RequestParam("upfile") MultipartFile file,HttpServletRequest request) throws IOException{
		
		String realPath = request.getSession().getServletContext().getRealPath("/resources/images/author");   
		if (!file.isEmpty()) {
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File(realPath, file.getOriginalFilename()));
		}
		return "redirect:/author/list";
	}
	
	@RequestMapping(value = "/{id}/download")
	@ResponseBody
	public ResponseEntity<byte[]> download(Author author) throws IOException{
		String path="D:\\17992\\"+author.getId()+".png";  
        File file=new File(path);  
        HttpHeaders headers = new HttpHeaders();    
        String fileName=new String((String.valueOf(author.getId())+".png").getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
        headers.setContentDispositionFormData("attachment", fileName);   
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);  
		
	}
	
}
