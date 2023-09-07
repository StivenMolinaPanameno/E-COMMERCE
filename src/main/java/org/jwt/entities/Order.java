package org.jwt.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.jwt.security.models.UserEntity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_tb")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH, targetEntity = UserEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column(columnDefinition = "DATE")
    private Date date;
    private BigDecimal total;


    public Order(BigDecimal total, Date date, UserEntity client) {
        this.total = total;
        this.date = date;
        this.user = client;
    }
}
