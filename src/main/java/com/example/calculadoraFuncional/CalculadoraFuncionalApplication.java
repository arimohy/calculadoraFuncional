package com.example.calculadoraFuncional;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class CalculadoraFuncionalApplication {
	static IntBinaryOperator suma = (a, b) -> a + b;
	static IntBinaryOperator resta = (a, b) -> a - b;
	static IntBinaryOperator mult = (a, b) -> {
		return IntStream.range(0, Math.abs(b) + 1)
				.reduce((acumulado, number) ->
						suma.applyAsInt(a, acumulado)).getAsInt();
	};

	public static void main(String[] args) {
		System.out.println(suma.applyAsInt(-3, 2));
        System.out.println(resta.applyAsInt(-3, 2));
		System.out.println(mult.applyAsInt(5, -10));
	}

}
