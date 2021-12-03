package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "per_class_strategy_tables")
public class DeskPerClass extends FurniturePerClass {

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
