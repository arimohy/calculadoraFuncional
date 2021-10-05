package com.example.calculadoraFuncional;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class CalculadoraFuncionalApplication {
	static IntBinaryOperator suma = (a, b) -> a + b;
	static IntBinaryOperator resta = (a, b) -> a - b;
	static IntBinaryOperator mult = (a, b) -> {
		Integer repeticion= IntStream.range(0, Math.abs(b) + 1)
				.reduce((acumulado, number) ->
						suma.applyAsInt(Math.abs(a), acumulado)).getAsInt();
		if((a<0 && b>0)|| (a>0 && b<0))
			return resta.applyAsInt(0,repeticion);
		return repeticion;
	};
	static IntBinaryOperator div = (a, b) -> {
		return IntStream.range(0, Math.abs(a) + 1)
				.reduce((acumulado, number) -> {
					if(mult.applyAsInt(number,b)<=a)
						acumulado++;
					return acumulado;
				}).getAsInt();

	};

	public static void main(String[] args) {
		System.out.println("=======CALCULADORA FUNCIONAL========");
		System.out.println("Ejemplos de operaciones");
		System.out.println(suma.applyAsInt(-3, 2));
        System.out.println(resta.applyAsInt(-3, 2));
		System.out.println(mult.applyAsInt(5, -7));
		System.out.println(div.applyAsInt(101, 10));
	}

}
