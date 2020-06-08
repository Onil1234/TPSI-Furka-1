
package wizut.tpsi.ogloszenia.jpa;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "offer")
public class Offer {
    
    public Offer(Integer id, String title, Integer year, Integer mileage, BigDecimal engineSize, Integer enginePower, Integer doors, String colour, String description, Integer price, CarModel model, BodyStyle bodyStyle, FuelType fuelType) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.mileage = mileage;
        this.engineSize = engineSize;
        this.enginePower = enginePower;
        this.doors = doors;
        this.colour = colour;
        this.description = description;
        this.price = price;
        this.model = model;
        this.bodyStyle = bodyStyle;
        this.fuelType = fuelType;
    }
    
    public Offer(){
        
    }
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Integer id;

    @NotNull
    @Size(max = 255, min = 5, message = "Minimum 5, max 255 znaków!")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Pole puste")
    @Min(value = 1980, message = "Rok musi być wiższy niż {value}")
    @Max(value = 2022, message = "Rok musi być niższy niż {value}")
    @Column(name = "year")
    private Integer year;

    @NotNull(message = "Pole puste")
    @Min(value = 0, message = "Przebieg musi być dodatni!")
    @Column(name = "mileage")
    private Integer mileage;

    @NotNull(message = "Pole puste")
    @Min(value = 0, message = "Pojemnosc musi byc dodatnia!")
    @Column(name = "engine_size")
    //private BigDecimal engineSize;
    private BigDecimal engineSize;

    @NotNull(message = "Pole puste")
    @Min(value = 0, message = "Moc musi byc dodatnia!")
    @Column(name = "engine_power")
    private Integer enginePower;

    @NotNull(message = "Pole puste")
    @Min(value = 1, message = "Liczba drzwi musi być wieksza od {value}")
    @Max(value = 5, message = "Liczba drzwi musi być mniejsza od {value}")
    @Column(name = "doors")
    private Integer doors;

    @NotNull(message = "Pole puste")
    @Size(max = 30, min = 3, message = "Minimum 3 znaki!")
    @Column(name = "colour")
    private String colour;

    @NotNull(message = "Pole puste")
    @Lob
    @Size(max = 65535, min = 5, message = " Minimum 5 znaków!")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Pole puste")
    @Min(value = 0, message = "Cena musi być dodatnia!")
    @Column(name = "price")
    private Integer price;

    @NotNull(message = "Pole puste")
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne
    private CarModel model;

    @NotNull(message = "Pole puste")
    @JoinColumn(name = "body_style_id", referencedColumnName = "id")
    @ManyToOne
    private BodyStyle bodyStyle;

    @NotNull(message = "Pole puste")
    @JoinColumn(name = "fuel_type_id", referencedColumnName = "id")
    @ManyToOne
    private FuelType fuelType;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public BigDecimal getEngineSize() {
        return engineSize;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public Integer getDoors() {
        return doors;
    }

    public String getColour() {
        return colour;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public CarModel getModel() {
        return model;
    }

    public BodyStyle getBodyStyle() {
        return bodyStyle;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngineSize(BigDecimal engineSize) {
        this.engineSize = engineSize;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public void setBodyStyle(BodyStyle bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }


    
    
    
    
    
}
