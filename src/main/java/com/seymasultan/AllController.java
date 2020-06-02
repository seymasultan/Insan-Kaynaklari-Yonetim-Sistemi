package com.seymasultan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@org.springframework.stereotype.Controller
@SessionAttributes({"activeUser", "activeHr"})
public class AllController {

  //  HumanResources activeHr;

    @Autowired
    private UsersDAO dao;
    @Autowired
    private HumanResourcesDAO hrDao;
    @Autowired
    private AdvertDAO advertDao;

    @GetMapping("/")
    public String home(Model model) throws SQLException {
        ArrayList<Advert> allAdvertList = advertDao.allAdvertList();  // anasayfadaki tüm ilanlar
        if(allAdvertList !=null){
            System.out.println("listeeeee"+allAdvertList.size());
        }
        model.addAttribute("allAdvertList",allAdvertList);

        return "home";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("humanResources",new HumanResources());
        return "login";
    }

    @GetMapping("/signUp")
    public String signup(Model model){
        model.addAttribute("humanResources",new HumanResources());
        return "signUp";
    }
    @PostMapping(value = "/signUp")
    public String hrSave(Model model, @ModelAttribute("humanResources") HumanResources humanResources) {
        System.out.println("**********"+humanResources.getHrAd());
        hrDao.hrSave(humanResources);
        return "login";
    }

   @PostMapping(value = "/login")
   public String get(Model model, @ModelAttribute("humanResources") HumanResources humanResources,@SessionAttribute("activeHr") HumanResources activeHr) throws SQLException {
       System.out.println("--------------------" + humanResources.getHrMail());
       System.out.println("------------" + humanResources.getHrSifre());
       boolean a = hrDao.hrLogin(humanResources);
       if (a == true) {

         /*  humanResources=hrDao.hrGet();
           humanResources.setId(humanResources.getId());
           humanResources.setHrAd(humanResources.getHrAd());
           humanResources.setHrMail(humanResources.getHrMail());
           humanResources.setHrSifre(humanResources.getHrSifre());
           humanResources.setSirket(humanResources.getSirket());

           System.out.println("denemeAD"+humanResources.getHrAd());

           return hrProfilPage(model,humanResources); */

           int id=hrDao.hrId(humanResources);
           humanResources=hrDao.hrGet(id);
           humanResources.setId(humanResources.getId());
           humanResources.setHrAd(humanResources.getHrAd());
           humanResources.setHrMail(humanResources.getHrMail());
           humanResources.setHrSifre(humanResources.getHrSifre());
           humanResources.setSirket(humanResources.getSirket());

           System.out.println("denemeAD"+humanResources.getHrAd());
           return hrProfilPage(model,humanResources);

       } else {
           model.addAttribute("error","Email veya şifre yanlış!");
           return "login";
       }

   }
    @GetMapping("/logout")
    public String logout(Model model,@SessionAttribute("activeHr") HumanResources activeHr,@SessionAttribute("activeUser")Users user) throws SQLException {
        activeHr.setHrAd(null);
        user.setIsim(null);
        return home(model);
    }

    @GetMapping("/hrProfilPage")
    public String hrProfilPage(Model model,@SessionAttribute("activeHr") HumanResources activeHr){
        System.out.println(activeHr.getHrAd()+"-*************");
        model.addAttribute("activeHr",activeHr);
        return "hrProfilPage";
    }
    @GetMapping("/hrAdvert")
    public String hrAdvert(Model model,@SessionAttribute("activeHr") HumanResources activeHr) throws SQLException {
        model.addAttribute("advert",new Advert());
        ArrayList<Advert> advertList = advertDao.advertList(activeHr.getId());
        model.addAttribute("advertList",advertList);
        if(advertList !=null){
            System.out.println("listeeeee"+advertList.size());
        }
        return "hrAdvert";
    }

    @PostMapping(value = "/hrAdvert")
    public String hrAdvertAdd(Model model, @ModelAttribute("advert") Advert advert,@SessionAttribute("activeHr") HumanResources activeHr) throws SQLException {
        System.out.println("deneme "+activeHr.getId());
        System.out.println("deneme"+advert.getTitle());
        System.out.println("deneme"+advert.getSummary());
        hrDao.hrAdvertSave(advert,activeHr.getId());
        return hrAdvert(model,activeHr);
    }

