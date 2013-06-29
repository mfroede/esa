package org.dieschnittstelle.jee.esa.gae.client.common;

import org.dieschnittstelle.jee.esa.gae.client.modules.start.StartPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ StartPlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
