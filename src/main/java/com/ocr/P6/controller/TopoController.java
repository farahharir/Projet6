package com.ocr.P6.controller;

import com.ocr.P6.dao.SpotDao;
import com.ocr.P6.dao.TopoDao;
import com.ocr.P6.model.Spot;
import com.ocr.P6.model.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopoController {

    @Autowired
    private TopoDao topoDao;

    /**
     * Méthode qui va permettre la création d'un nouveau topo
     */

    @RequestMapping(value = "/ajoutTopo", method = RequestMethod.GET)
    public String ajouterTopo(Model model) {
        Topo topo = new Topo();
        model.addAttribute("topo", topo);
        return "ajoutTopo";
    }

    /**
     * Méthode qui va permettre l'enregistrement des données topos.
     */

    @RequestMapping(value = "/ajoutTopo", method = RequestMethod.POST)
    public String enregistrerTopo(Topo topo) {
        topoDao.save(topo);
        return "redirect:/topos";
    }

    /**
     * Méthode qui va permettre l'affichage des spots.
     */

    @RequestMapping("/topos")
    public String affichageTopo(Model model) {
        model.addAttribute("topos", topoDao.findAll());
        return "topos";
    }



}
