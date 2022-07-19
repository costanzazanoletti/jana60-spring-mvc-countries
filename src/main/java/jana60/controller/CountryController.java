package jana60.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
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

  /*
   * gestiche la richiesta del browser del tipo
   * http://localhost:8080/detail/4
   */
  @GetMapping("/detail/{id}")
  public String countryDetail(@PathVariable(name = "id") Integer countryId, Model model) {
    // ho dal path la primary key della country
    // faccio la query su database
    Optional<Country> queryResult = repo.findById(countryId);
    // select * from countries where countryId = ?
    if (queryResult.isPresent()) {
      // la query ha avuto successo e posso mostrare il dettaglio
      model.addAttribute("country", queryResult.get());
      return "countryDetail";
    } else {
      // se la query non ha trovato risultati rispondo con un HTTP 404
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Country not found");
    }
  }

}
