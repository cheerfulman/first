package Dao;

import User.User;
import UserException.UserException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static String path = "H:/IDEA/project/login2/user2.xml";

    public static User findByUsername(String username)  {
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(path);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        //List<Element> list = new ArrayList<>();
        List<Node> list =  doc.selectNodes("//username");
        for(Node n : list){
            if(username.equals(n.getText())){
                User user = new User();
                user.setUsername(n.getText());
                Element parent = n.getParent();
                Element pass = parent.element("password");
                user.setPassword(pass.getText());

                return user;
            }
        }
        return null;
    }
    public static void add(User user){
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            Element root = doc.getRootElement();
            Element u = root.addElement("user");

            Element username = u.addElement("username");
            username.addText(user.getUsername());

            Element password = u.addElement("password");
            password.addText(user.getPassword());

            /*
            回写
             */
            OutputFormat format = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path),format);
            xmlWriter.write(doc);
            xmlWriter.close();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static User addPrice(User user){
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(path);
            List<Node> list = doc.selectNodes("//username");
            for(Node n : list){
                if(n.getText().equals(user.getUsername())){
                    Element parent = n.getParent();
                    Element price = parent.element("price");
                    ///parent.e
                    if(price != null){
                        Element per = price.addElement("per");
                        per.addText(String.valueOf(user.getPrice()));
                    }else{
                        price = parent.addElement("price");
                        Element per = price.addElement("per");
                        per.addText(String.valueOf(user.getPrice()));
                    }
                    /**
                     * 回写
                     */
                    user.getHistory().add(user.getPrice());
                    OutputFormat format = OutputFormat.createPrettyPrint();
                    try {
                        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path),format);
                        xmlWriter.write(doc);
                        xmlWriter.close();
                        return user;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }return user;
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
