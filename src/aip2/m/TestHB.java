package aip2.m;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


import aip2.m.AngebotAuftragModul.Angebot;
import aip2.m.KundenModul.Kunde;
import aip2.m.PersistenzModul.*;

public class TestHB {
 
	public static void main(String[] args) {
		
		Kunde k = new Kunde(1,"Hans", "home", new HashSet<Angebot>());
		HibernateUtil.add(k);
		List<Kunde> oL =  HibernateUtil.getAll(new Kunde());
		for (Iterator<Kunde> iterator = oL.iterator(); iterator.hasNext();) {
			Kunde k1 =  iterator.next();
			System.out.println(k1);
			System.out.println(k.equals(k1));
			
			HibernateUtil.delete(k1);		
			
		}
		
		
	
		
	}
	
}
