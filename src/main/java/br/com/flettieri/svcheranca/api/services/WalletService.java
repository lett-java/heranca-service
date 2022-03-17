package br.com.flettieri.svcheranca.api.services;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flettieri.svcheranca.api.models.Wallet;
import br.com.flettieri.svcheranca.api.repositories.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	public Wallet save(Wallet wallet) {
		wallet.setUuid(UUID.randomUUID().toString());
		wallet.setBalanceUsed(BigDecimal.ZERO);
		wallet.setBalance(BigDecimal.ZERO);
		
		return walletRepository.save(wallet);
	}
	
	public void insertBalance(Wallet wallet, BigDecimal amount) {
		wallet.setBalance(wallet.getBalance().add(amount));
		
		walletRepository.save(wallet);
	}
	
	
}
