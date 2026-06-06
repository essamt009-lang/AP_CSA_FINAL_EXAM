import java.util.ArrayList;

public class HolidayManager 
{
    private ArrayList<Holiday> holidayList;
    private DateConverter converter;

    public HolidayManager() 
    {
        holidayList = new ArrayList<Holiday>();
        converter = new DateConverter();
        seedData();
    }

    private void seedData() 
    {
        holidayList.add(new Holiday("St. Peter (ጴጥሮስ )", 5, 11)); 
        holidayList.add(new Holiday("St. Andrew (ማቴዎስ)", 10, 22)); 
        holidayList.add(new Holiday("St. Jacob Son of Zebedee (ያዕቆብ ወልደ ዘብዴዎስ )", 11, 27)); 
        holidayList.add(new Holiday("St. John (ዮሓንስ)", 12, 13)); 
        holidayList.add(new Holiday("St. Philip (ፊልጶስ)", 11, 27)); 
        holidayList.add(new Holiday("St. Bartholomew (በርተሎሜዎስ)", 9, 11)); 
        holidayList.add(new Holiday("St. Thomas (ቶማስ)", 11, 27)); 
        holidayList.add(new Holiday("St. Matthew (ማቴዎስ)", 10, 22)); 
        holidayList.add(new Holiday("St. Jacob Son of Alphaeus (ያዕቆብ ወልደ እልፍዮስ)", 9, 11)); 
        holidayList.add(new Holiday("St. Jude (ታዴዎስ)", 10, 22)); 
        holidayList.add(new Holiday("St. Nathanel (ናትናኤል)", 11, 27)); 
        holidayList.add(new Holiday("St. Andrew (እንድርያስ)", 12, 13)); 
        holidayList.add(new Holiday("Birth of Christ (ልደት)", 1, 7)); 
        holidayList.add(new Holiday("Birth of Saint Mary (ልደታ)", 5, 9)); 
        holidayList.add(new Holiday("The Ascension of Mary(ፍልሰታ)", 8, 22)); 
        holidayList.add(new Holiday("The Ascension of Mary(ፍልሰታ)", 8, 22)); 
    }

    public boolean processGeezOnlyLookup(int geezMonthIndex, int geezDay)
    {
        int[] calculatedGreg = converter.convertGeezToGregorian(geezMonthIndex, geezDay);
        int gm = calculatedGreg[0];
        int gd = calculatedGreg[1];
        return runCalculatedLookup(geezMonthIndex, geezDay, gm, gd);
    }

    public boolean processGregorianOnlyLookup(int gregMonth, int gregDay)
    {
        int[] calculatedGeez = converter.convertGregorianToGeez(gregMonth, gregDay);
        int am = calculatedGeez[0];
        int ad = calculatedGeez[1];
        return runCalculatedLookup(am, ad, gregMonth, gregDay);
    }

    private boolean runCalculatedLookup(int ancientMonthIndex, int ancientDay, int gregMonth, int gregDay)
    {
        if (converter.checkValidDate(ancientMonthIndex, ancientDay, gregMonth, gregDay) == false)
        {
            return false;
        }

        converter.printParallelCalendars(ancientMonthIndex, ancientDay, gregMonth, gregDay);
        boolean found = false;
        
        for (int i = 0; i < holidayList.size(); i++) 
        {
            Holiday h = holidayList.get(i);
            if (h.getGregMonth() == gregMonth && h.getGregDay() == gregDay) 
            {
                System.out.println("Feast Day Found: " + h.getName());
                found = true;
            }
        }
        
        if (ancientDay == 1) { 
            System.out.println("Feast Day Found: ልደታ (Feast of The Birth of Mary"); found = true; 
        }
        if (ancientDay == 6) { 
            System.out.println("Feast Day Found: አርሴማ (Feast of Saint Arsema"); found = true; 
        }
        if (ancientDay == 7) { 
            System.out.println("Feast Day Found: ስላሴ (Feast of The Trinity"); found = true; 
        }
        if (ancientDay == 13) { 
            System.out.println("Feast Day Found: ቅዱስ ሩፋኤል (Feast of Saint Raphael"); found = true; 
        }
        if (ancientDay == 19) { 
            System.out.println("Feast Day Found: ቅዱስ ገብርኤል (Feast of Saint Gabriel"); found = true; 
        }
        if (ancientDay == 12) { 
            System.out.println("Feast Day Found: ቅዱስ ሚካኤል (Feast of Saint Michael)"); found = true; 
        }
        if (ancientDay == 21) { 
            System.out.println("Feast Day Found: በዓለ ማርያም (Feast of St. Mary)"); found = true; 
        }
        if (ancientDay == 22) { 
            System.out.println("Feast Day Found: ቅዱስ ዑራኤል (Feast of Saint Uraiel)""); found = true; 
        }
        if (ancientDay == 29) { 
            System.out.println("Feast Day Found: በዓለ እግዚአብሔር (Feast of The Lord of the World)"); found = true; 
        }
        if (gregMonth == 8 && gregDay >= 7 && gregDay <= 15) {
            System.out.println("Fasting Period: ጾመ ፍልሰታ (Fast of the Assumption)"); 
        }
        if (gregMonth == 10 && gregDay >= 6) { 
            System.out.println("Fasting Season: ዘመነ ጽጌ (Season of The Flower)"); 
        }
        if (gregMonth == 11 && gregDay <= 13) { 
            System.out.println("Fasting Season: ዘመነ ጽጌ (Season of The Flower)");
        }
        if (gregMonth == 11 && gregDay >= 25) {
            System.out.println("Fasting Period: ጾመ ነቢያት (Fast of the Prophets)"); 
        }
        if (gregMonth == 12) { 
            System.out.println("Fasting Period: ጾመ ነቢያት (Fast of the Prophets)"); 
        }
        if (gregMonth == 1 && gregDay <= 6) { 
            System.out.println("Fasting Period: ጾመ ነቢያት (Fast of the Prophets)"); 
        }
        if (found == false) { 
            System.out.println("No fixed celebration registered today.");
        }
        return true;
    }

    public boolean createHoliday(String name, int m, int d) 
    { 
        if (converter.checkValidDate(0, 1, m, d) == false) { return false; }
        holidayList.add(new Holiday(name, m, d)); 
        return true; 
    }
    
    public boolean updateHoliday(String t, String n) 
    { 
        for (int i = 0; i < holidayList.size(); i++) 
        { 
            if (holidayList.get(i).getName().equals(t)) { holidayList.get(i).setName(n); return true; } 
        } 
        return false; 
    }
    
    public boolean deleteHoliday(String t) 
    { 
        for (int i = 0; i < holidayList.size(); i++) 
        { 
            if (holidayList.get(i).getName().equals(t)) { holidayList.remove(i); return true; } 
        } 
        return false; 
    }
}