package fr.supinfo.webservice;

import java.util.List;

import javax.jws.WebService;

import fr.supinfo.dao.DaoFactory;
import fr.supinfo.entities.Voyage;

public class WebServiceImpl implements IWebService {
	DaoFactory dao;
	@Override
	public List<Voyage> getAllTrip() {	
		return dao.getDao().getAllTrip();
	}

}
