package by.itacademy.javaenterprise.lepnikau.strategy.joined.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "joined_strategy_furniture")
@Inheritance(strategy = InheritanceType.JOINED)
public class FurnitureJoined {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furniture_id")
    private Long furnitureId;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "price")
    private Double price;

    public Long getFurnitureId() {
        return null;
    }

    public void setFurnitureId(Long furnitureId) {
        this.furnitureId = furnitureId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "furnitureId=" + furnitureId +
                ", modelName='" + modelName + '\'' +
                ", price=" + price;
    }
}
