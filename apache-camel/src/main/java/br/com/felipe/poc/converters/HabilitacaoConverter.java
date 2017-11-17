package br.com.felipe.poc.converters;
import java.io.InputStream;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.felipe.poc.domain.Habilitacao;

@Converter
public final class HabilitacaoConverter {
	@Converter
	public static Habilitacao toHabilitacao(InputStream is, Exchange exchange) {

		Habilitacao habilitacao = null;
		
		TypeConverter converter = exchange.getContext().getTypeConverter();
		String texto = converter.convertTo(String.class, is);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			habilitacao = mapper.readValue(texto, Habilitacao.class);
		} catch(Exception e) {
			e.printStackTrace();
		}

		return habilitacao;
	}
}