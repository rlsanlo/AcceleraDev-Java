package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		int nextNumber = 0;
		List<Integer> listFibonacci = new ArrayList();
		List<Integer> listFibonacci1 = listFibonacci;
		listFibonacci1.add(0);
		listFibonacci1.add(1);
		while (nextNumber <= 350){
			int i = listFibonacci1.size() - 1;
			nextNumber = listFibonacci1.get(i) + listFibonacci1.get( i - 1);
			listFibonacci1.add(nextNumber);
		}

		return listFibonacci1;
	}

	public static Boolean isFibonacci(Integer number) {
		return fibonacci().contains(number);
	}

}