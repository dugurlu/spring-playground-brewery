package de.dugurlu.brewery.model;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.*;
import javax.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Version
  private Long version;

  @CreationTimestamp
  @Column(updatable = false)
  private Timestamp created;
  @UpdateTimestamp
  private Timestamp modified;
  private String name;
  private BeerStyle style;

  @Column(unique = true)
  private String upc;
  private Long price;

  private Integer available;
  private Integer toBrew;

}
