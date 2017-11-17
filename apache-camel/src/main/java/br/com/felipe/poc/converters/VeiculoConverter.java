package br.com.felipe.poc.converters;

import java.io.InputStream;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.TypeConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.felipe.poc.domain.Veiculo;

@Converter
public final class VeiculoConverter {
	@Converter
	public static Veiculo toPurchaseOrder(InputStream is, Exchange exchange) {

		Veiculo veiculo = null;
		
		TypeConverter converter = exchange.getContext().getTypeConverter();
		String texto = converter.convertTo(String.class, is);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			veiculo = mapper.readValue(texto, Veiculo.class);
		} catch(Exception e) {
			e.printStackTrace();
		}

		return veiculo;
	}
}