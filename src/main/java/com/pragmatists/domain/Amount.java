package com.pragmatists.domain;

import java.text.DecimalFormat;

public class Amount {

	private int value;

	public Amount(int value) {
		this.value = value;
	}

	public static Amount amountOf(int value) {
		return new Amount(value);
	}

	public Amount plus(Amount otherAmount) {
		this.value += otherAmount.value;
		return this;
	}

	public boolean isGreaterThan(Amount otherAmount) {
		return this.value > otherAmount.value;
	}

	public Amount absoluteValue() {
		return amountOf(Math.abs(value));
	}

	public String moneyRepresentation() {
		return new DecimalFormat("#.00").format(value);
	}

	public Amount negative() {
		return amountOf(-value);
	}

	@Override
	public boolean equals(Object obj) {
		Amount other = (Amount) obj;
		return value == other.value;
	}

	@Override
	public String toString() {
		return moneyRepresentation();
	}
}
