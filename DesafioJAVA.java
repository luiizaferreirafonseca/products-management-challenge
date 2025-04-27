import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DesafioJAVA {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> segments = new ArrayList<>();
        ArrayList<String> brands = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        while (true) {
            String menu = "Choose an option:\n" +
                          "1. Register a product\n" +
                          "2. List names\n" +
                          "3. Update name\n" +
                          "4. Remove name\n" +
                          "5. Exit";

            String option = JOptionPane.showInputDialog(null, menu);

            switch (option) {
                case "1":
                    String nameToAdd = JOptionPane.showInputDialog("Enter the product name:");
                    names.add(nameToAdd);

                    String segmentToAdd = JOptionPane.showInputDialog("Enter the product segment:");
                    segments.add(segmentToAdd);

                    String brandToAdd = JOptionPane.showInputDialog("Enter the product brand:");
                    brands.add(brandToAdd);

                    Double priceToAdd = Double.parseDouble(JOptionPane.showInputDialog("Enter the product price:"));
                    prices.add(priceToAdd);
                    JOptionPane.showMessageDialog(null, "Product successfully added!");
                    break;

                case "2":
                    if (names.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are no registered products.");
                    } else {
                        String productList = "Product list:\n";
                        for (int i = 0; i < names.size(); i++) {
                            productList += (i + 1) + ". Name: " + names.get(i) +
                                           ", Segment: " + segments.get(i) +
                                           ", Brand: " + brands.get(i) +
                                           ", Price: $" + prices.get(i) + "\n";
                        }
                        JOptionPane.showMessageDialog(null, productList);
                    }
                    break;

                case "3":
                    if (names.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There are no registered products to filter.");
                    } else {
                        String filterType = JOptionPane.showInputDialog("Do you want to filter by:\n1. Brand\n2. Segment");

                        if (filterType.equals("1")) {
                            String brandFilter = JOptionPane.showInputDialog("Enter the brand name to filter:");
                            String result = "Products of brand " + brandFilter + ":\n";

                            for (int i = 0; i < brands.size(); i++) {
                                if (brands.get(i).equalsIgnoreCase(brandFilter)) {
                                    result += (i + 1) + ". Name: " + names.get(i) +
                                              ", Segment: " + segments.get(i) +
                                              ", Price: $" + prices.get(i) + "\n";
                                }
                            }
                            JOptionPane.showMessageDialog(null, result);
                        } else if (filterType.equals("2")) {
                            String segmentFilter = JOptionPane.showInputDialog("Enter the segment name to filter:");
                            String result = "Products of segment " + segmentFilter + ":\n";

                            for (int i = 0; i < segments.size(); i++) {
                                if (segments.get(i).equalsIgnoreCase(segmentFilter)) {
                                    result += (i + 1) + ". Name: " + names.get(i) +
                                              ", Brand: " + brands.get(i) +
                                              ", Price: $" + prices.get(i) + "\n";
                                }
                            }
                            JOptionPane.showMessageDialog(null, result);
                        } else {
                            JOptionPane.showMessageDialog(null, "No products found with this filter.");
                        }
                    }
                    break;

                case "4":
                    String indexToUpdateStr = JOptionPane.showInputDialog("Enter the number of the product to update (1 to " + names.size() + "):");
                    int indexToUpdate = Integer.parseInt(indexToUpdateStr) - 1;

                    Double newPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the new product price:"));
                    prices.set(indexToUpdate, newPrice);
                    break;

                case "5":
                    String indexToRemoveStr = JOptionPane.showInputDialog("Enter the number of the product to remove (1 to " + names.size() + "):");
                    int indexToRemove = Integer.parseInt(indexToRemoveStr) - 1;
                    names.remove(indexToRemove);
                    brands.remove(indexToRemove);
                    segments.remove(indexToRemove);
                    prices.remove(indexToRemove);
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, "Exiting the program. See you soon!");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option! Please try again.");
                    break;
            }
        }
    }
}
