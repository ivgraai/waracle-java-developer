package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Cake
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-12T11:39:55.360Z")


public class Cake   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("desc")
  private String desc = null;

  @JsonProperty("image")
  private String image = null;

  public Cake title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Cake desc(String desc) {
    this.desc = desc;
    return this;
  }

  /**
   * Get desc
   * @return desc
  **/
  @ApiModelProperty(value = "")


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Cake image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
  **/
  @ApiModelProperty(value = "")


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cake cake = (Cake) o;
    return Objects.equals(this.title, cake.title) &&
        Objects.equals(this.desc, cake.desc) &&
        Objects.equals(this.image, cake.image);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, desc, image);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cake {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
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

