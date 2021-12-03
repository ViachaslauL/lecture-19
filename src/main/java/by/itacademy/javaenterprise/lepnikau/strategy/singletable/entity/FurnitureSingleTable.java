package by.itacademy.javaenterprise.lepnikau.strategy.singletable.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Table(name = "single_table_strategy_furniture")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "FURNITURE_TYPE",
        discriminatorType = DiscriminatorType.STRING)
public class FurnitureSingleTable {

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

    public void setFurnitureId(Long id) {
        this.furnitureId = id;
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
        return "id=" + furnitureId +
                ", modelName='" + modelName + '\'' +
                ", price=" + price;
    }
}
