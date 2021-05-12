package com.company.GorelikGY;

import com.company.GorelikGY.domain.DriversEntity;
import com.company.GorelikGY.domain.OrdersEntity;
import com.company.GorelikGY.domain.UsersEntity;
import com.company.GorelikGY.repos.DriversRepo;
import com.company.GorelikGY.repos.OrdersRepo;
import com.company.GorelikGY.repos.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {
    @Autowired
    private OrdersRepo ordersRepo;
    @Autowired
    private DriversRepo driversRepo;
    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/login")
    public String login(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @RequestMapping(value = "/taksi", method = RequestMethod.GET)
    public String getHomePage(Model model) {
        model.addAttribute(new OrdersEntity());
        model.addAttribute(new DriversEntity());
        return "taksi";
    }

    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public String getGreeting(Model model) {

        return "greetings";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        Iterable<DriversEntity> driversList = driversRepo.findAll();
        Iterable<OrdersEntity> ordersList = ordersRepo.findAll();
        model.addAttribute("driversList", driversList);
        model.addAttribute("ordersList", ordersList);
        model.addAttribute(new UsersEntity());
        return "admin";
    }

    @RequestMapping(value = "/taksiPost", method = RequestMethod.POST)
    public String makeOrder(@ModelAttribute OrdersEntity ordersEntity, Model model) {
        ordersRepo.save(ordersEntity);
        return getHomePage(model);
    }

    @RequestMapping(value = "/driverPost", method = RequestMethod.POST)
    public String make(@ModelAttribute DriversEntity driversEntity, Model model) {
        driversRepo.save(driversEntity);
        return getHomePage(model);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String makeGreet(@ModelAttribute UsersEntity usersEntity, Model model) {
        usersRepo.save(usersEntity);
        return getHomePage(model);
    }


    @RequestMapping(value = "/driver", method = RequestMethod.GET)
    public String driver(Model model) {
        Iterable<OrdersEntity> ordersList = ordersRepo.findAll();
        model.addAttribute("ordersList", ordersList);
        model.addAttribute(new UsersEntity());
        model.addAttribute(new OrdersEntity());
        return "driver";
    }

    @RequestMapping(value = "/driverChange", method = RequestMethod.GET)
    public String driverChange(Model model) {

        return "driverсhange";
    }

    @RequestMapping(value = "/searchdriver", method = RequestMethod.POST)
    public String searchDriver(@ModelAttribute OrdersEntity ordersEntity, Model model) {
        ArrayList<OrdersEntity> ordersList = new ArrayList<>(ordersRepo.findOrdersEntitiesByStreet(ordersEntity.getStreet()));
        model.addAttribute(new UsersEntity());
        model.addAttribute(new OrdersEntity());
        model.addAttribute("ordersList", ordersList);
        return "driver";
    }

    @RequestMapping(value = "/adminChange", method = RequestMethod.GET)
    public String adminChange(Model model) {

        return "adminсhange";
    }


    @RequestMapping(value = "/adminMakeReport", method = RequestMethod.GET)
    public String adminMakeReport(Model model) throws IOException {
        Iterable<DriversEntity> driversList = driversRepo.findAll();
        Iterable<OrdersEntity> ordersList = ordersRepo.findAll();
        model.addAttribute("driversList", driversList);
        model.addAttribute("ordersList", ordersList);
        model.addAttribute(new UsersEntity());

        FileWriter write = new FileWriter("C:\\Users\\George\\IdeaProjects\\kursach\\src\\main\\resources\\report.txt");
        write.write("Student number...\n");
        List<String> result = new ArrayList<String>();

        write.close();
        return "admin";
    }

    @RequestMapping(value = "/driverTakeOrder", method = RequestMethod.GET)
    public String driverTakeOrder(Model model) {
        Iterable<OrdersEntity> ordersList = ordersRepo.findAll();
        model.addAttribute("ordersList", ordersList);
        model.addAttribute(new UsersEntity());
        model.addAttribute(new OrdersEntity());

        return "driver";
    }

    @RequestMapping(value = "/driverCommit", method = RequestMethod.GET)
    public String driverCommit(Model model) {
        Iterable<OrdersEntity> ordersList = ordersRepo.findAll();
        model.addAttribute("ordersList", ordersList);
        model.addAttribute(new UsersEntity());
        model.addAttribute(new OrdersEntity());

        return "driver";
    }

    @RequestMapping(value = "/driverCancel", method = RequestMethod.GET)
    public String driverCancel(Model model) {
        Iterable<OrdersEntity> ordersList = ordersRepo.findAll();
        model.addAttribute("ordersList", ordersList);
        model.addAttribute(new UsersEntity());
        model.addAttribute(new OrdersEntity());

        return "driver";
    }

}