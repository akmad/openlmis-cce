/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package org.openlmis.cce.repository;

import org.openlmis.cce.domain.BackupGeneratorStatus;
import org.openlmis.cce.domain.CatalogItem;
import org.openlmis.cce.domain.EnergySource;
import org.openlmis.cce.domain.FunctionalStatus;
import org.openlmis.cce.domain.InventoryItem;
import org.openlmis.cce.domain.ManualTemperatureGaugeType;
import org.openlmis.cce.domain.ReasonNotWorkingOrNotInUse;
import org.openlmis.cce.domain.StorageTemperature;
import org.openlmis.cce.domain.Utilization;
import org.openlmis.cce.domain.VoltageRegulatorStatus;
import org.openlmis.cce.domain.VoltageStabilizerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public class InventoryItemRepositoryIntegrationTest
    extends BaseCrudRepositoryIntegrationTest<InventoryItem> {

  @Autowired
  private InventoryItemRepository repository;

  @Autowired
  private CatalogItemRepository catalogItemRepository;

  @Override
  CrudRepository<InventoryItem, UUID> getRepository() {
    return repository;
  }

  @Override
  InventoryItem generateInstance() {
    CatalogItem catalogItem = new CatalogItem();
    catalogItem.setFromPqsCatalog(true);
    catalogItem.setType("type");
    catalogItem.setModel("model");
    catalogItem.setManufacturer("manufacturer");
    catalogItem.setEnergySource(EnergySource.ELECTRIC);
    catalogItem.setStorageTemperature(StorageTemperature.MINUS10);
    catalogItem = catalogItemRepository.save(catalogItem);

    return new InventoryItem(UUID.randomUUID(), catalogItem, UUID.randomUUID(),
        "uniqueId" + getNextInstanceNumber(), "eqTrackingId", "abc123","some-serial-number",
        "Some Reference Name",  2010, 2020, "some source", FunctionalStatus.FUNCTIONING, true,
        ReasonNotWorkingOrNotInUse.NOT_APPLICABLE, Utilization.ACTIVE,
        VoltageStabilizerStatus.UNKNOWN, BackupGeneratorStatus.YES, VoltageRegulatorStatus.NO,
        ManualTemperatureGaugeType.BUILD_IN, "someMonitorId", "example notes", null,
        UUID.randomUUID());
  }
}
