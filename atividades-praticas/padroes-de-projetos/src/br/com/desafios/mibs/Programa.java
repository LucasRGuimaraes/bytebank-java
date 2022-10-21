package br.com.desafios.mibs;

public class Programa {

  public static void main(String[] args) {
    
    Mib mib = MibFactory.getMib(MibEnum.MIB3);
    
    System.out.println(mib.getOidC());
    
  }

}
