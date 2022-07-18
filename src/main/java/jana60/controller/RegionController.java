package jana60.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import jana60.model.Region;
import jana60.repository.RegionRepository;

@Controller
@RequestMapping("/region")
public class RegionController {

  @Autowired
  private RegionRepository repo;

  @GetMapping
  public String regionList(Model model) {
    model.addAttribute("regionList", repo.findAll());
    return "regions";
  }

  @GetMapping("/{regionId}")
  public String regionDetail(Model model,
      @PathVariable(name = "regionId") Integer regionPrimaryKey) {
    // select su db sulla tabella regions per quella primary key
    Region currentRegion = repo.findById(regionPrimaryKey).get();
    model.addAttribute("region", currentRegion);
    return "regionDetail";
  }
}
