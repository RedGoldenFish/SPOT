package main;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Field;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("bonjour");
		//SYS_INIT
		Sys_init sysinit = new Sys_init();
		Field zr = sysinit.params.getZr();
		
		Element x = zr.newRandomElement();
		System.out.println(x.toBigInteger());
		//x.powZn(zr.newRandomElement());
		x.duplicate().powZn(zr.newRandomElement());
		System.out.println(x.toBigInteger());
	}

}
