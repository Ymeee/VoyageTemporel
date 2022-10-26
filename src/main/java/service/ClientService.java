package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import exception.AdminException;
import exception.IdException;
import model.Client;
import repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepo;
	
	public List<Client> findAll() {
		return clientRepo.findAll();
	}

	public Client findById(Integer id) {
		return clientRepo.findById(id).orElseThrow(IdException::new);
	}
	
	public Client create(Client client) {
		if (client.getId() != null) {
			throw new AdminException("client deja dans la base");
		}
		return save(client);

	}

	public Client update(Client client) {
		if (client.getId() == null || !clientRepo.existsById(client.getId())) {
			throw new IdException();
		}
		return save(client);
	}

	private Client save(Client client) {
		if (client.getNom() == null || client.getNom().isBlank() || client.getNom().length() > 35) {
			throw new AdminException("probleme nom");
		}
		if (client.getPrenom() == null || client.getPrenom().isBlank() || client.getPrenom().length() > 30) {
			throw new AdminException("probleme prenom");
		}
		if (client.getLogin() == null || client.getLogin().isBlank() || client.getLogin().length() > 35) {
			throw new AdminException("probleme login");
		}
		if (client.getPassword() == null || client.getPassword().isBlank() || client.getPassword().length() > 100) {
			throw new AdminException("probleme login");
		}
		if (client.getTel() == null || client.getTel().isBlank() || client.getTel().length() > 10) {
			throw new AdminException("probleme tel");
		}
		if (client.getMail() == null || client.getMail().isBlank() || client.getMail().length() > 35) {
			throw new AdminException("probleme mail");
		}
		if (client.getAnniversaire() == null) {
			throw new AdminException("probleme anniv");
		}
		return clientRepo.save(client);
	}

	public void delete(Client client) {
		clientRepo.delete(client);
	}

	public void deleteById(Integer id) {
		clientRepo.deleteById(id);
	}
}
