package Hostel;
import java.util.Scanner;
public class TestHostel {
    public static void main(String[] args) {

         Hostel hostel = new ChoiceHostelNumber() {
         };

        Scanner input = new Scanner(System.in);

        String inputKey = "c";

        while(inputKey.equals("c" )|| inputKey.equals("C")){
            hostel.personInformation();
            hostel.reserveARoom();
            hostel.toplamTutar();
            hostel.finish();

            System.out.println("\nDevam etmek için c'ye, çıkmak için herhangi başka bir tuşa basınız ");
            inputKey = input.next();
        }

    }


}
