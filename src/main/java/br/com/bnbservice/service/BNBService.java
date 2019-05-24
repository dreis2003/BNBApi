package br.com.bnbservice.service;

import java.net.ConnectException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thoughtworks.xstream.XStream;

import br.com.bnbservice.model.Book;
import br.com.bnbservice.model.Isbn;
import br.com.bnbservice.model.Result;
import br.com.bnbservice.util.IsbnConverter;

@Service
public class BNBService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BNBService.class);

	public Result searchAPI(String id) throws ConnectException {

		Result result = null;

		RestTemplate restTemplate = new RestTemplate(); // 1
		String url = "http://bnb.data.bl.uk/doc/resource/" + id.toString().trim() + ".xml";
		try {
			ResponseEntity<String> response2 = restTemplate.getForEntity(url, String.class);

			String body = response2.getBody();
			System.out.println(body);
			XStream xstream = new XStream();
			xstream.alias("result", Result.class);
			xstream.alias("isbn", Isbn.class);
			xstream.alias("item", List.class);

			xstream.ignoreUnknownElements();
			xstream.registerConverter(new IsbnConverter());

			result = (Result) xstream.fromXML(body);

			LOGGER.info(result.toString());

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	public Book createBook(Result result) {
		Book book = new Book();

		if (result != null) {
			book.setResultLabel(result.getLabel() != null ? result.getLabel() : null);
		} else {
			return null;
		}

		if (result.getPrimaryTopic() != null) {
			book.setResultPrimaryTopicTitle(
					result.getPrimaryTopic().getTitle() != null ? result.getPrimaryTopic().getTitle() : null);
			book.setResultPrimaryTopicIsbn(
					result.getPrimaryTopic().getIsbn() != null ? result.getPrimaryTopic().getIsbn().getItem().toString()
							: null);
			book.setResultPrimaryTopicAuthorLabel(
					result.getPrimaryTopic().getAuthor() != null ? result.getPrimaryTopic().getAuthor().getLabel()
							: null);
			book.setResultPrimaryTopicDatePublished(
					result.getPrimaryTopic().getDatePublished() != null ? result.getPrimaryTopic().getDatePublished()
							: null);
		}

		return book;
	}

}
