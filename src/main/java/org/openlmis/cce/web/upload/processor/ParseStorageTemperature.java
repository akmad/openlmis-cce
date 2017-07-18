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

package org.openlmis.cce.web.upload.processor;

import org.apache.commons.lang3.EnumUtils;
import org.openlmis.cce.domain.StorageTemperature;
import org.supercsv.cellprocessor.CellProcessorAdaptor;
import org.supercsv.cellprocessor.ift.StringCellProcessor;
import org.supercsv.exception.SuperCsvCellProcessorException;
import org.supercsv.util.CsvContext;

/**
 * This is a custom cell processor used to parse string to enum typ.
 * This is used in CsvCellProcessors.
 */
public class ParseStorageTemperature extends CellProcessorAdaptor implements StringCellProcessor {

  @Override
  public Object execute(Object value, CsvContext context) {
    validateInputNotNull(value, context);

    StorageTemperature result;
    if (value instanceof String && EnumUtils.isValidEnum(StorageTemperature.class, (String)value)) {
      result = StorageTemperature.valueOf((String)value);
    } else  {
      throw new SuperCsvCellProcessorException(
          String.format("'%s' could not be parsed as an StorageTemperature", value), context, this);
    }

    return next.execute(result, context);
  }
}
