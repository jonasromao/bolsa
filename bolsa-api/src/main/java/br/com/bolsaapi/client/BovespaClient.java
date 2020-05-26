package br.com.bolsaapi.client;

import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.bolsaapi.dto.Papel;

@Component
public class BovespaClient {

	private static final Logger LOGGER = LoggerFactory.getLogger( BovespaClient.class );

	private static final String GET_URL = "http://bvmf.bmfbovespa.com.br/cotacoes2000/FormConsultaCotacoes.asp?strListaCodigos=BBPO11%7C";

	public Papel getAcao( String codigoAcao ) {

		try {

			LOGGER.info( "Iniciado processo de consulta da ação: " + codigoAcao );

			SAXReader reader = new SAXReader();

			Document doc = reader.read( new URL( GET_URL + codigoAcao ).openStream() );

			List<Node> nodeList = doc.selectNodes( "ComportamentoPapeis" );

			if( nodeList == null || nodeList.isEmpty() ) {
				return null;
			}

			List<Node> papeis = nodeList.get( 0 ).selectNodes( "Papel" );

			if( papeis == null || papeis.isEmpty() || papeis.size() == 1 ) {
				LOGGER.warn( "Nenhuma ação encontrada com o código: " + codigoAcao );
				return null;

			}

			LOGGER.info( "Ação retornada com sucesso" );

			Node acao = papeis.get( 1 );

			Element element = ( Element ) acao;

			Papel papel = new Papel();

			papel.setAbertura( element.attribute( "Abertura" ).getValue() );
			papel.setCodigo( element.attribute( "Codigo" ).getValue() );
			papel.setData( element.attribute( "Data" ).getValue() );
			papel.setNome( element.attribute( "Nome" ).getValue() );
			papel.setMinimo( element.attribute( "Minimo" ).getValue() );
			papel.setMaximo( element.attribute( "Maximo" ).getValue() );
			papel.setMedio( element.attribute( "Medio" ).getValue() );
			papel.setUltimo( element.attribute( "Ultimo" ).getValue() );
			papel.setOscilacao( element.attribute( "Oscilacao" ).getValue() );

			LOGGER.info( "Ação preenchida com sucesso" );
			LOGGER.info( "Finalizado processo" );

			return papel;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
}
