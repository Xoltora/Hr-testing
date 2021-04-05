package uz.pdp.g42accessoryserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.pdp.g42accessoryserver.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted is false")
@SQLDelete(sql = "update address set deleted=true where id=?")
@Entity
public class Address extends AbsNameEntity {
    @ManyToOne
    private District district;

    private Double lon;
    private Double lat;

    private String street;
    private String home;
}
