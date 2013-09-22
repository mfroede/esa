package org.dieschnittstelle.jee.esa.gae.server.crud;

import java.util.List;

import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.entities.MobileTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.entities.StationaryTouchpoint;

public interface TouchpointCRUD {

   public AbstractTouchpoint readTouchpoint(long id);

   public List<AbstractTouchpoint> readAllTouchpoints();

   public AbstractTouchpoint updateTouchpoint(AbstractTouchpoint Touchpoint);

   public boolean deleteTouchpoint(long id);

   MobileTouchpoint createTouchpoint(MobileTouchpoint touchpoint);

   StationaryTouchpoint createTouchpoint(StationaryTouchpoint touchpoint);

}
