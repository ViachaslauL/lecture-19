package by.itacademy.javaenterprise.lepnikau.strategy.tableperclass.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "per_class_strategy_furniture")
@MappedSuperclass
public class FurniturePerClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furniture_id")
    private Long furnitureId;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "price")
    private Double price;

    public Long getFurnitureId() {
        return furnitureId;
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
