package Hostel;
public abstract class Hostel {   /// ---> roomNumber kadar odaya sahip hotel rezervasyon sistemini temsil etmektedir.
    protected int roomNumber = 10;
    protected boolean[] rooms; // ---> roomNumber  uzunluğunda bir boolean dizidir.
    public Hostel() {
        //setRoomNumber(roomNumber);
        this.rooms = new boolean[this.roomNumber];
    }
    public Hostel(int roomNumber) {
       // setRoomNumber(roomNumber);
        this.rooms = new boolean[this.roomNumber];
    }
    public int getRoomNumber() { return roomNumber; }
    public boolean roomForTwoRoom() {  /// ---> tüm iki kişilik odalar doluysa true, dolu değilse false döner.
        for (int i = 0; i < 5; i++) {
            if ((!rooms[i])) {
                return false; }
        }return true;
    }
    public boolean roomForThreeRoom() { /// ---> tüm 3 kişilik odalar doluysa true , dolu değilse false döner.
        for (int i = 5; i < roomNumber; i++)
            if (!(rooms[i])) {
                return false; }return true;
    }
    public boolean ısTheHostelFull(){ /// ---> tüm odalar dolu ise true, değilse false döner.
        for(int i=0; i<10;i++) {
            if(!(rooms[i]))
                return false;
        }

        return true;
    }
    public  abstract void reserveARoom(); /// ---> soyut metod
    public  abstract void personInformation(); /// ---> soyut metod
    public abstract void finish();   /// ---> soyut metod
    public abstract void theTotalAmount();  /// ---> soyut metod



}








