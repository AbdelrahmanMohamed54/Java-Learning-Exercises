package OOP_ClassesAndObjects.InventoryManagementSystem;

public class Main {
    public static void main(String[] args) {
        // Create an instance of InventoryManager
        InventoryManager inventoryManager = new InventoryManager();

        // Create an instance of InventoryUI and pass the InventoryManager to it
        InventoryUI inventoryUI = new InventoryUI(inventoryManager);

        // Start the inventory management system
        inventoryUI.startMenu();
    }
}

// This Main class creates instances of InventoryManager and InventoryUI, passing the InventoryManager instance to InventoryUI. 
// It then starts the inventory management system by calling the startMenu method of InventoryUI.