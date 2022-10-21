package br.com.desafios.mibs;

public class MibFactory {

  private MibFactory() {}
  
  public static Mib getMib(MibEnum mib) {
    
    switch(mib) {
      case MIB1:
        return new Mib1();
        
      case MIB2:
        return new Mib2();
        
      case MIB3:
        return new Mib3();
        
      default:
        return null;
    }
  }
  
}
