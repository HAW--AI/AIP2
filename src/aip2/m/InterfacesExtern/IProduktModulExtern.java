package aip2.m.InterfacesExtern;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import aip2.m.ProduktModul.ProduktTyp;

public interface IProduktModulExtern extends Remote {

	List<ProduktTyp> sucheProdukt(String name) throws RemoteException;
	
	ProduktTyp sucheProdukt(int id) throws RemoteException;
	
	ProduktTyp erstelleProdukt(String name, int mengeImLager) throws RemoteException;
}
