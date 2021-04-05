package uz.pdp.g42accessoryserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.g42accessoryserver.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trade extends AbsEntity {
    @ManyToOne
    private Shop shop;

    @ManyToOne
    private User seller;

    @ManyToOne
    private Report report;

    private double totalSum;
    private double totalIncomeSum;
    private double afterDiscountTotalSum;
}
