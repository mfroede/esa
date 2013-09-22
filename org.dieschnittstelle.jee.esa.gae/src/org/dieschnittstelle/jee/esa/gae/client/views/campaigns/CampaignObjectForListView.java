package org.dieschnittstelle.jee.esa.gae.client.views.campaigns;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CampaignObjectForListView extends Widget {

   private final FlowPanel oneCampaign;

   public CampaignObjectForListView(String imageURL, String text) {
      oneCampaign = new FlowPanel();
      if (imageURL != null) {
         Image image = new Image(imageURL);
         oneCampaign.add(image);
      }
      Label labelText = new Label(text);

      oneCampaign.add(labelText);
   }

   @Override
   public Widget asWidget() {
      // TODO Auto-generated method stub
      return oneCampaign;
   }

}