    @GetMapping("/advert/{advertId}")
    public String advertPage(@PathVariable("advertId") int advertId, Model model,@SessionAttribute("activeUser") Users user,@SessionAttribute("activeHr") HumanResources activeHr) throws SQLException {
        boolean sonuc;
        Advert advert=advertDao.getAdvert(advertId);
        model.addAttribute("advert",advert);

        if(activeHr.getHrAd()!=null && activeHr.getId()==advert.getHrId())
            model.addAttribute("isHR",true);
        else
            model.addAttribute("isHR",false);

        if(user.getIsim()!=null ) {
            model.addAttribute("isUser", true);
            sonuc = advertDao.basvuruKontrol(user.getId(), advertId);
            model.addAttribute("isApply", sonuc);
        }
        else
            model.addAttribute("isUser",false);

        return "advertPage";
    }

    @GetMapping("/advert/{advertId}/edit")   //düzenle sayfası ilk açıldığında
    public String editAdvert(@PathVariable("advertId") int advertId, Model model) throws SQLException {
        Advert advert=advertDao.getAdvert(advertId);
        model.addAttribute("advert",advert);

        return "advertEdit";
    }

    @GetMapping("/advert/{advertId}/delete")
    public String deleteAdvert(@PathVariable("advertId") int advertId) {

        advertDao.deleteAdvert(advertId);
        return "hrProfilPage";
    }

    @PostMapping("/advert/{advertId}/edit")   //düzenle sayfası güncellendiğinde
    public String editAdvert(@PathVariable("advertId") int advertId,@ModelAttribute Advert advert,Model model,
                             @SessionAttribute("activeUser") Users user,@SessionAttribute("activeHr") HumanResources activeHr) throws SQLException {

        advertDao.updateAdvert(advert,advertId);
        return advertPage(advertId,model,user,activeHr);
    }

    @ModelAttribute("activeUser")
    public Users user() {
        return new Users();
    }
    @ModelAttribute("activeHr")
    public HumanResources humanResources() {
        return new HumanResources();
    }

    @GetMapping("/advert/{advertId}/apply")
    public String applyJob(@PathVariable("advertId") int id,@SessionAttribute("activeUser")Users user,Model model,
                           @SessionAttribute("activeHr")HumanResources activeHr) throws SQLException {
        boolean sonuc;
        Advert advert;
        if(advertDao.getAdvert(id)!=null) {
            if (user.getIsim() !=null) {
                advert=advertDao.getAdvert(id);
                sonuc=advertDao.basvuruKontrol(user.getId(),id);  //daha önce başvurdu mu
                if(sonuc==false)
                    advertDao.basvuru(id,user.getId(),advert.getHrId());

                return advertPage(id,model,user,activeHr);
            }
        }

        return "error";

    }
    @GetMapping("/advert/{advertId}/deleteApply")
    public String deleteApply(@PathVariable("advertId") int id,@SessionAttribute("activeUser")Users user,Model model,
                           @SessionAttribute("activeHr")HumanResources activeHr) throws SQLException {


        if(advertDao.getAdvert(id)!=null) {
            if (user.getIsim() !=null) {
                advertDao.deleteUserApply(user.getId(),id);
            }
        }
        return advertPage(id,model,user,activeHr);
    }

    @GetMapping("/userpage/applies")  //Kullanıcının başvuruları
    public String userAppliesShow(Model model, @SessionAttribute("activeUser") Users user) throws SQLException {
        if(user.getIsim() !=null) {

            ArrayList<Advert> advertList = advertDao.advertList(user.getId());
            model.addAttribute("advertList",advertList);
            return "userAppliesShow";
        }
        else return "error";
    }

    @GetMapping("advert/{advertId}/applies")
    public String showAppliesHR(@PathVariable("advertId") int id, Model model,@SessionAttribute("activeHr")HumanResources activeHr,
                                @SessionAttribute("activeUser")Users user) throws SQLException {

        if(activeHr.getHrAd() !=null) {

            ArrayList<Users> userList = advertDao.ilanaBasvuranKisiler(id);
            model.addAttribute("userList", userList);
            model.addAttribute("search",new Search());
            return "hrAppliesShow";

        }
        else return "error";
    }

    @PostMapping("/advert/{advertId}/applies/search")
    public String search(@PathVariable("advertId") int id,@ModelAttribute("search") Search search, Model model) throws SQLException {

        ArrayList<Users> userList=advertDao.ilanaBasvuranKisilerArama(id,search.basvuranIsmi);
        model.addAttribute("userList",userList);

        return "hrAppliesShow";
    }
}
