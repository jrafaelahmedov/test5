package util;

import beans.Competitor;
import beans.User;

import java.util.Scanner;

public class MenuUtil {

    public static int showMenu(){
        System.out.println("Please select menu:");
        String menuStr =
                        "1-yarishmacilari daxil et\n" +
                        "2-yarishmaya bashla\n" +
                        "3-xalini oyren\n" +
                        "4-ishtirakchilarin sayini artir\n" +
                        "5-yarishmacilara bax\n" +
                        "6-logout\n";
        System.out.println(menuStr);
        Scanner sc = new Scanner(System.in);
        int selectedMenu = sc.nextInt();
        if(selectedMenu>0 && selectedMenu<7){
            return selectedMenu;
        }else {
            System.out.println("Invalid menu selected");
            return -1;
        }
    }

    public static int showMenuInfinite(){
        while(true) {
            int selectedMenu = showMenu();
            if(selectedMenu==1){
                CompetitionUtil.registerCompetitorsAndShowInfo();
            }else if(selectedMenu==2){
                CompetitionUtil.startCompetition();
            }else if(selectedMenu==3){
                CompetitionUtil.showPoint();
            }else if(selectedMenu==4){
                CompetitionUtil.increaseCompetitors();
            }else if(selectedMenu==5){
                CompetitionUtil.printCompetitors();
            } else if(selectedMenu==6){
                UserUtil.requireInputsAndLogin(3,true);
            }
        }
    }
}
