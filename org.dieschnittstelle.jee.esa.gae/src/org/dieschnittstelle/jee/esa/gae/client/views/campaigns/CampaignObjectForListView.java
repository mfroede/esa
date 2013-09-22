package org.dieschnittstelle.jee.esa.gae.client.views.campaigns;

import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CampaignObjectForListView extends Widget {

   private final FlowPanel oneCampaign;
   private final String DEFAULT_URL = "http://i.istockimg.com/file_thumbview_approve/16430034/2/stock-photo-16430034-citrus-slices.jpg";

   public CampaignObjectForListView(String imageURL, String campaignName, String price) {
      oneCampaign = new FlowPanel();
      Image image;
      if (imageURL != null) {
         image = new Image(URL.decode(imageURL));
      } else {
         image = new Image(DEFAULT_URL);

      }
      image.setWidth("50%");
      oneCampaign.add(image);
      Label labelCampaignName = new Label(campaignName);
      Label labelPrice = new Label(price);
      oneCampaign.add(labelCampaignName);
      oneCampaign.add(labelPrice);
   }

   @Override
   public Widget asWidget() {
      // TODO Auto-generated method stub
      return oneCampaign;
   }

}
