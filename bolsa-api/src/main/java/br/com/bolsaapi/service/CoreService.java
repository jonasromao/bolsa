package br.com.bolsaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.bolsaapi.client.BovespaClient;

@Component
@EnableScheduling
public class CoreService {

	@Autowired
	private BovespaClient bovespaClient;

	@Scheduled( cron = "0 0/2 10-17 * * *" )
	public void analisarAcoes() {
		String petrobras = "PETR4";

		System.out.println( bovespaClient.getAcao( petrobras ) );

	}

}
