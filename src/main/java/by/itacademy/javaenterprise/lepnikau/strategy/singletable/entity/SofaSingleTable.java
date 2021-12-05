package by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("SOFA")
public class SofaSingleTable extends FurnitureSingleTable {

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
