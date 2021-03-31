package uz.pdp.g42accessoryserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.g42accessoryserver.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Region extends AbsNameEntity {
}
