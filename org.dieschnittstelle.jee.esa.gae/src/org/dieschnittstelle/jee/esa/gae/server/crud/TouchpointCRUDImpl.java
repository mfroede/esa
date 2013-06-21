package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.persistance.util.EMF;

public class TouchpointCRUDImpl implements TouchpointCRUD {

	protected static Logger logger = Logger.getLogger(TouchpointCRUDImpl.class
			.getName());

	EntityManager em = EMF.get().createEntityManager();

	@Override
	public AbstractTouchpoint createTouchpoint(AbstractTouchpoint touchpoint) {

		logger.info("createTouchpoint(): before persist(): " + touchpoint);
		em.persist(touchpoint);

		logger.info("createTouchpoint(): after persist(): " + touchpoint);

		return touchpoint;
	}

	@Override
	public AbstractTouchpoint readTouchpoint(int id) {
		logger.info("readTouchpoint(): " + id);

		AbstractTouchpoint touchpoint = em.find(AbstractTouchpoint.class, id);

		logger.info("readTouchpoint(): " + touchpoint);

		return touchpoint;
	}

	@Override
	public AbstractTouchpoint updateTouchpoint(AbstractTouchpoint touchpoint) {
		logger.info("updateTouchpoint(): before merge(): " + touchpoint);
		touchpoint = em.merge(touchpoint);

		logger.info("updateTouchpoint(): after merge(): " + touchpoint);
		return touchpoint;
	}

	@Override
	public boolean deleteTouchpoint(int id) {
		logger.info("deleteTouchpoint(): " + id);

		em.remove(em.find(AbstractTouchpoint.class, id));

		logger.info("deleteTouchpoint(): done");

		return true;
	}

	@Override
	public List<AbstractTouchpoint> readAllTouchpoints() {
		logger.info("readAllTouchpoints()");

		Query query = em.createQuery("FROM AbstractTouchpoint");

		List<AbstractTouchpoint> tps = query.getResultList();

		logger.info("readAllTouchpoints(): " + tps);

		return tps;
	}

}
