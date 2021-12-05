package by.itacademy.javaenterprise.lepnikau.strategy.joined.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "joined_strategy_sofas")
@PrimaryKeyJoinColumn(name = "furniture_id")
public class SofaJoined extends FurnitureJoined {

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
