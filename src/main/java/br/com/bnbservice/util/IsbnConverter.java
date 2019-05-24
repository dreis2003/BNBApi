package br.com.bnbservice.util;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import br.com.bnbservice.model.Isbn;

public class IsbnConverter implements Converter{

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class clazz) {
		return clazz.equals(Isbn.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		
		Isbn isbn = new Isbn();
		List<String> items = new ArrayList<>();
		
		if (!reader.hasMoreChildren()) {
			items.add(reader.getValue());
			isbn.setItem(items);
			return isbn;
		}
		
		while (reader.hasMoreChildren()) {
			reader.moveDown();
			items.add(reader.getValue());
			reader.moveUp();
		}
		
		isbn.setItem(items);
		return isbn;
	}

}
