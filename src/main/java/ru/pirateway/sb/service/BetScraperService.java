package ru.pirateway.sb.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pirateway.sb.api.repository.IForkRepository;
import ru.pirateway.sb.api.service.IBetScraperService;
import ru.pirateway.sb.api.service.IConnectService;
import ru.pirateway.sb.entity.Fork;
import ru.pirateway.sb.exception.DataValidateException;

import java.io.IOException;

@Component
public class BetScraperService implements IBetScraperService {

    @Autowired
    IForkRepository forkRepository;

    @Autowired
    IConnectService connectService;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BetScraperService.class);

    public void separateHtml(String pageHtml) {
        Document doc = Jsoup.parse(pageHtml);
        Element table = doc.select("table").get(1);
        Elements rows = table.select("tr");

            int i = 0;
            int countRefresh = 0;
            for (Element row : rows) {
                i++;
                String forkType = "";
                String forkAge = "";
                String profit = "";
                String evenOneBk = "";
                String evenTwoBk = "";
                String eventOneDescription = "Событие скрыто!";
                String eventTwoDescription = "Событие скрыто!";
                String eventOneLink = "#";
                String eventTwoLink = "#";
                String eventOneTextLink = "Событие скрыто!";
                String eventTwoTextLink = "Событие скрыто!";
                String eventOneMoving = "";
                String eventTwoMoving = "";
                String eventOneCoefficient = "";
                String eventTwoCoefficient = "";
                String eventOneForksCount = "";
                String eventTwoForksCount = "";

                try {
                    forkType = row.select("td").get(0).select("a").get(2).select("img").attr("alt");
                    //        System.out.println(forkType);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    forkAge = row.select("td").get(0).select("div").select("a").text();
                    //        System.out.println(forkAge);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    profit = row.select("td").get(1).select("nobr").text();
                    //         System.out.println(profit);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    evenOneBk = row.select("td").get(2).children().first().text();
                    //        System.out.println(evenOneBk);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    evenTwoBk = row.select("td").get(2).children().last().text();
                    //         System.out.println(evenTwoBk);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventOneDescription = row.select("td").get(3).child(1).text() + " " +
                            row.select("td").get(3).select("small").get(0).text();
                    //        System.out.println(eventOneDescription);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventTwoDescription = row.select("td").get(3).child(5).text() + " " +
                            row.select("td").get(3).select("small").get(1).text();
                    //        System.out.println(eventTwoDescription);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventOneLink = row.select("td").get(4).select("nobr").get(0).select("a").attr("href");
                    //       System.out.println(eventOneLink);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventOneTextLink = row.select("td").get(4).select("nobr").get(0).select("a").text();
                    //        System.out.println(eventOneTextLink);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventTwoLink = row.select("td").get(4).select("nobr").get(1).select("a").attr("href");
                    //      System.out.println(eventTwoLink);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventTwoTextLink = row.select("td").get(4).select("nobr").get(1).select("a").text();
                    //       System.out.println(eventTwoTextLink);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }

                try {
                    eventOneMoving = row.select("td").get(5).select("nobr").get(0).select("a").select("img").attr("alt");
                    //       System.out.println(eventOneMoving);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventTwoMoving = row.select("td").get(5).select("nobr").get(1).select("a").select("img").attr("alt");
                    //       System.out.println(eventTwoMoving);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventOneCoefficient = row.select("td").get(5).select("nobr").get(0).text();
                    //    System.out.println(eventOneCoefficient);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }
                try {
                    eventTwoCoefficient = row.select("td").get(5).select("nobr").get(1).text();
                    //  System.out.println(eventOneCoefficient);
                } catch (Exception e) {
                    System.out.println(" error: " + e.getMessage());
                }

                Fork fork = new Fork(String.valueOf(i), "", forkType, forkAge, profit);

                fork.setEventOneBk(evenOneBk);
                fork.setEventOneDescription(eventOneDescription);
                fork.setEventOneCoefficient(eventOneCoefficient);
                fork.setEventOneTextLink(eventOneTextLink);

                fork.setEventTwoBk(evenTwoBk);
                fork.setEventTwoDescription(eventTwoDescription);
                fork.setEventTwoCoefficient(eventTwoCoefficient);
                fork.setEventTwoTextLink(eventTwoTextLink);
                fork.setEventOneLink(eventOneLink);
                fork.setEventTwoLink(eventTwoLink);

                System.out.println(fork);
                forkRepository.save(fork);
                System.out.println("Count save to DateBase - " + ++countRefresh);
            }
    }

}
