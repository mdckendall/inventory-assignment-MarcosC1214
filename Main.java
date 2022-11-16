import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
  String name;
  String serial;
  Integer value;

  public Inventory(String name, String serial, Integer value) {
    this.name = name;
    this.serial = serial;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getSerial() {
    return serial;
  }

  public Integer getValue() {
    return value;
  }
}

class Main {
  public static void main(String[] args) {
    ArrayList<Inventory> Items = new ArrayList<Inventory>();
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("Press 1 to add an item.\n" + "Press 2 to delete an item.\n" + "Press 3 to update an item.\n"
          + "Press 4 to show all the items.\n" + "Press 5 to quit the program.");
      Inventory i;
      Integer in = scanner.nextInt();
      if (in == 1 || in == 2 || in == 3 || in == 4 || in == 5) {
        if (in == 1) {
          System.out.println("Enter the name:");
          scanner.nextLine();
          String pn = scanner.nextLine();
          System.out.println("Enter the serial number:");
          String sn = scanner.nextLine();
          System.out.println("Enter the value in dollars (whole number):");
          Integer v = scanner.nextInt();
          scanner.nextLine();
          i = new Inventory(pn, sn, v);
          Items.add(i);
        }
        if (in == 2) {
          System.out.println("Enter the serial number of the item to delete:");
          scanner.nextLine();
          String check = scanner.nextLine();
          for (int j = 0; j < Items.size(); j++) {
            if (Items.get(j).getSerial().equals(check)) {
              Items.remove(j);
            }
          }
        }
        if (in == 3) {
          System.out.println("Enter the serial number of the item to change:");
          scanner.nextLine();
          String find = scanner.nextLine();
          System.out.println("Enter the new name:");
          String other = scanner.nextLine();
          System.out.println("Enter the new value in dollars (whole number):");
          Integer val = scanner.nextInt();
          scanner.nextLine();
          for (int k = 0; k < Items.size(); k++) {
            if (Items.get(k).getSerial().equals(find)) {
              Items.set(k, new Inventory(other, Items.get(k).getSerial(), val));
            }
          }
        }
        if (in == 4) {
          for (int p = 0; p < Items.size(); p++) {
            System.out.println(Items.get(p).getName() + "," + Items.get(p).getSerial() + "," + Items.get(p).getValue());
          }
        }
        if (in == 5) {
          break;
        }
      } else {
        break;
      }
    } while (true);
  }
}