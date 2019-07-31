public class Item
{
    private int imageID;
    private int itemID;
    private String itemName;
    private String description;
    private String status;
    private String location;

    public Item(int imageID, int itemID, String itemName, String description, String status, String location) {
        this.imageID = imageID;
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.status = status;
        this.location = location;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
