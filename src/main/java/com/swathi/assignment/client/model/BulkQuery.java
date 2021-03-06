/*
 * {elementName}
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: api-v2
 * Contact: support@cloud-elements.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.swathi.assignment.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * BulkLoad response of bulk download.
 */
@ApiModel(description = "BulkLoad response of bulk download.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-12-22T09:41:00.238+05:30")
public class BulkQuery {
  @JsonProperty("id")
  private BigDecimal id = null;

  @JsonProperty("status")
  private String status = null;

  public BulkQuery id(BigDecimal id) {
    this.id = id;
    return this;
  }

   /**
   * Id of the bulk job
   * @return id
  **/
  @ApiModelProperty(value = "Id of the bulk job")
  public BigDecimal getId() {
    return id;
  }

  public void setId(BigDecimal id) {
    this.id = id;
  }

  public BulkQuery status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of the bulk job
   * @return status
  **/
  @ApiModelProperty(value = "Status of the bulk job")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BulkQuery bulkQuery = (BulkQuery) o;
    return Objects.equals(this.id, bulkQuery.id) &&
        Objects.equals(this.status, bulkQuery.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BulkQuery {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

