
package wizut.tpsi.ogloszenia;


import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wizut.tpsi.ogloszenia.services.OffersService;

@Controller
public class HomeController {
    
    @Autowired
    public OffersService offers;
    
    @RequestMapping("/")
    public String home(Model model) throws SQLException{    
        model.addAttribute("car", offers.getCarManufacturer(2));
        model.addAttribute("model", offers.getModel(3));
        return "index";
    }
        

//    @RequestMapping("/")
//    public String home(Model model, @RequestParam("id") Integer Id) throws SQLException{
//        model.addAttribute("post", offers.getCarManufacturer(Id));
//        model.addAttribute("model", offers.getModel(Id));
//        //return "index.html";
//        return "redirect:/";
//
//    }
    
    
}
