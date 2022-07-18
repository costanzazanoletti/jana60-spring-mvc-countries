package jana60.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer countryId; // country_id

  private String name;

  private BigDecimal area;

  private LocalDate nationalDay; // national_day

  @Column(name = "country_code3")
  private String countryCode3;

  @Column(name = "country_code2")
  private String countryCode2;

  @ManyToOne
  @JoinColumn(name = "region_id")
  private Region region;



  // getter e setter

  public int getCountryId() {
    return countryId;
  }

  public void setCountryId(int countryId) {
    this.countryId = countryId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getArea() {
    return area;
  }

  public void setArea(BigDecimal area) {
    this.area = area;
  }

  public LocalDate getNationalDay() {
    return nationalDay;
  }

  public void setNationalDay(LocalDate nationalDay) {
    this.nationalDay = nationalDay;
  }

  public String getCountryCode3() {
    return countryCode3;
  }

  public void setCountryCode3(String countryCode3) {
    this.countryCode3 = countryCode3;
  }

  public String getCountryCode2() {
    return countryCode2;
  }

  public void setCountryCode2(String countryCode2) {
    this.countryCode2 = countryCode2;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }



  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  // altri metodi public
  public String getFormattedNationalDay() {
    if (nationalDay == null) {
      return "n.d.";
    } else {
      return nationalDay.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
    }
  }

  public String getRegionName() {
    return this.region.getName();
  }


}
