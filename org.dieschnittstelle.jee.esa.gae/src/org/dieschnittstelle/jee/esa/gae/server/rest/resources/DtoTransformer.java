package org.dieschnittstelle.jee.esa.gae.server.rest.resources;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.dieschnittstelle.jee.esa.gae.server.crud.CampaignCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.CampaignCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.crud.TouchpointCRUD;
import org.dieschnittstelle.jee.esa.gae.server.crud.TouchpointCRUDImpl;
import org.dieschnittstelle.jee.esa.gae.server.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.gae.server.entities.Address;
import org.dieschnittstelle.jee.esa.gae.server.entities.Campaign;
import org.dieschnittstelle.jee.esa.gae.server.entities.CampaignExecution;
import org.dieschnittstelle.jee.esa.gae.server.entities.Customer;
import org.dieschnittstelle.jee.esa.gae.server.entities.IndividualizedProductItem;
import org.dieschnittstelle.jee.esa.gae.server.entities.ProductBundle;
import org.dieschnittstelle.jee.esa.gae.server.entities.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.AddressDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CampaignExecutionDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.CustomerDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.ProductBundleDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.ProductDTO;
import org.dieschnittstelle.jee.esa.gae.shared.entities.dto.TouchpointDTO;

public class DtoTransformer {
   private final CampaignCRUD campaignCRUD;
   private final TouchpointCRUD touchpointCRUD;
   public static DtoTransformer instance = null;

   public static DtoTransformer instance() {
      if (instance == null) {
         instance = new DtoTransformer();
      }
      return instance;
   }

   private DtoTransformer() {
      this.campaignCRUD = new CampaignCRUDImpl();
      this.touchpointCRUD = new TouchpointCRUDImpl();
   }

   public CampaignExecutionDTO toCampaignExecutionDTO(CampaignExecution cpe) {

      CampaignExecutionDTO campaignExecutionDTO = new CampaignExecutionDTO();
      Campaign c = campaignCRUD.readCampaign(cpe.getCampaignId());
      AbstractTouchpoint t = touchpointCRUD.readTouchpoint(cpe.getTouchpointId());
      CampaignDTO campaignDTO = toCampaignDTO(c);
      TouchpointDTO touchpointDTO = toTouchpointDTO(t);

      campaignExecutionDTO.setId(cpe.getId());
      campaignExecutionDTO.setCampaign(campaignDTO);
      campaignExecutionDTO.setTouchpoint(touchpointDTO);
      campaignExecutionDTO.setDuration(cpe.getDuration());
      campaignExecutionDTO.setUnits(cpe.getUnits());
      campaignExecutionDTO.setUnitsLeft(cpe.getUnitsLeft());

      return campaignExecutionDTO;
   }

   public TouchpointDTO toTouchpointDTO(AbstractTouchpoint t) {
      TouchpointDTO touchpointDTO = new TouchpointDTO();
      touchpointDTO.setId(t.getId());
      touchpointDTO.setName(t.getName());
      if (t instanceof StationaryTouchpoint) {
         touchpointDTO.setAddress(toAddressDTO(((StationaryTouchpoint) t).getLocation()));
      }
      return touchpointDTO;
   }

   public AddressDTO toAddressDTO(Address location) {
      AddressDTO addressDTO = new AddressDTO();
      addressDTO.setCity(location.getCity());
      addressDTO.setGeoLat(location.getGeoLat());
      addressDTO.setGeoLong(location.getGeoLong());
      addressDTO.setHouseNr(location.getHouseNr());
      addressDTO.setStreet(location.getStreet());
      addressDTO.setZipCode(location.getZipCode());
      return addressDTO;
   }

   public CampaignDTO toCampaignDTO(Campaign c) {
      CampaignDTO campaignDTO = new CampaignDTO();
      campaignDTO.setId(c.getId());
      campaignDTO.setName(c.getName());
      campaignDTO.setPrice(c.getPrice());
      List<ProductBundleDTO> bundleDTOs = new LinkedList<>();
      Collection<ProductBundle> bundles = c.getBundles();
      for (ProductBundle productBundle : bundles) {
         bundleDTOs.add(toProductBundleDTO(productBundle));
      }
      campaignDTO.setBundles(bundleDTOs);
      return campaignDTO;
   }

   public ProductBundleDTO toProductBundleDTO(ProductBundle productBundle) {
      ProductBundleDTO productBundleDTO = new ProductBundleDTO();
      productBundleDTO.setId(productBundle.getId().getId());
      productBundleDTO.setProduct(toProductDTO(productBundle.getProduct()));
      productBundleDTO.setUnits(productBundle.getUnits());
      return productBundleDTO;
   }

   public ProductDTO toProductDTO(IndividualizedProductItem product) {
      ProductDTO productDTO = new ProductDTO();
      productDTO.setName(product.getName());
      productDTO.setPrice(product.getPrice());
      productDTO.setId(product.getId().getId());
      return productDTO;
   }

   public CustomerDTO toCustomerDTO(Customer customer) {
      CustomerDTO customerDTO = new CustomerDTO();
      customerDTO.setId(customer.getId().getId());
      customerDTO.setEmail(customer.getEmail());
      customerDTO.setAddress(toAddressDTO(customer.getAddress()));
      customerDTO.setFirstName(customer.getFirstName());
      customerDTO.setGender(customer.getGender());
      customerDTO.setLastName(customer.getLastName());
      customerDTO.setMobilePhoneId(customer.getMobilePhoneId());
      customerDTO.setPassword(customer.getPassword());
      return customerDTO;
   }
}
