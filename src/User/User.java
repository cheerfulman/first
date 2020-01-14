package User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private int price;
    private ArrayList<Integer> history = new ArrayList<>();
//    public void his(){
//        for (Integer v : history) {
//            System.out.println(v);
//        }
//    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Integer> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Integer> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", price=" + price +
                ", history=" + history +
                '}';
    }
}
