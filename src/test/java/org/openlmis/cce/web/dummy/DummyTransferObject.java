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

package org.openlmis.cce.web.dummy;

import static org.openlmis.cce.web.csv.processor.CsvCellProcessors.INT_TYPE;

import org.openlmis.cce.dto.BaseDto;
import org.openlmis.cce.web.csv.model.ImportField;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DummyTransferObject extends BaseDto {
  public static final String MANDATORY_STRING_FIELD = "Mandatory String Field";
  public static final String OPTIONAL_INT_FIELD = "Optional Int Field";
  public static final String OPTIONAL_NESTED_FIELD = "Optional Nested Field";

  @ImportField(mandatory = true, name = MANDATORY_STRING_FIELD)
  private String mandatoryStringField;

  @ImportField(mandatory = true, type = INT_TYPE)
  private int mandatoryIntField;

  @ImportField
  private String optionalStringField;

  @ImportField(type = INT_TYPE, name = OPTIONAL_INT_FIELD)
  private int optionalIntField;

  @ImportField(name = OPTIONAL_NESTED_FIELD, nested = "code")
  private DummyNestedField dummyNestedField;

  private String nonAnnotatedField;
}
