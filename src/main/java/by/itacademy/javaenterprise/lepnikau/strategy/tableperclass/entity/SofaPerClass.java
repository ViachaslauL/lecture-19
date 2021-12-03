package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "per_class_strategy_sofas")
public class SofaPerClass extends FurniturePerClass {

    @Column(name = "type")
    private String type;

    @Column(name = "pillows_count")
    private int pillowsCount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPillowsCount() {
        return pillowsCount;
    }

    public void setPillowsCount(int pillowsCount) {
        this.pillowsCount = pillowsCount;
    }

    @Override
    public String toString() {
        return "Sofa{" + super.toString() +
                ", type='" + type + '\'' +
                ", pillowsCount=" + pillowsCount +
                '}';
    }
}
