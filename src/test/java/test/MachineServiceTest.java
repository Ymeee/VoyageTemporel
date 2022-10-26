package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import config.JpaConfig;
import model.Machine;
import service.MachineService;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaConfig.class })
@Transactional
//par defaut rollback a la fin de chaque transaction
class MachineServiceTest {

	@Autowired
	MachineService machineSrv;

	@Test
	void InjectionMachineServicetest() {
		assertNotNull(machineSrv);
	}
	
	@Test
	@Commit
	@Disabled
	void initMachine() {
		machineSrv.create(new Machine("2020-06-25"));
	}

	@Test
	void creationMachineTest() {
		Produit produit = new Produit("aaa", 1.5, null);
		produit = produitSrv.create(produit);
		assertNotNull(produit.getId());
		assertNotNull(produitSrv.findById(produit.getId()));
	}

}
