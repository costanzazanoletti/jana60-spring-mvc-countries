package jana60.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jana60.model.Country;
import jana60.repository.CountryRepository;

@Controller
@RequestMapping("/")
public class CountryController {

  @Autowired
  private CountryRepository repo;

  @GetMapping
  public String countries(Model model) {
    List<Country> countryList = (List<Country>) repo.findAll();
    // List<Country> countryList = new ArrayList<Country>();
    // System.out.println(countryList);
    model.addAttribute("countryList", countryList);
    return "countries";
  }

}
