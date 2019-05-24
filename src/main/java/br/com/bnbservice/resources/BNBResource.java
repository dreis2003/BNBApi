package br.com.bnbservice.resources;

import java.io.IOException;
import java.net.ConnectException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bnbservice.model.Book;
import br.com.bnbservice.model.Result;
import br.com.bnbservice.service.BNBService;
import br.com.bnbservice.util.WriteCsvToResponse;

@RestController
public class BNBResource {

	@Autowired
	private BNBService service;
	private Result result;

	@GetMapping(value = "/consulta/id/{bookId}", produces = "text/csv")
	public void findBook(@PathVariable String bookId, HttpServletResponse response) throws IOException {
		

		try {
			result = service.searchAPI(bookId);

			if (result != null && !result.getLabel().equals("1")) {
	
				Book book = service.createBook(result);
	
				String filename = "book-"+bookId+".csv";
	
				response.setContentType("text/csv");
				response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
				WriteCsvToResponse.writeBook(response.getWriter(), book);
			} else {
				response.getWriter().write("Book not found!");
			}
		} catch (ConnectException e) {
			response.getWriter().write("Errou de conexão com a API da BNB ->" + e.getMessage());
		}
	}

}
