package uz.pdp.g42accessoryserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.pdp.g42accessoryserver.entity.template.AbsEntity;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted is false")
@SQLDelete(sql = "update attachment set deleted=true where id=?")
@Entity
public class Attachment extends AbsEntity {
    private String name;
    private long size;
    private String type;
}
