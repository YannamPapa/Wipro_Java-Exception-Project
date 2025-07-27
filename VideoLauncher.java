import java.util.Scanner;

public class VideoLauncher {
    public static void main(String[] args) {
        VideoStore vs = new VideoStore();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Add Video");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1..6): ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the video you want to add: ");
                    String name = sc.nextLine();
                    vs.addVideo(name);
                    break;
                case 2:
                    System.out.print("Enter the name of the video to check out: ");
                    name = sc.nextLine();
                    vs.doCheckout(name);
                    break;
                case 3:
                    System.out.print("Enter the name of the video to return: ");
                    name = sc.nextLine();
                    vs.doReturn(name);
                    break;
                case 4:
                    System.out.print("Enter the name of the video to rate: ");
                    name = sc.nextLine();
                    System.out.print("Enter rating (0–10): ");
                    int rating = sc.nextInt();
                    vs.receiveRating(name, rating);
                    break;
                case 5:
                    vs.listInventory();
                    break;
                case 6:
                    System.out.println("Thank you for using the Video Store App!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}

class Video {
    private String videoName;
    private boolean checkout;
    private int rating;

    public Video(String name) {
        this.videoName = name;
        this.checkout = false;
        this.rating = 0;
    }

    public String getName() {
        return videoName;
    }

    public void doCheckout() {
        checkout = true;
    }

    public void doReturn() {
        checkout = false;
    }

    public void receiveRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public boolean getCheckout() {
        return checkout;
    }
}

class VideoStore {
    private Video[] store = new Video[10];
    private int count = 0;

    public void addVideo(String name) {
        store[count] = new Video(name);
        System.out.println("Video \"" + name + "\" added successfully.");
        count++;
    }

    public void doCheckout(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void doReturn(String name) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void receiveRating(String name, int rating) {
        for (int i = 0; i < count; i++) {
            if (store[i].getName().equalsIgnoreCase(name)) {
                store[i].receiveRating(rating);
                System.out.println("Rating \"" + rating + "\" mapped to video \"" + name + "\".");
                return;
            }
        }
        System.out.println("Video not found.");
    }

    public void listInventory() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Video Name\t|\tCheckout\t|\tRating");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println(store[i].getName() + "\t\t|\t" + store[i].getCheckout() + "\t\t|\t" + store[i].getRating());
        }
    }
}
