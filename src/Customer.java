import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer implements dataBaseQuaries{
    DateTimeFormatter getDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    DateTimeFormatter getTime = DateTimeFormatter.ofPattern("HH:mm");
    LocalDateTime now = LocalDateTime.now();

    String name;
    String date;
    String time;
    int numberOfItems;
    float customerTotal;
    float givenMoney;
    float balance;

    public void saveData(String CustomerName, int totalItemCount, float totalPrice, float cGivenMoney){
        this.name = CustomerName;
        this.numberOfItems = totalItemCount;
        this.customerTotal = totalPrice;
        this.givenMoney = cGivenMoney;
        this.date = getDate.format(now);
        this.time = getTime.format(now);
        this.balance = givenMoney - customerTotal;

        String query = "INSERT INTO `customers`(`customerName`, `numOfItems`, `customerTotal`, `givenMoney`, `balance`, `date`, `time`) VALUES (?, ?, ?, ?, ?, ?, ?)";        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,dbpassword);
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, name);
            pst.setInt(2, numberOfItems);
            pst.setFloat(3,customerTotal);
            pst.setFloat(4, givenMoney);
            pst.setFloat(5, balance);
            pst.setString(6, date);
            pst.setString(7, time);
            pst.executeUpdate();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void moveToFinal(String adminFirstName, String adminLastName){
        FinalBackground finalBackground = new FinalBackground();
        if(name.isEmpty()){
            finalBackground.finalFrame(numberOfItems, customerTotal, givenMoney, balance, date, time, adminFirstName, adminLastName);
        }
        else{
            finalBackground.finalFrame(name, numberOfItems, customerTotal, givenMoney, balance, date, time, adminFirstName, adminLastName);
        }
    }
}


