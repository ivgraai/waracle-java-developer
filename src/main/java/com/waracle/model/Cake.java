package com.waracle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.validation.annotation.Validated;

/**
 * Cake
 */
@Entity
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-03-12T11:39:55.360Z")

public class Cake implements Serializable {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get title
     *
     * @return title
     *
     */
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
     *
     * @return desc
     *
     */
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
     *
     * @return image
     *
     */
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
        return Objects.equals(this.id, cake.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Cake {\n");

        if (null != id) {
            sb.append("    id: ").append(toIndentedString(id)).append("\n");
        }
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
