package zad1_Teamleft_hwk5;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class CurrencyController {

EuroRate euroRate;


    public CurrencyController() {

        RestTemplate restTemplate = new RestTemplate();

        // Rate forObject = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/eur/2019-10-10/", Rate.class);
        EuroRate forObject2 = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/eur/2019-10-10/", EuroRate.class);
        //for (EuroRate euroRate : forObject) {

        // System.out.println(forObject.getMid());//todo null??
        // System.out.println(forObject2.getRates());
        double eurRate = forObject2.getRates().get(0).getMid();
        String euroRateDate = forObject2.getRates().get(0).getEffectiveDate();
        String euroRateNo = forObject2.getRates().get(0).getNo();


        System.out.println("Current EUR rate: " + eurRate + " PLN"); //todo is working
        System.out.println("Date " + euroRateDate);
        System.out.println(euroRateNo);
    }
    public EuroRate getEurRate(){
        return euroRate;

    }


        @GetMapping("/rate")
        public String get(Model model) {
//            model.addAttribute("currencyController", "euroRate");
//            model.addAttribute("euroRate", "euroRate");
//            model.addAttribute("forObject2", "forObject2");
//            model.addAttribute("euroRate", "euroRateDate");
//            model.addAttribute("euroRate", "getEuroRate");
//            model.addAttribute("EuroRate", "getEuroRate");
           // model.addAttribute(getEurRate());
            return "rate";
        }

}
