package br.com.bnbservice.util;

import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

import br.com.bnbservice.model.Book;

public class WriteCsvToResponse {

	private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);

	@SuppressWarnings("unchecked")
	public static void writeBook(PrintWriter writer, Book book) {

		try {

			StatefulBeanToCsv<Book> btcsv = new StatefulBeanToCsvBuilder<Book>(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(';').build();

			btcsv.write(book);

		} catch (CsvException ex) {

			LOGGER.error("Error ao mapear Book para CSV", ex);
		}
	}

}
