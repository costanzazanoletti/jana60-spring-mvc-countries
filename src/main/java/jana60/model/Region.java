package jana60.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer regionId;

  private String name;

  @OneToMany(mappedBy = "region")
  // @JoinColumn(name = "region_id")
  private List<Country> countries;

  /*
   * @JoinColumn dice che questa relazione su database è salvata
   * sulla colonna che si chiama continent_id della tabella regions (cioè
   * quella mappata da questa entity)
   */
  @ManyToOne
  @JoinColumn(name = "continent_id")
  private Continent continent;

  public Integer getRegionId() {
    return regionId;
  }

  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Country> getCountries() {
    return countries;
  }

  public void setCountries(List<Country> countries) {
    this.countries = countries;
  }

  public Continent getContinent() {
    return continent;
  }

  public void setContinent(Continent continent) {
    this.continent = continent;
  }


}
