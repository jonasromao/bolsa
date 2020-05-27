package br.com.bolsaapi.client;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.bolsaapi.dto.PapelDTO;
import br.com.bolsaapi.enums.BovespaClientFieldsEnum;
import br.com.bolsaapi.model.PapelAnalise;

@Component
public class BovespaClient {

	private static final Logger LOGGER = LoggerFactory.getLogger( BovespaClient.class );

	private static final String GET_URL = "http://bvmf.bmfbovespa.com.br/cotacoes2000/FormConsultaCotacoes.asp?strListaCodigos=BBPO11%7C";

	public List<PapelDTO> getAcoes( List<PapelAnalise> papeisAnalise ) {

		ArrayList<PapelDTO> papeis = new ArrayList<PapelDTO>();

		papeisAnalise.forEach( papelAnalise -> {

			PapelDTO papelDTO = getAcao( papelAnalise.getPapel().getCodigo() );
			if( papelDTO != null ) {
				papeis.add( papelDTO );
			}
		} );

		return papeis;
	}

	public PapelDTO getAcao( String codigoAcao ) {

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

			PapelDTO papelDTO = toPapelDTO(acao);

			LOGGER.info( "Ação preenchida com sucesso" );
			LOGGER.info( "Finalizado processo" );

			return papelDTO;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
	
	private PapelDTO toPapelDTO(Node nodeAcao) {
		
		Element element = ( Element ) nodeAcao;

		PapelDTO papel = new PapelDTO();

		papel.setAbertura( Double.valueOf( element.attribute( BovespaClientFieldsEnum.Abertura.name() ).getValue().replace( ",", "." ) ) );
		papel.setCodigo( element.attribute( BovespaClientFieldsEnum.Codigo.name() ).getValue() );
		papel.setData( element.attribute( BovespaClientFieldsEnum.Data.name() ).getValue() );
		papel.setNome( element.attribute( BovespaClientFieldsEnum.Nome.name() ).getValue() );
		papel.setMinimo( Double.valueOf( element.attribute( BovespaClientFieldsEnum.Minimo.name()).getValue().replace( ",", "." ) ) );
		papel.setMaximo( Double.valueOf( element.attribute( BovespaClientFieldsEnum.Maximo.name() ).getValue().replace( ",", "." ) ) );
		papel.setMedio( Double.valueOf( element.attribute( BovespaClientFieldsEnum.Medio.name() ).getValue().replace( ",", "." ) ) );
		papel.setUltimo( Double.valueOf( element.attribute( BovespaClientFieldsEnum.Ultimo.name() ).getValue().replace( ",", "." ) ) );
		papel.setOscilacao( Double.valueOf( element.attribute( BovespaClientFieldsEnum.Oscilacao.name()).getValue().replace( ",", "." ) ) );
		
		return papel;
		
	}
}
