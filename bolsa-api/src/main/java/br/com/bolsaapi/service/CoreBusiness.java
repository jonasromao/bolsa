package br.com.bolsaapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bolsaapi.client.BovespaClient;
import br.com.bolsaapi.dto.Email;

@Component
public class CoreBusiness {

	@Autowired
	private BovespaClient bovespaClient;

	@Autowired
	private EmailBusiness emailBusiness;

	public void analisarAcoes() {
		String petrobras = "PETR4";

		//System.out.println( bovespaClient.getAcao( petrobras ) );

		ArrayList<String> destinatarios = new ArrayList<String>();

		destinatarios.add( "jonasromao@gmail.com" );

		Email email = new Email();
		
		email.setCorpo( "Joaquim Jose da Silva Xavier" );
		email.setTitulo( "Teste do José" );

		emailBusiness.sendMail( destinatarios, email );

	}

}
