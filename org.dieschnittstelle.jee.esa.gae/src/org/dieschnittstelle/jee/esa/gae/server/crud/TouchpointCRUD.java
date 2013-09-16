package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;

public interface TouchpointCRUD {

   public AbstractTouchpoint createTouchpoint(AbstractTouchpoint Touchpoint);

   public AbstractTouchpoint readTouchpoint(long id);

   public List<AbstractTouchpoint> readAllTouchpoints();

   public AbstractTouchpoint updateTouchpoint(AbstractTouchpoint Touchpoint);

   public boolean deleteTouchpoint(long id);

}
