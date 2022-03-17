package br.com.flettieri.svcheranca.api.validations;

import org.springframework.stereotype.Service;

@Service
public class CustomerValidator {

	public void validateName(String name) throws Exception {
		if (name == null || name.isEmpty()) {
			throw new Exception("Customer name must be passed");
		}
	}

	public void validateEnableEqualsTrue(boolean isEnabled) throws Exception {
		if (!isEnabled) {
			throw new Exception("Customer isn't enable");
		}
	}
	
	public void validateEnableEqualsFalse(boolean isEnabled) throws Exception {
		if (isEnabled) {
			throw new Exception("Customer isn't disable");
		}
	}
	
}
