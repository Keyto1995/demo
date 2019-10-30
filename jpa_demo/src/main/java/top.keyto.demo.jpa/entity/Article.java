package top.keyto.demo.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Keyto
 * Created on 2019/10/22
 */
@Data
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aid;
    @Column(name = "author")
    private String author;
    private Date createTime;
    private String title;

}
