package jana60.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "continents")
public class Continent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer continentId;

  private String name;

  /*
   * mappedBy dice che questa relazione è già mappata sull'altra
   * entità (Region) sull'attributo che si chiama continent
   */
  @OneToMany(mappedBy = "continent")
  private List<Region> regionList;



  public Integer getContinentId() {
    return continentId;
  }



  public void setContinentId(Integer continentId) {
    this.continentId = continentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


}
