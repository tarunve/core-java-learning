package com.realworld.example.model.api;

import java.math.BigDecimal;

public interface Amount {
	BigDecimal getValue();

	Currency getCurrency();
}
