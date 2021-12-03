package by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("TABLE")
public class DeskSingleTable extends FurnitureSingleTable {

    @Column(name = "form")
    private String form;

    @Column(name = "material")
    private String material;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Table{" + super.toString() +
                ", form='" + form + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
