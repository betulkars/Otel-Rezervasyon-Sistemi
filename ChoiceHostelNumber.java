package Hostel;
import java.util.Scanner;

public abstract class ChoiceHostelNumber extends Hostel {
    public ChoiceHostelNumber() {

        super();
    }

    public ChoiceHostelNumber(int roomNumber) {

        super(roomNumber);
    }
    public  int choiceroom;
    public int choice;
    public void reserveARoom() {    /// ---> Kullanıcının yönlendirmesine göre oda rezervasyonu yapan bir metottur.
        Scanner input = new Scanner(System.in);
        System.out.println("For triple rooms, press 0.Press 1 for double rooms.");
        choice = input.nextInt();

        while (true) {
            if (choice == 0) {
                if (ısTheHostelFull()) {  // ---> Eğer otel doluysa ekrana uyarı verir ve oda seçimi yaptırmaz.
                    System.out.println("Unfortunately, the rooms are full. We can't take reservations.");
                    break;
                }
                 if (roomForThreeRoom()) { // ---> Eğer  3 kişilik odalar doluysa ekrana uyarı verir ve oda seçimi yaptırmaz.
                    System.out.println("Sorry, triple rooms are full. We can't take reservations.");
                    break;
                } else {   /// ---> Eğer  hangi oda boşsa oda numarasını ekrana yazdırır ve kullanıcıdan seçmesini ister.
                    System.out.println("Please choose one of the available rooms below.");
                    for (int i = 5; i < roomNumber; i++) {
                        if (!rooms[i]) {
                            System.out.print((i + 1) + " ");
                        }

                    }
                    choiceroom = input.nextInt();  ///---> Kullanıcı seçeceği oda numarasını girer.
                    if (choiceroom < 0 || choiceroom > 5) { /// ---> Eğer yanlış oda numarası girdiyse ekrana uyarı yazdırılır.
                        System.out.println("You entered the wrong room number. Please try again.");
                    } else {  // ---> Doğru oda numarası girildiyse kullanıcıya odasının ayrıldığına dair ekrana uyarı yazdırılır.
                        rooms[choiceroom - 1] = true;
                        System.out.println("Room Number :" + choiceroom + " " + "booked");

                        break;
                    }

                }
            } else {  /// ---> Eğer kullanıcı 2 kişilik oda seçmek istediyse;
                if (ısTheHostelFull()) {  // ---> Eğer otel doluysa ekrana uyarı verir ve oda seçimi yaptırmaz.
                    System.out.println("Unfortunately, the rooms are full. We can't take reservations.");
                    break;
                }
                  if (roomForTwoRoom()) {  // ---> Eğer  2 kişilik odalar doluysa ekrana uyarı verir ve oda seçimi yaptırmaz.
                    System.out.println("Unfortunately, our double rooms are full. We can't take reservations.");
                    break;
                } else { /// --->   hangi oda boşsa oda numarasını ekrana yazdırır ve kullanıcıdan seçmesini ister.
                    System.out.println("Please choose one of the available rooms below.");
                    for (int i = 0; i < 5; i++) {
                        if (!rooms[i]) {
                            System.out.print((i + 1) + " ");
                        }

                    }
                    choiceroom = input.nextInt();
                    if (choiceroom < 0 || choiceroom > 10) { /// ---> Eğer yanlış oda numarası girdiyse ekrana uyarı yazdırılır.
                        System.out.println("You entered the wrong room number. Please try again.");
                    } else { // ---> Doğru oda numarası girildiyse kullanıcıya odasının ayrıldığına dair ekrana uyarı yazdırılır.
                        rooms[choiceroom - 1] = true;
                        System.out.println("Room Number :" + choiceroom + " " + "booked..");

                        break;


                    }

                }
            }
        }
    }

    public String name;
    public String Surname;
    public String idNumber;
    public int howManyDay;
    public int breakfast1;
    public float toplamtutar ;

    public void personInformation() { /// ---> Kullanıcı Bilgilerini İsteyen Metottur.

        Scanner input = new Scanner(System.in);
        System.out.println("***WELCOME TO OUR HOSTEL***");
        System.out.println("PLEASE ENTER YOUR PERSONAL INFORMATION.");

        System.out.println("Name: ");
        name = input.next();
        System.out.println("Surname");
        Surname = input.next();
        System.out.println("Please enter your ID number:");
        idNumber = input.next();

        while (idNumber.length() != 11 ) { /// ---> Eğer kimlik no uzunluğu 11 den farklı ise ekrana uyarı yazdırılır.
            System.out.println("ERROR !!!");
            System.out.println("Please enter a valid ID number.");
            idNumber = input.next();
        }

        System.out.println("How many days will you stay in our hotel?");
        howManyDay = input.nextInt();

        System.out.println("Do you want breakfast?Breakfast is extra charge");
        System.out.println("Breakfast and dinner price 100 Turkish lira.Please press 1. if you want:");
        /// ---> Kullanıcıya kahvaltı ve akşam yemeği isteyip istemediğine dair seçim yaptırılır.  Eğer isteniyorsa 1'e basılır.
        breakfast1 = input.nextInt();
        if (breakfast1 != 1) {
            System.out.println("Breakfast is not confirmed.");
        }


    }

    public void finish() { /// ---> Kullanıcının bilgilerini ve seçimlerini yazdıran metottur.
        System.out.println("---------------/-/-/-----------------");
        System.out.println("---> Name: "  + name );
        System.out.println("---> Surname: "  + Surname );
        System.out.println("---> ID Number: " +idNumber);
        System.out.println("---> Room Number:"+choiceroom);


    }


    @Override
    public void theTotalAmount() { /// ---> Kullanıcının kalacağı gün sayısı ve seçimlerine göre ödeyeceği miktarı hesaplayan metottur.
        int twoperson=550;
        int threeperson = 750;
        Scanner input = new Scanner(System.in);
         while(breakfast1 ==1){
             System.out.println("Breakfast is  confirmed.");
             if(choice == 0){ ///----> Eğer kahvaltı seçilmediyse  ödenecek miktar:
                 toplamtutar = (howManyDay * 100) + (howManyDay * threeperson);
             }else { ///----> Eğer kahvaltı seçildiyse ödenecek miktar:
                 toplamtutar = (howManyDay * 100) + (howManyDay * twoperson);

             }
             System.out.println("Total amount you will pay:" + toplamtutar + "Tl.");
             break;
        }



    }


}