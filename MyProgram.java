import java.util.Scanner;

public class MyProgram {
    public static void main(String[] args) {
        HolidayManager manager = new HolidayManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Apokty Calendar Tracker");

        while (true) {
            System.out.println("Select an Option:");
            System.out.println("1. Lookup a Specific Date");
            System.out.println("2. Add a Custom Feast Day");
            System.out.println("3. Rename an Existing Feast");
            System.out.println("4. Remove a Feast Day");
            System.out.println("5. Learn the History and  Math Behind the Calendar");
            System.out.println("6. Learn The Story of Pope Demetrius");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 1) {
                while (true) {
                    System.out.println("--- Select Date Input System ---");
                    System.out.println(" ");
                    System.out.println("1. Input Ge'ez/Ancient Date (Auto-Calculate Gregorian)");
                    System.out.println("2. Input Gregorian Date (Auto-Calculate Ge'ez/Ancient)");
                    System.out.print("Choice: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    boolean success = false;
                    if (type == 1){
                        System.out.print("Enter Ancient Month Index (0-12): ");
                        int am = scanner.nextInt();
                        System.out.print("Enter Ancient Day (1-30): ");
                        int ad = scanner.nextInt();
                        scanner.nextLine();
                        success = manager.processGeezOnlyLookup(am, ad);
                    }
                    if (type == 2){
                        System.out.print("Enter Gregorian Month (1-12): ");
                        int gm = scanner.nextInt();
                        System.out.print("Enter Gregorian Day (1-31): ");
                        int gd = scanner.nextInt();
                        scanner.nextLine();
                        success = manager.processGregorianOnlyLookup(gm, gd);
                    }

                    if (success == true) {
                        break;
                    }
                    System.out.println("Invalid dates, try again");
                } 
            } 
            if (choice == 2) {
                while (true) {
                    System.out.print("\nEnter Feast Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Gregorian Month (1-12): ");
                    int gm = scanner.nextInt();
                    System.out.print("Gregorian Day (1-31): ");
                    int gd = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (manager.createHoliday(name, gm, gd) == true) {
                        System.out.println("Feast added.");
                        break;
                    } 
                    System.out.println("Invalid dates entered! Please try again.");
                } 
            } 
            if (choice == 3) {
                System.out.print("Enter feast name to modify: ");
                String oldName = scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                
                if (manager.updateHoliday(oldName, newName) == true) {
                    System.out.println("Feast updated.");
                }else{
                    System.out.println("Feast not found.");
                } 
            } 
            if (choice == 4) {
                System.out.print("Enter feast name to delete: ");
                String deleteName = scanner.nextLine();
                
                if (manager.deleteHoliday(deleteName) == true) {
                    System.out.println("Feast removed.");
                } 
                else {
                    System.out.println("Feast not found.");
                } 
            } 
            if (choice == 5) {
                System.out.println("St. Demetrius invented a special calendar, composed of both lunar and solar years, to adjust the time of the Glorious Resurrection Feast so the feast doesn't come before the 1st week of April and not after the 1st week of May. St. Demetrius' calendar is composed of 19 solar lunar years. The lunar calendar is less than the solar calendar by 11 days and so in 19 years it will be 209 days. St. Demetrius divided those 209 days on his 19-years calendar by adding one month to every 2 or 3 years as follows: 1st solar year is more than the 1st lunar year by 11 days. The 2nd solar year is more than the 2nd lunar year by 11 + 11 = 22 days. The 3rd solar year is more than the 3rd lunar year by 22 + 11 = 33 days. So the 3rd lunar year will be a leap year with 13 months instead of 12 months and the other 3 days will be added to the 4th solar year. The 4th solar year will increase by 3 + 11 = 14 days, the 5th solar year will increase by 14 + 11 = 25 days so the 5th lunar year will be a leap year by subtracting 5 days from the 6th solar year. The 6th solar year will decrease by 5 days less and so 11 – 5 = 6 days. The 7th solar year will increase by 11 + 6 = 17 days, the 8th solar year will increase by 11 + 17 = 28 days so the 8th year will be a leap by subtracting 2 days from the following year. The 9th solar year will increase by 11 – 2 = 9 days, the 10th solar year will increase by 9 + 11 = 20 days, the 11th solar year will increase by 20 + 11 = 31 days so the 11th year will be a leap year and one day will be added to the following year. 12th year will increase by 1 + 11 = 12 days, 13th year will increase by 12 + 11 = 23 days, 14th year will increase by 23 + 11 = 34 days so the 14th year will be a leap and 4 days will be added to the following 15th year. The 15th year will increase by 11 + 4 = 15 days. The 16th year will increase by 15 + 11 = 26 days so 16th will be a leap year and 4 days will be subtracted from the following year. The 17th year will increase by 11 – 4 = 7 days. The 18th year will increase by 7 + 11 = 18 days, the 19th year will increase by 18 + 11 = 29 days, So the 19th will be a leap year. "); 
                System.out.println("");
                System.out.println("Source: Coptic Orthodox Diocese of the Southern United States, https://cdn.suscopts.org/files/pdf/copticchurch/hx6.pdf");
            } 
            if (choice == 6) {
                System.out.println("St. Demetrius was the 12th successor of St. Mark, the Apostle. Pope Julian, the 11th Patriarch saw a vision in his last days in which an angel said to him 'Who will come to you in the morning bringing a bunch of grapes, he will be your successor.' While St. Demetrius was dressing his vineyard, he saw a cluster of grapes had ripened early and harvested them. He decided to offer this first fruit to his pope. Once, Pope Julian saw Demetrius with his presentation of grapes, he spoke to his bishops saying 'this man will be your pope' and informed them about the vision that he saw. After St. Julian's departure to the Heavenly Kingdom, bishops, priests, and laymen consecrated St. Demetrius the 12th pope of Alexandria in 191 AD. St. Demetrius grew up in Alexandria as a vinedresser. His parents persistently persuaded him to get married, however, he and his wife decided to live the life of virginity. It has been a steadfast Coptic tradition that the pope should live a life of virginity even before the founding of monasticism and so some of the laymen of that time criticized St. Demetrius' papacy due to his marriage. St. Demetrius was a humble holy man and did not speak of his vow of virginity concerning his wife and himself. The Lord's Angel appeared in a vision unto him and commanded him to tell his congregation about his vow of celibacy. The next Sunday, after the Divine Liturgy, the pope asked his congregation to stay for a while. He and his wife held a censor with fired charcoal and walked around the church before the congregation who wondered how the fired charcoal did not burn one of them. St. Demetrius declared his vow with his wife to live as virgins before the Lord and so the congregation glorified the Lord who works through his saints. St. Demetrius was a simple vinedresser, who did not have much scholarly education in his formative years and so when he became the 12th pope he decided to rigorously study to compensate for what he had missed. He was very humble and used to sit at the feet of the church's deacon who taught him the hymns. He obtained much theological education at the School of Alexandria in a very short time. St. Demetrius was extremely intelligent and the Holy Spirit shined upon him. St. Demetrius invented a special calendar known as the'Apokty Calendar' which was used to determine the Glorious Resurrection Feast every year and is still used in our Oriental Churches today."); 
                System.out.println("");
                System.out.println("Source: Coptic Orthodox Diocese of the Southern United States, https://cdn.suscopts.org/files/pdf/copticchurch/hx6.pdf");
            } 
            if (choice == 7) {
                System.out.println("Goodbye!");
                break;
            } 
        } 
        scanner.close();
    } 
}
