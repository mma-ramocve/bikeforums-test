package pages;

public class Home {
    public static String homeUrl = "https://www.bikeforums.net/";
    public static String driverPath = "chromedriver.exe";

    public static String marketplaceTabXPath = "//a[contains(text(),'Marketplace')]";
    public static String marketplaceUrl = "https://www.bikeforums.net/market-place/";

    public static String logoXpath = "//header/div[1]/div[1]/div[1]/a[1]";

    public static String newPostsTabXPath = "//a[contains(text(),'New Posts')]";

    public static String forumTabXPath = "//header/nav[1]/div[2]/ul[1]/li[2]/a[1]";
    public static String bikeForumSubmenuXPath = "//header/nav[1]/div[2]/ul[1]/li[2]/ul[1]/li[4]/a[1]";
    public static String generalCyclingSubmenuXPath = "//a[contains(text(),'General Cycling Discussion')]";

    public static String contactUsTabXPath = "//body/footer[1]/div[1]/form[1]/div[1]/div[1]/div[2]/strong[1]/a[1]";

    public static String logInUsernameXpath = "//input[@id='navbar_username']";
    public static String logInPasswordXpath = "//input[@id='navbar_password']";
    public static String logInButtonXpath = "//body/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[3]/input[1]";

    public static String searchFieldXPath = "//header/nav[1]/div[3]/ul[1]/li[1]/form[1]/div[1]/div[1]/input[1]";
    public static String searchButtonXPath = "//header/nav[1]/div[3]/ul[1]/li[1]/form[1]/div[1]/button[1]";

}
