package br.com.bytebank.banco.test.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TesteDiferencasDeListagens {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		List<Pessoa> pessoas = new LinkedList<Pessoa>();
		
		for (Long i = 0l; i < 1000000; i++) {
			pessoas.add(new Pessoa(i));
		}
		
		for (Long i = 500l; i < 10000; i++) {
			pessoas.remove(new Pessoa(i));
		}
		
		System.out.println("Demorou: " + (System.currentTimeMillis() - start) + " ms");

	}
	
	public static class Pessoa {
		
		public Pessoa(Long id) {
			super();
			this.id = id;
		}

		private Long id;

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pessoa other = (Pessoa) obj;
			return Objects.equals(id, other.id);
		}



	}

}
