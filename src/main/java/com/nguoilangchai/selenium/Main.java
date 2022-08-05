package com.nguoilangchai.selenium;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        searchGoogle();
    }

    public static void searchGoogle() throws InterruptedException {
        //1. Khai báo biến đại diện/ trỏ đến trình duyệt sẽ được mở/ được new 
        WebDriver myBrowser; // biến Object thuộc bộ thư viện Selenium
        // thằng này sẽ trỏ đến trình duyệt khi được new
        // mỗi lần new là 1 lần trình duyệt được mở ra, 1 vùng được cấp
        // 1 Object Trình duyệt được new trong HEAP

        //2. Khai báo người em song sinh, gã sẽ điều khiển trình duyệt.
        // nó luôn được phát hành song song với phiên bản trình duyệt mà bá tánh xài
        // tương thích version với trình duyệt đang xài !!! BẮT BUỘC !!!
        //WebDriver là tên gọi của người anh em song sinh, là file .exe/ .dll
        String driverPath = "chromedriver.exe";

        //3. new Trình duyệt (mở trình duyệt) gắn kết với người em song sinh
        System.setProperty("webdriver.chrome.driver", driverPath);
        //giải thích: báo với máy ảo Java rằng, có 1 thằng .exe muốn tham gia vào
        //danh sách class mà JVM quản lý
        //.EXE .DLL, xả 1 đống class điều khiển trình duyệt vào trong JVM lúc run-time
        // và gọi nhóm class này là webdriver.chrome.driver -> hằng số quy ước sẵn rồi
        //code Selenium qua class WebDriver, ChromeDriver sẽ xài ở dưới đây
        //biết cách chơi với các class của .exe vừa rồi, vì chúng đang cùng trong máy ảo 
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");

        myBrowser = new ChromeDriver(opt);

        // 4. Viết code dùng Selenium nói chuyện với người song sinh - driver
        // driver biết cách nói chuyện với trình duyệt thật đã new !!!
        // trình duyệt sẵn sàng thông qua người em đưa hết data(trang web trong ram)
        // cho mình dưới dạng cây DOM = Document Object Model
        // trang HTML trả về trong RAM của trình duyệt được xem là 1 cây các object
        // node/tag được xem là 1 object thuộc nhóm WebElement 

        myBrowser.get("http://localhost:8080/Project_banhang/home");
        myBrowser.manage().window().maximize();

        Thread.sleep(2000);
        WebElement searchBox = myBrowser.findElement(By.xpath("//a[contains(text(),'Login')]"));
        searchBox.click();
        
        Thread.sleep(1000);
        WebElement searchUserName = myBrowser.findElement(By.name("user"));
        searchUserName.sendKeys("nam");
        Thread.sleep(1000);

        WebElement searchPass = myBrowser.findElement(By.name("pass"));
        searchPass.sendKeys("nam123");
        Thread.sleep(1000);

        WebElement btnLogin = myBrowser.findElement(By.xpath("//body/div[@id='logreg-forms']/form[1]/button[1]"));
        btnLogin.click();
        Thread.sleep(1000);

        Thread.sleep(1000);

        myBrowser.findElement(By.xpath("//a[contains(text(),'Hello nam')]")).click();
        Thread.sleep(1000);

        myBrowser.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")).click();
        Thread.sleep(1000);

        WebElement searchLinkImage = myBrowser.findElement(By.name("linkImage"));
        searchLinkImage.click();

        searchLinkImage.clear();
        
        Thread.sleep(3000);

        searchLinkImage.sendKeys("https://scontent.fsgn1-1.fna.fbcdn.net/v/t1.6435-9/69956918_2293523444271503_8404178755391586304_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=19026a&_nc_ohc=rYIJ6Lwlp6UAX-QrKOa&_nc_ht=scontent.fsgn1-1.fna&oh=00_AT-fxryH1_Fo2RiH4RZzCduZp4BeKCzmuenCvcoRknyEtw&oe=6312BBC9");

        Thread.sleep(1000);

        searchLinkImage.submit();
        
        Thread.sleep(2000);
        
        myBrowser.findElement(By.xpath("//a[contains(text(),'Back')]")).click();
        
        Thread.sleep(2000);
        
        myBrowser.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        Thread.sleep(1000);
        
        myBrowser.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        
        Thread.sleep(3000);
        myBrowser.quit();

    }
}
