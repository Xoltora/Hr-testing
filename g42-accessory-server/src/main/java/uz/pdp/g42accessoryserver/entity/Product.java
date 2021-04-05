package uz.pdp.g42accessoryserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.pdp.g42accessoryserver.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted is false")
@SQLDelete(sql = "update product set deleted=true where id=?")
@Entity
public class Product extends AbsEntity {
    @ManyToOne
    private Category category;

    @ManyToOne
    private Attachment attachment;

    @ManyToOne
    private Brand brand;

    private double incomePrice;
    private double salePrice;
    private int norma;
}
