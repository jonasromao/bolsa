package br.com.bolsaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bolsaapi.client.BovespaClient;

@Component
public class CoreBusiness {

	@Autowired
	private BovespaClient bovespaClient;

	public void analisarAcoes() {
		String petrobras = "PETR4";

		System.out.println( bovespaClient.getAcao( petrobras ) );

	}

}
