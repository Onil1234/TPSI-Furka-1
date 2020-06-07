
package wizut.tpsi.ogloszenia.jpa;


public class OfferFilter {
    
    public Integer manufacturerId;
    public Integer modelId;
    public Integer yearFrom;
    public Integer yearTo;
    public Integer fuelTypeId;

    
    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    public void setFuelTypeId(Integer fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public Integer getFuelTypeId() {
        return fuelTypeId;
    }

    
    
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
    
    
    
    
    
}
