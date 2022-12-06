package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private static final String HOMEPAGE_URL = "https://www.alphaindustries.com/";
    private final WebDriver driver;

    @FindBy(xpath = "//button[@class='mc_list_top mc_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@class='mc_search_field']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='ais-filter-select']")
    private WebElement filterButton;

    @FindBy(xpath = "//ul[@class='ais-RefinementList-list']/li[1]")
    private WebElement colorElement;

    @FindBy(xpath = "//div[@class='ais-facet-options.size-container']/div/div/div/div/ul[@class='ais-RefinementList-list']/li[4]")
    private WebElement sizeElement;

    @FindBy(xpath = "//select[@class='ais-SortBy-select']")
    private WebElement orderDropdown;

    @FindBy(xpath = "//option[@class='ais-SortBy-option' and @value='shopify_products_recently_ordered_count_desc']")
    private WebElement orderElement;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage OpenPage() {
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void EnterTextToSearchField(String searchText) {
        searchButton.click();
        searchField.sendKeys(searchText);
        searchField.submit();
    }

    public void ChooseColorAndSize() {
        filterButton.click();
        colorElement.click();
        sizeElement.click();
        orderDropdown.click();
        orderElement.click();
    }
}
