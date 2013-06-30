package org.dieschnittstelle.jee.esa.gae.server.persistance.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utility class for creating EntityManagerFactory in Singleton Instances. See
 * https://developers.google.com/appengine/docs/java/datastore/jpa/overview-dn2#
 * Getting_an_EntityManager_Instance for more information
 * 
 * @author Frank Schmidt
 * 
 */
public final class EMF {
	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");

	private EMF() {
	}

	public static EntityManagerFactory get() {
		return emfInstance;
	}
}
