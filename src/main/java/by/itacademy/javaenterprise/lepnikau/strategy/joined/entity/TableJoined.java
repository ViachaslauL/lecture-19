package by.itacademy.javaenterprise.lepnikau.strategy.joined.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "joined_strategy_tables")
@PrimaryKeyJoinColumn(name = "furniture_id")
public class TableJoined extends FurnitureJoined {

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
